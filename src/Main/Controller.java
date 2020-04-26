package Main;

import Planner.Authority;
import Planner.Council;
import Planner.Interval;
import Planner.Teacher;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.omg.CORBA.INTERNAL;

import javax.xml.ws.http.HTTPBinding;
import java.lang.reflect.Array;
import java.util.*;

public class Controller {
    @FXML
    private Button backButton;
    @FXML
    private VBox councilTeacherContainer;
    @FXML
    private VBox councilAuthorityContainer;
    @FXML
    private Pane rootPane;
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

    private ObservableList<HBox> councilList = FXCollections.observableArrayList();
    private ObservableList<HBox> teachersList = FXCollections.observableArrayList();
    private ObservableList<HBox> authorityList = FXCollections.observableArrayList();

    private ObservableList<Interval> mondayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> tuesdayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> wednesdayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> thursdayIntervals = FXCollections.observableArrayList();
    private ObservableList<Interval> fridayIntervals = FXCollections.observableArrayList();

    private Council currentActiveCouncil = null;
    private Authority currentActivePerson = null;
    private int defaultValue = 50;

    @FXML
    private void initialize() {
        this.changeScene();
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
        this.councilList.addListener((ListChangeListener<HBox>) c -> {
            this.councilsContainer.getChildren().setAll(this.councilList);
            this.councilsContainer.getChildren().add(addCouncilButton);
        });
        this.teachersList.addListener((ListChangeListener<HBox>) c -> {
            this.teachersContainer.getChildren().setAll(this.teachersList);
            this.teachersContainer.getChildren().add(addTeacherButton);
        });
        this.authorityList.addListener((ListChangeListener<HBox>) c -> {
            this.authorityContainer.getChildren().setAll(this.authorityList);
            this.authorityContainer.getChildren().add(addAuthorityButton);
        });

        this.councilTeacherContainer.getChildren().addListener((ListChangeListener<Node>) c -> {
            if (this.currentActiveCouncil != null) {
                this.currentActiveCouncil.getTeachers().clear();
                this.currentActiveCouncil.getTeachers().addAll((Collection<? extends Teacher>) c.getList());
            }
        });
        this.councilAuthorityContainer.getChildren().addListener((ListChangeListener<Node>) c -> {
            if (this.currentActiveCouncil != null) {
                this.currentActiveCouncil.getAuthorities().clear();
                this.currentActiveCouncil.getAuthorities().addAll((Collection<? extends Authority>) c.getList());
            }
        });
    }

    private void initializeIntervalScene() {
        StackPane addMondayIntervalButton = this.createCircularButton();
        StackPane addTuesdayIntervalButton = this.createCircularButton();
        StackPane addWednesdayIntervalButton = this.createCircularButton();
        StackPane addThursdayIntervalButton = this.createCircularButton();
        StackPane addFridayIntervalButton = this.createCircularButton();
        addMondayIntervalButton.setOnMouseClicked(e -> this.mondayIntervals.add(new Interval()));
        addTuesdayIntervalButton.setOnMouseClicked(e -> this.tuesdayIntervals.add(new Interval()));
        addWednesdayIntervalButton.setOnMouseClicked(e -> this.wednesdayIntervals.add(new Interval()));
        addThursdayIntervalButton.setOnMouseClicked(e -> this.thursdayIntervals.add(new Interval()));
        addFridayIntervalButton.setOnMouseClicked(e -> this.fridayIntervals.add(new Interval()));
        this.mondayContainer.getChildren().add(addMondayIntervalButton);
        this.mondayIntervals.addListener((ListChangeListener<? super Interval>) e -> {
            this.mondayContainer.getChildren().setAll(this.mondayIntervals);
            this.mondayContainer.getChildren().add(addMondayIntervalButton);
            this.currentActivePerson.getTimeTable().get("Monday").clear();
            this.currentActivePerson.getTimeTable().get("Monday").addAll(this.mondayIntervals);
        });
        this.tuesdayContainer.getChildren().add(addTuesdayIntervalButton);
        this.tuesdayIntervals.addListener((ListChangeListener<? super Interval>) e -> {
            this.tuesdayContainer.getChildren().setAll(tuesdayIntervals);
            this.tuesdayContainer.getChildren().add(addTuesdayIntervalButton);
            this.currentActivePerson.getTimeTable().get("Tuesday").clear();
            this.currentActivePerson.getTimeTable().get("Tuesday").addAll(this.tuesdayIntervals);
        });
        this.wednesdayContainer.getChildren().add(addWednesdayIntervalButton);
        this.wednesdayIntervals.addListener((ListChangeListener<? super Interval>) e -> {
            this.wednesdayContainer.getChildren().setAll(wednesdayIntervals);
            this.wednesdayContainer.getChildren().add(addWednesdayIntervalButton);
            this.currentActivePerson.getTimeTable().get("Wednesday").clear();
            this.currentActivePerson.getTimeTable().get("Wednesday").addAll(this.wednesdayIntervals);
        });
        this.thursdayContainer.getChildren().add(addThursdayIntervalButton);
        this.thursdayIntervals.addListener((ListChangeListener<? super Interval>) e -> {
            this.thursdayContainer.getChildren().setAll(thursdayIntervals);
            this.thursdayContainer.getChildren().add(addThursdayIntervalButton);
            this.currentActivePerson.getTimeTable().get("Thursday").clear();
            this.currentActivePerson.getTimeTable().get("Thursday").addAll(this.thursdayIntervals);
        });
        this.fridayContainer.getChildren().add(addFridayIntervalButton);
        this.fridayIntervals.addListener((ListChangeListener<? super Interval>) e -> {
            this.fridayContainer.getChildren().setAll(fridayIntervals);
            this.fridayContainer.getChildren().add(addFridayIntervalButton);
            this.currentActivePerson.getTimeTable().get("Friday").clear();
            this.currentActivePerson.getTimeTable().get("Friday").addAll(this.fridayIntervals);
        });
    }

