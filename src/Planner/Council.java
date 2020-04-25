package Planner;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


import java.util.ArrayList;

public class Council extends HBox {
    String name;
    int duration;
    ArrayList<Teacher> teachers;
    ArrayList<Authority> authorities;


    public Council(String name, int duration){
        this.duration=duration;
        this.name=name;

        Label nameLabel = new Label();
        Label durationLabel = new Label();

        this.setPrefSize(550, 50);
        this.setMaxHeight(50);
        this.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-alignment: center");
        nameLabel.prefWidthProperty().bind(this.widthProperty());
        nameLabel.prefHeightProperty().bind(this.heightProperty());
        nameLabel.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center");
        nameLabel.setText(name);

        durationLabel.prefWidthProperty().bind(this.widthProperty());
        durationLabel.prefHeightProperty().bind(this.heightProperty());
        durationLabel.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center");
        durationLabel.setText("Duration: "+duration);

        this.getChildren().addAll(nameLabel, durationLabel);

    }

    public String getName() {
        return name;
    }

    public int getDuration() { return duration; }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Authority> getAuthorities() {
        return authorities;
    }
}
