package Planner;

import Draggable.Draggable;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Authority extends Draggable {
    protected String name;
    protected TimeTable timeTable;

    public Authority(String name) {
        this.name = name;
        this.addBox();
    }

    private void addBox() {
        HBox box = new HBox();
        box.setPrefSize(200, 50);
        box.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-alignment: center");
        Label label = new Label(this.name);
        label.prefWidthProperty().bind(box.widthProperty());
        label.prefHeightProperty().bind(box.heightProperty());
        label.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center");
        box.getChildren().add(label);

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

    public TimeTable getTimeTable() {
        return this.timeTable;
    }

    public void setChildren(ObservableList<Node> children) {
        this.getChildren().setAll(children);
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }

    public void makeDraggable(Pane rootPane, Node... possibleContainers) {
        super.makeDraggable(rootPane, possibleContainers);
    }

    public void makeDraggable(Pane rootPane, ArrayList<Node> possibleContainers) {
        super.makeDraggable(rootPane, possibleContainers);
    }
}
