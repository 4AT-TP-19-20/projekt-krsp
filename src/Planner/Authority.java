package Planner;

import Draggable.Draggable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;

public class Authority extends Draggable {
    protected String name;
    protected HashMap<String, ArrayList<Interval>> timeTable = new HashMap<String, ArrayList<Interval>>() {{
        put("Monday", new ArrayList<>());
        put("Tuesday", new ArrayList<>());
        put("Wednesday", new ArrayList<>());
        put("Thursday", new ArrayList<>());
        put("Friday", new ArrayList<>());
    }};
    protected Label nameLabel = new Label();

    public Authority(String name) {
        this.name = name;
        this.addBox();
    }

    private void addBox() {
        HBox box = new HBox();
        box.setPrefSize(200, 50);
        box.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-alignment: center");
        nameLabel.setText(this.name);
        nameLabel.prefWidthProperty().bind(box.widthProperty());
        nameLabel.prefHeightProperty().bind(box.heightProperty());
        nameLabel.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center");
        box.getChildren().add(nameLabel);
        this.getChildren().add(box);
    }

    @Override
    protected Node getCopyOfInstance() {
        Authority copy = new Authority(this.name);
        copy.setTimeTable(this.timeTable);
        return copy;
    }

    public String getName() {
        return this.name;
    }

    public HashMap<String, ArrayList<Interval>> getTimeTable() {
        return this.timeTable;
    }

    public void setTimeTable(HashMap<String, ArrayList<Interval>> timeTable) {
        this.timeTable = timeTable;
    }

    public void makeDraggable(Pane rootPane, Node... possibleContainers) {
        super.makeDraggable(rootPane, possibleContainers);
    }

    public void makeDraggable(Pane rootPane, ArrayList<Node> possibleContainers) {
        super.makeDraggable(rootPane, possibleContainers);
    }

    public void setName(String name) {
        this.name = name;
        nameLabel.setText(this.name);
    }
}
