/**
 * file: Calculator.java
 * language: java
 * author: Adam Wolf
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class Calculator extends Application {

    // Create array for buttons to make creating easier
    private String[] buttons = new String[]{
            "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            "Enter", "0", "Clear", "//"
    };

    /**
     * Setup calculator step by step. Create BorderPane, then label for result then buttons
     * @param stage
     */
    public void start(Stage stage) {

        // Create BorderPane
        BorderPane layout = new BorderPane();

        // Create result label
        Label result = new Label("");
        result.setFont(new Font("Verdana", 50));
        result.setMaxHeight(70);
        result.setMinHeight(70);
        result.setMaxWidth(500);
        result.setMinWidth(500);
        result.setAlignment(Pos.CENTER);

        // Create TilePane for buttons
        TilePane buttonPane = new TilePane();

        // Create buttons
        for (int i = 0; i < buttons.length; i++) {
            Button newButton = new Button(buttons[i]);

            // Create event handlers
            newButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (result.getText().equals("")) {
                        if (newButton.getText().equals("Enter") || newButton.getText().equals("Clear")) {
                            result.setText("0");
                        } else {
                            result.setText(newButton.getText());
                        }
                    } else {
                        if (newButton.getText().equals("+") || newButton.getText().equals("-") || newButton.getText().equals("*") || newButton.getText().equals("//")) {
                            result.setText(result.getText() + " " + newButton.getText() + " ");
                        } else if (newButton.getText().equals("Enter")) {
                            String[] equation;
                            equation = result.getText().split(" ");
                            result.setText(String.valueOf(calculate(Integer.valueOf(equation[0]), Integer.valueOf(equation[2]), equation[1])));
                        } else if (newButton.getText().equals("Clear")) {
                            result.setText("");
                        } else {
                            result.setText(result.getText() + newButton.getText());
                        }
                    }
                }
            });

            // Set height and width so it doesn't change
            newButton.setMaxWidth(125);
            newButton.setMinWidth(125);
            newButton.setMaxHeight(100);
            newButton.setMinHeight(100);

            // Add new button to buttonPane
            buttonPane.getChildren().add(newButton);
        }

        // Setup layout
        layout.setTop(result);
        layout.setCenter(buttonPane);

        // Scene setup
        Scene scene = new Scene(layout);

        // Stage setup
        stage.setTitle("Simple Calculator");
        stage.setScene(scene);

        // Set height and width and take away ability to resize
        stage.setHeight(500);
        stage.setWidth(500);
        stage.setResizable(false);

        // Show stage
        stage.show();
    }

    /**
     * stop() is called when a JavaFX application ends.
     * This is where the application performs cleanup activities.
     */
    @Override
    public void stop() {
        System.out.println("stopping " + this.getClass().getSimpleName());
    }

    /**
     * The main is the application entry point to launch the JavaFX GUI.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    public int calculate(int i1, int i2, String operand) {
        if (operand.equals("+")) {
            return Math.addExact(i1, i2);
        } else if (operand.equals("-")) {
            return Math.subtractExact(i1, i2);
        } else if (operand.equals("*")) {
            return Math.multiplyExact(i1, i2);
        } else if (operand.equals("//")) {
            return Math.floorDiv(i1, i2);
        } else {
            return 0;
        }
    }
}
