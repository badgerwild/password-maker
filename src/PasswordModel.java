import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordModel {

    private int wordLength ;
    private int wordNumber;
    private int numberOfWords;
    private File wordSource;
    private Dice die = new Dice();
    private Scanner input = new Scanner(System.in);
//listens for the length of the words that the user would like to use.
   public void setWordLength(int length){
       if(length == 4){
           wordSource = new File("word-lists/eff_short_wordlist.txt");
       }
       else if(length == 5){
           wordSource = new File("word-lists/eff_large_wordlist.txt");
       }
   }
  //listens for the section o fhow many words the user selects
   public void setNumberOfWords(int words){
       numberOfWords = words;
   }


    public String pickAWord(Dice theDie, File theFile, Scanner input, int theNumberofdice, int theNumberOfWords){
        try {
            input = new Scanner(theFile);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        /**makes a string of the random number generated taking the number of dice into consideration**/

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
    public static void main(String [] args){

    }
}
