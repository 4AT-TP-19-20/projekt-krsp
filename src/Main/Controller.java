package Main;

import Planner.Authority;
import Planner.Council;
import Planner.Interval;
import Planner.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Controller {

    @FXML
    private VBox propertyScene;
    @FXML
    private VBox mainAndCouncilScene;
    @FXML
    private VBox mainScene;
    @FXML
    private VBox councilScene;
    @FXML
    private VBox councilsContainer;
    @FXML
    private VBox authorityContainer;
    @FXML
    private VBox teachersContainer;

    @FXML
    private VBox mondayContainer;
    @FXML
    private VBox tuesdayContainer;
    @FXML
    private VBox wednesdayContainer;
    @FXML
    private VBox thursdayContainer;
    @FXML
    private VBox fridayContainer;

    private ObservableList<Council> councilList = FXCollections.observableArrayList();
    private ObservableList<Teacher> teachersList = FXCollections.observableArrayList();
    private ObservableList<Authority> authorityList = FXCollections.observableArrayList();

    private ObservableList<Interval> mondayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> tuesdayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> wednesdayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> thursdayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> fridayIntervals = FXCollections.observableArrayList();


    @FXML
    private void initialize() {
        // MainView:        true,  true,  false, false (Button: false)
        // Council Options: true,  false, true,  false (Button: true)
        // Teacher Option:  false, false, true,  true (Button: true)
        this.mainAndCouncilScene.setVisible(true);
        this.mainScene.setVisible(true);
        this.councilScene.setVisible(false);
        this.propertyScene.setVisible(false);
        this.initializeMainScene();
        this.initializeIntervalScene();
    }

    private void initializeMainScene() {
        // Adding buttons for allowing the user to add councils, teachers and authorities
        StackPane addCouncilButton = this.createCircularButton();
        StackPane addTeacherButton = this.createCircularButton();
        StackPane addAuthorityButton = this.createCircularButton();
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

    private void initializeIntervalScene() {
        StackPane addMondayIntervalButton = this.createCircularButton();
        StackPane addTuesdayIntervalButton = this.createCircularButton();
        StackPane addWednesdayIntervalButton = this.createCircularButton();
        StackPane addThursdayIntervalButton = this.createCircularButton();
        StackPane addFridayIntervalButton = this.createCircularButton();

        addMondayIntervalButton.setOnMouseClicked(e -> {
            this.mondayIntervals.add(new Interval());
        });
        addTuesdayIntervalButton.setOnMouseClicked(e -> {
            this.tuesdayIntervals.add(new Interval());
        });
        addWednesdayIntervalButton.setOnMouseClicked(e -> {
            this.wednesdayIntervals.add(new Interval());
        });
        addThursdayIntervalButton.setOnMouseClicked(e -> {
            this.thursdayIntervals.add(new Interval());
        });
        addFridayIntervalButton.setOnMouseClicked(e -> {
            this.fridayIntervals.add(new Interval());
        });
        this.mondayContainer.getChildren().add(addMondayIntervalButton);
        this.mondayIntervals.addListener((ListChangeListener<? super Interval>)  e -> {
            this.mondayContainer.getChildren().setAll();
            this.mondayContainer.getChildren().add(addMondayIntervalButton);
        });
        this.tuesdayContainer.getChildren().add(addTuesdayIntervalButton);
        this.tuesdayIntervals.addListener((ListChangeListener<? super Interval>)  e -> {
            this.tuesdayContainer.getChildren().setAll();
            this.tuesdayContainer.getChildren().add(addTuesdayIntervalButton);
        });
        this.wednesdayContainer.getChildren().add(addWednesdayIntervalButton);
        this.wednesdayIntervals.addListener((ListChangeListener<? super Interval>)  e -> {
            this.wednesdayContainer.getChildren().setAll();
            this.wednesdayContainer.getChildren().add(addWednesdayIntervalButton);
        });
        this.thursdayContainer.getChildren().add(addThursdayIntervalButton);
        this.thursdayIntervals.addListener((ListChangeListener<? super Interval>)  e -> {
            this.thursdayContainer.getChildren().setAll();
            this.thursdayContainer.getChildren().add(addThursdayIntervalButton);
        });
        this.fridayContainer.getChildren().add(addFridayIntervalButton);
        this.fridayIntervals.addListener((ListChangeListener<? super Interval>)  e -> {
            this.fridayContainer.getChildren().setAll();
            this.fridayContainer.getChildren().add(addFridayIntervalButton);
        });
    }

    private void addCouncil() {
        this.councilList.add(new Council());
        System.out.println("Adding Council");
    }

    private void addTeacher() {
        this.teachersList.add(new Teacher(""));
        System.out.println("Adding Teacher");
    }

    private void addAuthority() {
        this.authorityList.add(new Authority(""));
        System.out.println("Adding Authority");
    }


    // Helper function for creating a circular button
    private StackPane createCircularButton() {
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

    @FXML
    private void back(MouseEvent mouseEvent) {
    }

    @FXML
    public void backButtonPressed(MouseEvent mouseEvent) {
    }
}
