package Planner;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class Council extends HBox {
    private String name;
    private int duration;
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Authority> authorities = new ArrayList<>();

    private Label nameLabel = new Label();
    private Label durationLabel = new Label();

    public Council(String name, int duration) {
        this.duration = duration;
        this.name = name;


        this.setPrefSize(550, 50);
        this.setMaxHeight(50);
        this.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-alignment: center");
        this.nameLabel.prefWidthProperty().bind(this.widthProperty());
        this.nameLabel.prefHeightProperty().bind(this.heightProperty());
        this.nameLabel.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center");
        this.nameLabel.setText(this.name);

        this.durationLabel.prefWidthProperty().bind(this.widthProperty());
        this.durationLabel.prefHeightProperty().bind(this.heightProperty());
        this.durationLabel.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center");
        this.durationLabel.setText("Duration: " + duration);

        this.getChildren().addAll(this.nameLabel, this.durationLabel);

    }

    public String getName() {
        return this.name;
    }

    public int getDuration() {
        return this.duration;
    }

    public ArrayList<Teacher> getTeachers() {
        return this.teachers;
    }

    public ArrayList<Authority> getAuthorities() {
        return this.authorities;
    }

    public void setName(String name) {
        this.name = name;
        this.nameLabel.setText(this.name);
    }
}
