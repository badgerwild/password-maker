
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class PassPhrase {

    public static void main(String [] args)throws Exception{
        /**creating the dice object and then opening the files that are used as a soource.**/
        Dice die = new Dice();
        Scanner input = new Scanner(System.in);
        int numberOfWords=0, numberOfDie=0;
        System.out.println("Please enter the number of words you would like your pass code to contain: ");
        numberOfWords=input.nextInt();
        System.out.println("Please enter the number of Dice you would like to use, 3 or 5");
        numberOfDie=input.nextInt();

        File five = new File("/home/badger/word-lists/eff_large_wordlist.txt");
        try {
            input=new Scanner(five);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        /**makes a string of the random number generated taking the number of dice into consideration**/

        int wordNumber =0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<numberOfDie; i++){
            wordNumber = die.roll();
            sb.append(wordNumber);
        }
        String holder = (sb.toString());
        System.out.println(sb.toString());

        /**chooses a number based on the created random number. right now uses the long wordlist**/
        ArrayList<String> storage  = new ArrayList<String>();
        String theWord= null;
        while(input.hasNext()) {
            storage.add(input.next());
        }

        for(String s: storage){
            if(s.equals(holder)){
                int temp = storage.indexOf(s);
                theWord = storage.get(temp+1);
            }
        }

        System.out.println(theWord);

        input.close();



    }
}
