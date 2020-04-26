package Planner;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class Council extends HBox {
    private String name;
    private double duration;
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Authority> authorities = new ArrayList<>();

    private Label nameLabel = new Label();

    public Council(String name, double duration) {
        this.duration = duration;
        this.name = name;


        this.setPrefSize(550, 50);
        this.setMaxHeight(50);
        this.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-alignment: center");
        this.nameLabel.prefWidthProperty().bind(this.widthProperty());
        this.nameLabel.prefHeightProperty().bind(this.heightProperty());
        this.nameLabel.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center");
        this.nameLabel.setText(this.name);

        Label durationLabel = new Label();
        durationLabel.prefWidthProperty().bind(this.widthProperty());
        durationLabel.prefHeightProperty().bind(this.heightProperty());
        durationLabel.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center");
        durationLabel.setText("Duration: " + duration);

        this.getChildren().addAll(this.nameLabel, durationLabel);

    }

    public String getName() {
        return this.name;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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
