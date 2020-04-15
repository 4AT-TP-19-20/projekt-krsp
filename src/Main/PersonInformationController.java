package Main;

import Planner.Council;
import Planner.Interval;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PersonInformationController {
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

    private ObservableList<Interval> mondayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> tuesdayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> wednesdayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> thursdayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> fridayIntervals = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        StackPane addMondayIntervalButton = MainSceneController.createCircularButton();
        StackPane addTuesdayIntervalButton = MainSceneController.createCircularButton();
        StackPane addWednesdayIntervalButton = MainSceneController.createCircularButton();
        StackPane addThursdayIntervalButton = MainSceneController.createCircularButton();
        StackPane addFridayIntervalButton = MainSceneController.createCircularButton();

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

    @FXML
    public void backButtonPressed(MouseEvent mouseEvent) {
    }
}
