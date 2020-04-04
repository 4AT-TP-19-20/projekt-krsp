package Main;

import Planner.Authority;
import Planner.Council;
import Planner.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Controller {
    @FXML
    private VBox box3;
    @FXML
    private VBox box2;
    @FXML
    private VBox box1;
    @FXML
    private Pane root;
    private ObservableList<Teacher> teachers = FXCollections.observableArrayList();
    private ObservableList<Authority> authorities = FXCollections.observableArrayList();
    private ObservableList<Council> councils = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        this.teachers.addListener((ListChangeListener<Teacher>) c -> this.box1.getChildren().setAll(this.teachers));
        this.authorities.addListener((ListChangeListener<Authority>) c -> this.box2.getChildren().setAll(this.authorities));
        // this.councils.addListener((ListChangeListener<Council>) c -> this.box1.getChildren().setAll(this.councils));

        // Code for debugging
        this.box1.setStyle("-fx-border-color: black; -fx-background-color: red");
        this.box1.setPrefSize(250, 250);
        this.box2.setStyle("-fx-border-color: black; -fx-background-color: green");
        this.box2.setPrefSize(250, 250);
        this.box3.setStyle("-fx-border-color: black; -fx-background-color: yellow");
        this.box3.setPrefSize(250, 500);

        Authority authority1 = new Authority("Authority 1");
        authority1.makeDraggable(this.root, this.box3);
        Authority authority2 = new Authority("Authority 2");
        authority2.makeDraggable(this.root, this.box3);
        this.authorities.add(authority1);
        this.authorities.add(authority2);

        Teacher teacher1 = new Teacher("Teacher 1");
        teacher1.makeDraggable(this.root, this.box3);
        Teacher teacher2 = new Teacher("Teacher 2");
        teacher2.makeDraggable(this.root, this.box3);
        this.teachers.add(teacher1);
        this.teachers.add(teacher2);
    }
}
