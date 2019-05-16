import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.*;

import javax.xml.ws.handler.Handler;


public class PasswordGui extends Application {

    //implements EventHandler<ActionEvent>

    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Password Generator");
        button = new Button();
        button.setText("Click me");
        button.addEventHandler();

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();



        EventHandler<javafx.scene.input.MouseEvent> eventHandler = new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("stuff");

            }
        };

    // @Override
     //public void handle(ActionEvent){
      //      System.out.println("something");
     //   }

    }
}
