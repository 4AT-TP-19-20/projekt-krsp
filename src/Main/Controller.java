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
    }
}