    // Helper function for changing the scene to the properties of a specific council
    private void changeScene(Council council) {
        this.mainAndCouncilScene.setVisible(true);
        this.mainScene.setVisible(false);
        this.councilScene.setVisible(true);
        this.propertyScene.setVisible(false);
        this.backButton.setVisible(true);
        this.councilTeacherContainer.getChildren().setAll(council.getTeachers());
        this.councilAuthorityContainer.getChildren().setAll(council.getAuthorities());
        this.currentActiveCouncil = council;
        this.currentActivePerson = null;
    }

    // Helper function for changing the scene to the properties of a specific person (teacher or authority)
    private void changeScene(Authority person) {
        this.mainAndCouncilScene.setVisible(false);
        this.mainScene.setVisible(false);
        this.councilScene.setVisible(true);
        this.propertyScene.setVisible(true);
        this.backButton.setVisible(true);
        this.currentActivePerson = person;
        this.currentActiveCouncil = null;


        // Bind person timetable with the observable lists
        this.mondayIntervals.setAll(person.getTimeTable().get("Monday"));
        this.tuesdayIntervals.setAll(person.getTimeTable().get("Tuesday"));
        this.wednesdayIntervals.setAll(person.getTimeTable().get("Wednesday"));
        this.thursdayIntervals.setAll(person.getTimeTable().get("Thursday"));
        this.fridayIntervals.setAll(person.getTimeTable().get("Friday"));


    }

    // Helper function for changing the scene back to the main view
    private void changeScene() {
        this.mainAndCouncilScene.setVisible(true);
        this.mainScene.setVisible(true);
        this.councilScene.setVisible(false);
        this.propertyScene.setVisible(false);
        this.backButton.setVisible(false);
        this.currentActiveCouncil = null;
        this.currentActivePerson = null;
    }

    // Function for creating a new Council and adding it to the list
    private void addCouncil() {
        String name = this.getName();
        if (name != null && !name.isEmpty()) {
            final Council council = new Council(name, this.defaultValue);
            HBox box = new HBox();
            VBox vBox = new VBox();
            Button deleteButton = this.createDeleteButton(council);
            Button optionsButton = new Button("O");
            optionsButton.setOnMouseClicked(e -> {
                this.changeScene(council);
            });
            vBox.getChildren().addAll(optionsButton, deleteButton);
            box.getChildren().addAll(council, vBox);
            this.councilList.add(box);
            System.out.println("Adding Council");
        }
    }

    // Function for creating a new Teacher and adding it to the list
    private void addTeacher() {
        String name = this.getName();
        if (name != null && !name.isEmpty()) {
            final Teacher teacher = new Teacher(name);;
            HBox box = this.createPersonBox(teacher, this.councilTeacherContainer);
            this.teachersList.add(box);
            System.out.println("Adding Teacher");
        }
    }

