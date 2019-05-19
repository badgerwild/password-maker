import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PasswordGui extends Application {


   private int diceNumber =4;
   private int wordNumber=4;
   private File wordSource= new File("/home/badger/word-lists/eff_short_wordlist.txt");
   private Dice die = new Dice();
   private Scanner input = new Scanner(System.in);
    TextArea output = new TextArea();

    public static String pickAWord(Dice theDie, File theFile, Scanner input, int theNumberofdice, int theNumberOfWords){
        try {
            input = new Scanner(theFile);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        /**makes a string of the random number generated taking the number of dice into consideration**/

        int wordNumber = 0;

        StringBuilder multipleWord = new StringBuilder();
        ArrayList<String> storage = new ArrayList<String>();
        String theWord = null;

        for(int i=0; i<theNumberOfWords; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < theNumberofdice; j++) {
                wordNumber = theDie.roll();
                sb.append(wordNumber);
            }
            String holder = (sb.toString());
           //debug  System.out.println(sb.toString());

            while (input.hasNext()) {
                storage.add(input.next());
            }

            for (String s : storage) {
                if (s.equals(holder)) {
                    int temp = storage.indexOf(s);
                    theWord = storage.get(temp + 1);
                }
            }
            multipleWord.append(theWord);
        }
        return multipleWord.toString();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Group());
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

        primaryStage.setTitle("Password Generator");

        Text t1 = new Text();
        t1.setFont(new Font(22));
        t1.setX(5);
        t1.setY(5);
        t1.setText("Welcome to the pass code generator");

        Text t2 = new Text("How many dice would you like to use?");
        t2.setFont(new Font(14));

        Text t3 = new Text("How many words would you like the pass phrase to have?");
        t2.setFont(new Font(14));



//first group of radio buttons selects the number of Dice to be used
        final ToggleGroup numberOfDice = new ToggleGroup();
        //use the long word list
        RadioButton r1 = new RadioButton("four");

        r1.setToggleGroup(numberOfDice);
        r1.setSelected(true);
        r1.setUserData(4);
        //use the short word list
        RadioButton r2 = new RadioButton("five");
        r2.setToggleGroup(numberOfDice);
        r2.setUserData(5);


//event handler for the first radio button group
        numberOfDice.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(numberOfDice.getSelectedToggle() != null){
                   // System.out.println(numberOfDice.getSelectedToggle().getUserData().toString());
                    if(numberOfDice.getSelectedToggle().getUserData().equals(4)){
                        diceNumber =4;
                        wordSource = new File("/home/badger/word-lists/eff_short_wordlist.txt");
                    }
                    else if(numberOfDice.getSelectedToggle().getUserData().equals(5)){
                        diceNumber =5;
                        wordSource = new File("/home/badger/word-lists/eff_large_wordlist.txt");
                    }
                }
            }
        });

//define a new hbox and vbox
        HBox hBox = new HBox();
        VBox vbox = new VBox();
//adding in the intial text and radio buttons
        vbox.getChildren().add(t1);
        vbox.getChildren().add(t2);

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
        w1.setUserData(4);
        w1.setSelected(true);
        RadioButton w2 = new RadioButton("five");
        w2.setToggleGroup(selectNumberOfWords);
        w2.setUserData(5);
        RadioButton w3 = new RadioButton("six");
        w3.setToggleGroup(selectNumberOfWords);
        w3.setUserData(6);

//Event handler for the second group of radio buttons. Selects the number of words that will make up the passcode
        selectNumberOfWords.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(selectNumberOfWords.getSelectedToggle().getUserData()!=null){
                  //  System.out.println(selectNumberOfWords.getSelectedToggle().getUserData().toString());
                    if(selectNumberOfWords.getSelectedToggle().getUserData().equals(4)){
                        wordNumber=4;
                    }
                    else if(selectNumberOfWords.getSelectedToggle().getUserData().equals(5)){
                        wordNumber =5;
                    }
                    else if(selectNumberOfWords.getSelectedToggle().getUserData().equals(6)){
                        wordNumber =6;
                    }
                }
            }
        });

        vbox.getChildren().add(t3);
        vbox.getChildren().add(w1);
        vbox.getChildren().add(w2);
        vbox.getChildren().add(w3);
        vbox.setSpacing(12);
        vbox.setPadding(new Insets(20,10,10,20));


//button that completes the first function
      Button generate = new Button("Generate");

      generate.setOnMouseClicked(new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
              System.out.println(pickAWord(die, wordSource, input, diceNumber, wordNumber ));
          }
      });
        vbox.getChildren().add(generate);
        //TextArea output = new TextArea();

        System.setOut(new PrintStream(new ObjectOutputStream() {
            @Override
            public void write(int b) throws IOException {
                output.appendText("" + ((char) b));
            }

            @Override
            public void write(byte[] b) throws IOException {
                output.appendText(new String(b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                output.appendText(new String(b, off, len));
            }

        }));


        output.setMaxSize(400, 100);

        vbox.getChildren().add(output);

        primaryStage.setScene(scene);
        primaryStage.show();





    }
}
