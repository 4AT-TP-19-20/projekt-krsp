package Planner;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;

public class Interval extends HBox {
    private String startValue = "from";
    private String endValue = "to";

    public Interval() {
        Label startValueLabel = new Label();
        Label endValueLabel = new Label();
        TextField startValueTextField = new TextField();
        TextField endValueTextField = new TextField();
        this.setMinSize(100, 40);
        this.setStyle("-fx-background-color: white; -fx-alignment: center");
        startValueTextField.setMinHeight(40);
        endValueTextField.setMinHeight(40);
        startValueLabel.prefWidthProperty().bind(this.widthProperty());
        startValueLabel.prefHeightProperty().bind(this.heightProperty());
        startValueLabel.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center; -fx-border-color: black");
        startValueLabel.setText(this.startValue);
        endValueLabel.prefWidthProperty().bind(this.widthProperty());
        endValueLabel.prefHeightProperty().bind(this.heightProperty());
        endValueLabel.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center; -fx-border-color: black");
        endValueLabel.setText(this.endValue);
        this.getChildren().addAll(startValueLabel, endValueLabel);
        startValueLabel.setOnMouseClicked(e -> {
            this.getChildren().clear();
            this.getChildren().addAll(startValueTextField, endValueLabel);
        });
        endValueLabel.setOnMouseClicked(e -> {
            this.getChildren().clear();
            this.getChildren().addAll(startValueLabel, endValueTextField);
        });
        this.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if (!startValueTextField.getText().isEmpty()) {
                    double start = Double.parseDouble(startValueTextField.getText());
                    double end = (endValueTextField.getText().isEmpty() ? start : Double.parseDouble(endValueTextField.getText()));
                    if (start >= 0 && start <= 24 && start <= end) {
                        this.getChildren().clear();
                        this.startValue = startValueTextField.getText();
                        startValueLabel.setText(this.startValue);
                        this.getChildren().addAll(startValueLabel, endValueLabel);
                    }
                }
                if (!endValueTextField.getText().isEmpty()) {
                    double end = Double.parseDouble(endValueTextField.getText());
                    double start = (startValueTextField.getText().isEmpty() ? end : Double.parseDouble(startValueTextField.getText()));
                    if (end >= 0 && end <= 24 && end >= start) {
                        this.getChildren().clear();
                        this.endValue = endValueTextField.getText();
                        endValueLabel.setText(this.endValue);
                        this.getChildren().addAll(startValueLabel, endValueLabel);
                    }
                }
            }
        });

    }

    public Interval(double start, double end) {
        this();
        this.startValue = String.valueOf(start);
        this.endValue = String.valueOf(end);
    }

    public String getStartValue() {
        return this.startValue;
    }

    public String getEndValue() {
        return this.endValue;
    }
}