    // Function for creating a new Authority and adding it to the list
    private void addAuthority() {
        String name = this.getName();
        if (name != null && !name.isEmpty()) {
            final Authority authority = new Authority(name);
            HBox box = this.createPersonBox(authority, this.councilAuthorityContainer);
            this.authorityList.add(box);
            System.out.println("Adding Authority");
        }
    }

    // Helper function for creating a box with name, options button and delete button
    private HBox createPersonBox(Authority person, Node container) {
        final Button deleteButton = this.createDeleteButton(person);
        final Button optionsButton = this.createOptionsButton(person);
        person.makeDraggable(this.rootPane, container);
        HBox box = new HBox();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(optionsButton, deleteButton);
        box.getChildren().addAll(person, vBox);
        return box;
    }

    // Helper function for creating a button that return a button to open a persons (teacher / authority) properties
    private Button createOptionsButton(Authority person) {
        Button optionsButton = new Button("O");
        optionsButton.setOnMouseClicked(e -> {
            this.changeScene(person);
        });
        return optionsButton;
    }

    // Helper function for creating a button that deletes a node from it's parent
    private Button createDeleteButton(Node node) {
        Button deleteButton = new Button("D");
        deleteButton.setOnMouseClicked(e -> {
            if (node instanceof Teacher) {
                this.teachersList.remove(node.getParent());
            } else if (node instanceof Authority) {
                this.authorityList.remove(node.getParent());
            } else if (node instanceof Council) {
                this.councilList.remove(node.getParent());
            }
            if (this.currentActivePerson == node) {
                this.changeScene();
            }
        });
        return deleteButton;
    }

    // Helper function that opens an input dialog and requests the user to enter a name
    private String getName() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Add");
        dialog.setHeaderText("Enter the name:");
        dialog.setContentText("Name:");
        dialog.showAndWait();
        return dialog.getResult();
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
    private void calculate() {
        // Create a list with all councils and their overlapping intervals

        ArrayList<HashMap<Council, Map<String, ArrayList<Interval>>>> list = new ArrayList<>();
        for (HBox b : this.councilList) {
            Council council = (Council) b.getChildren().get(0);
            ArrayList<Authority> persons = council.getAuthorities();
            persons.addAll(council.getTeachers());
            ArrayList<HashMap<String, Interval>> intervals = null;
            for (Authority a : persons) {
                HashMap<String, ArrayList<Interval>> l = a.getTimeTable();
                if (intervals == null) {
                    intervals = new ArrayList<>();
                    for (int i = 0; i < l.size(); i++) {
                        String key = new ArrayList<>(l.keySet()).get(i);
                        for (Interval in : l.get(key)) {
                            HashMap<String, Interval> entry = new HashMap<>();
                            entry.put(key, in);
                            intervals.add(entry);
                        }
                    }
                } else {
                    ArrayList<HashMap<String, Interval>> newList = new ArrayList<>();
                    for (int i = 0; i < l.size(); i++) {
                        String key = new ArrayList<>(l.keySet()).get(i);
                        for (Interval in : l.get(key)) {
                            // Check if overlaps
                            for (HashMap<String, Interval> interval : intervals) {
                                String day = new ArrayList<>(interval.keySet()).get(0);
                                if (day.equals(key)) {
                                    if (in != null && interval.get(day) != null) {
                                        Interval overlap = this.overlaps(in, interval.get(day));
                                        if (overlap != null) {
                                            HashMap<String, Interval> entry = new HashMap<>();
                                            entry.put(day, overlap);
                                            newList.add(entry);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (newList.size() == 0) {
                        // Error
                    } else {
                        intervals = newList;
                    }
                }
            }
            System.out.println("lul");
        }

    }

    private Interval overlaps(Interval i, Interval j) {
        if (Math.min(Double.parseDouble(i.getEndValue()), Double.parseDouble(j.getEndValue())) <= Math.max(Double.parseDouble(i.getStartValue()), Double.parseDouble(j.getStartValue()))) {
            return null;
        } else {
            return new Interval(Math.max(Double.parseDouble(i.getStartValue()), Double.parseDouble(j.getStartValue())), Math.min(Double.parseDouble(i.getEndValue()), Double.parseDouble(j.getEndValue())));
        }
    }


    @FXML
    public void backButtonPressed() {
        this.changeScene();
    }
}
