package Main;

import Planner.Authority;
import Planner.Council;
import Planner.Teacher;
import com.sun.javafx.beans.event.AbstractNotifyListener;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.Stack;

public class MainSceneController {

    @FXML
    private VBox councilsContainer;
    @FXML
    private VBox authorityContainer;
    @FXML
    private VBox teachersContainer;

    private ObservableList<Council> councilList = FXCollections.observableArrayList();
    private ObservableList<Teacher> teachersList = FXCollections.observableArrayList();
    private ObservableList<Authority> authorityList = FXCollections.observableArrayList();


    @FXML
    private void initialize() {
        // Adding buttons for allowing the user to add councils, teachers and authorities
        StackPane addCouncilButton = createCircularButton();
        StackPane addTeacherButton = createCircularButton();
        StackPane addAuthorityButton = createCircularButton();
        addCouncilButton.setOnMouseClicked(e -> this.addCouncil());
        addTeacherButton.setOnMouseClicked(e -> this.addTeacher());
        addAuthorityButton.setOnMouseClicked(e -> this.addAuthority());
        this.councilsContainer.getChildren().add(addCouncilButton);
        this.teachersContainer.getChildren().add(addTeacherButton);
        this.authorityContainer.getChildren().add(addAuthorityButton);
        this.councilList.addListener((ListChangeListener<Council>) c -> {
            this.councilsContainer.getChildren().setAll(this.councilList);
            this.councilsContainer.getChildren().add(addCouncilButton);
        });
        this.teachersList.addListener((ListChangeListener<Teacher>) c -> {
            this.teachersContainer.getChildren().setAll(this.teachersList);
            this.teachersContainer.getChildren().add(addTeacherButton);
        });
        this.authorityList.addListener((ListChangeListener<Authority>) c -> {
            this.authorityContainer.getChildren().setAll(this.authorityList);
            this.authorityContainer.getChildren().add(addAuthorityButton);
        });
    }

    private void addCouncil() {
        System.out.println("Adding Council");
    }

    private void addTeacher() {
        System.out.println("Adding Teacher");
    }

    private void addAuthority() {
        System.out.println("Adding Authority");
    }


    // Helper function for creating a circular button
    public static StackPane createCircularButton() {
        StackPane pane = new StackPane();
        Circle circle = new Circle(20);
        Line topDown = new Line(20, 13, 20, 26);
        Line leftRight = new Line(13, 20, 26, 20);
        EventHandler<? super MouseEvent> entered = (EventHandler<MouseEvent>) event -> {
            circle.setStyle("-fx-stroke-width: 2px; -fx-stroke: black; -fx-fill: #6EC30C");
            pane.setScaleX(1.1);
            pane.setScaleY(1.1);
        };
        EventHandler<? super MouseEvent> exited = (EventHandler<MouseEvent>) event -> {
            circle.setStyle("-fx-stroke-width: 2px; -fx-stroke: black; -fx-fill: lime");
            pane.setScaleX(1);
            pane.setScaleY(1);
        };
        circle.setOnMouseEntered(entered);
        circle.setOnMouseExited(exited);
        circle.setStyle("-fx-stroke-width: 2px; -fx-stroke: black; -fx-fill: lime");
        topDown.setOnMouseEntered(entered);
        topDown.setOnMouseExited(exited);
        topDown.setStyle("-fx-stroke-width: 2px; -fx-stroke: black");
        leftRight.setOnMouseEntered(entered);
        leftRight.setOnMouseExited(exited);
        leftRight.setStyle("-fx-stroke-width: 2px; -fx-stroke: black");
        pane.setPrefSize(40, 40);
        pane.getChildren().addAll(circle, topDown, leftRight);
        return pane;
    }

    // Function for starting the calculation process
    @FXML
    private void calculate(MouseEvent mouseEvent) {
    }
}
