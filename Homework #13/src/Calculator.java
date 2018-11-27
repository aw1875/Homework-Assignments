import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.*;


public class Calculator extends Application {

    public void start(Stage stage) {
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button plus = new Button("+");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button minus = new Button("-");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button mulitply = new Button("*");
        Button enter = new Button("Enter");
        Button btn0 = new Button("0");
        Button clear = new Button("Clear");
        Button divide = new Button("//");


        TextField t1 = new TextField();
        t1.setPrefHeight(50);
        t1.setFont(Font.font("Verdana", 30));


        TilePane tp1 = new TilePane();
        tp1.setAlignment(Pos.CENTER);
        tp1.setPrefHeight(350);
        tp1.setPrefWidth(400);
        tp1.setPrefRows(4);
        tp1.setPrefColumns(4);

        tp1.getChildren().add(btn1);
        tp1.getChildren().add(btn2);
        tp1.getChildren().add(btn3);
        tp1.getChildren().add(plus);
        tp1.getChildren().add(btn4);
        tp1.getChildren().add(btn5);
        tp1.getChildren().add(btn6);
        tp1.getChildren().add(minus);
        /*g1.add(btn7, 0,2);
        g1.add(btn8, 1,2);
        g1.add(btn9, 2,2);
        g1.add(mulitply, 3,2);
        g1.add(enter, 0,3);
        g1.add(btn0, 1,3);
        g1.add(clear, 2,3);
        g1.add(divide, 3,3);*/

        BorderPane b1 = new BorderPane();
        b1.setTop(t1);
        b1.setCenter(tp1);


        Scene scene = new Scene(b1);

        // Set size
        stage.setMinWidth(400);
        stage.setMaxWidth(400);
        stage.setMinHeight(400);
        stage.setMaxHeight(400);

        stage.setTitle( "JavaFX ButtonDemo" );
        stage.setScene( scene );
        stage.show();
    }

    /**
     * stop() is called when a JavaFX application ends.
     * This is where the application performs cleanup activities.
     */
    @Override
    public void stop() {

        System.out.println( "stopping " + this.getClass().getSimpleName() );
    }

    /**
     * The main is the application entry point to launch the JavaFX GUI.
     *
     * @param args not used
     */
    public static void main( String[] args ) {

        Application.launch( args );
    }
}
