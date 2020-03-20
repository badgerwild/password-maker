import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class wordListDAO implements DAO
{
    private static final String WORDLIST_PREFIX = "wordList_";
    private static final String WORDLIST_SUFFIX =  ".txt";
    private static final String WORDLIST_DIR_PATH = "home/badger/word-lists/";

    private Dice theDice = new Dice();

    public String get(int numberOfWords,int id, int[] word_id)
    {

        Scanner reader = null;
        try {
            reader = new Scanner(new File(WORDLIST_DIR_PATH + WORDLIST_PREFIX + id + WORDLIST_SUFFIX));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        /**makes a string of the random number generated taking the number of dice into consideration**/

        StringBuilder multipleWord = new StringBuilder();
        ArrayList<String> storage = new ArrayList<String>();
        String theWord = null;

        for(int i=0; i<numberOfWords; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < theNumberofdice; j++) {
                wordNumber = theDie.roll();
                sb.append(wordNumber);
            }
            String holder = (sb.toString());
            //debug  System.out.println(sb.toString());

            while (reader.hasNext()) {
                storage.add(reader.next());
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
}
