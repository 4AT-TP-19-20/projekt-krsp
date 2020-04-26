package Planner;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;

public class Interval extends HBox {
    String startValue="from";
    String endValue="to";

    public Interval() {
        Label startValueLabel = new Label();
        Label endValueLabel = new Label();
        TextField startValueTextField = new TextField();
        TextField endValueTextField = new TextField();

        this.setMinSize(100,40);
        this.setStyle("-fx-background-color: white; -fx-alignment: center");

        startValueTextField.setMinHeight(40);
        endValueTextField.setMinHeight(40);

        startValueLabel.prefWidthProperty().bind(this.widthProperty());
        startValueLabel.prefHeightProperty().bind(this.heightProperty());
        startValueLabel.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center; -fx-border-color: black");
        startValueLabel.setText(startValue);

        endValueLabel.prefWidthProperty().bind(this.widthProperty());
        endValueLabel.prefHeightProperty().bind(this.heightProperty());
        endValueLabel.setStyle("-fx-wrap-text: true; -fx-alignment: center; -fx-text-alignment: center; -fx-border-color: black");
        endValueLabel.setText(endValue);

        this.getChildren().addAll(startValueLabel,endValueLabel);

        startValueLabel.setOnMouseClicked(e->{
            this.getChildren().clear();
            this.getChildren().addAll(startValueTextField,endValueLabel);
        });

        endValueLabel.setOnMouseClicked(e->{
            this.getChildren().clear();
            this.getChildren().addAll(startValueLabel, endValueTextField);

        });

        this.setOnKeyPressed(event -> {
                    if (event.getCode().equals(KeyCode.ENTER)) {
                        this.getChildren().clear();
                        if (!startValueTextField.getText().isEmpty()) startValue=startValueTextField.getText();
                        if (!endValueTextField.getText().isEmpty()) endValue=endValueTextField.getText();
                        startValueLabel.setText(startValue);
                        endValueLabel.setText(endValue);
                        this.getChildren().addAll(startValueLabel,endValueLabel);
                    }
                }
        );

    }

    public String getStartValue() { return startValue; }

    public String getEndValue() { return endValue; }
}
