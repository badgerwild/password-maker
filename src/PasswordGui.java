import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.*;


import javax.xml.ws.handler.Handler;


public class PasswordGui extends Application {




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Group());
        primaryStage.setWidth(400);
        primaryStage.setHeight(500);

        primaryStage.setTitle("Password Generator");

        Text t1 = new Text();
        t1.setFont(new Font(22));
        t1.setX(5);
        t1.setY(5);

        t1.setText("Welcome to the pass code generator");


//first group of radio buttons selects the number of Dice to be used
        final ToggleGroup numberOfDice = new ToggleGroup();
        //use the long word list
        RadioButton r1 = new RadioButton("four");

        r1.setToggleGroup(numberOfDice);
        r1.setSelected(true);
        //use the short word list
        RadioButton r2 = new RadioButton("five");
        r2.setToggleGroup(numberOfDice);

        //add functionality here
        //toggle property, change listner etc.

        HBox hBox = new HBox();
        VBox vbox = new VBox();

        vbox.getChildren().add(t1);

        vbox.getChildren().add(r1);
        vbox.getChildren().add(r2);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20, 10, 50, 20));


        hBox.getChildren().add(vbox);
        hBox.setSpacing(50);
        ((Group)scene.getRoot()).getChildren().add(hBox);

        //group two of the radion buttons, determines the number of the words used in the pass phrase
        final ToggleGroup selectNumberOfWords = new ToggleGroup();
        RadioButton w1 = new RadioButton("four");
        w1.setToggleGroup(selectNumberOfWords);
        RadioButton w2 = new RadioButton("five");
        w2.setToggleGroup(selectNumberOfWords);
        RadioButton w3 = new RadioButton("six");
        w3.setToggleGroup(selectNumberOfWords);
//


        vbox.getChildren().add(w1);
        vbox.getChildren().add(w2);
        vbox.getChildren().add(w3);
        vbox.setSpacing(12);
        vbox.setPadding(new Insets(20,10,10,20));

      Button generate = new Button("Generate");

      vbox.getChildren().add(generate);





        primaryStage.setScene(scene);
        primaryStage.show();





    }
}
