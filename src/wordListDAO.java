import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class wordListDAO implements DAO
{
    private static final String WORDLIST_PREFIX = "wordList_";
    private static final String WORDLIST_SUFFIX =  ".txt";
    private static final String WORDLIST_DIR_PATH = "home/badger/word-lists/";
    private String[] listOfWords;
    private int[] word_id;
    private int wordListSelector;
    public wordListDAO(int[] word_id, int wordListSelector){
        this.word_id = word_id;
        this.wordListSelector = wordListSelector;
    }

    /**
     * Function takes in
     * @return
     */
    public String[] get( )
    {
        listOfWords = new String[word_id.length];
        Scanner reader = null;
        ArrayList<String> tempStorage = new ArrayList<>();
        int[] idStorage;
        String[] wordStorage;
        try {
            reader = new Scanner(new File(WORDLIST_DIR_PATH + WORDLIST_PREFIX + wordListSelector + WORDLIST_SUFFIX));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        /**makes a string of the random number generated taking the number of dice into consideration**/

        while(reader.hasNext()){
            tempStorage.add(reader.next());
        }
        int arraySize = (int)Math.ceil((double)tempStorage.size()/2);
        idStorage = new int[arraySize];
        wordStorage = new String[arraySize];
//takes strings that are in array list and splits them into string or int arrays, so that
        //binary search can be used on the int array.
        for(String s : tempStorage){
            int idCount =0;
            int wordCount =0;
            if(s.matches("\\d+")){
                idStorage[idCount]= Integer.parseInt(s);
                idCount++;
            }
            else{
                wordStorage[wordCount] = s;
                wordCount++;
            }
        }
       //binary search to find the integer and then add it to the word array
        for(int i =0; i < word_id.length; i++ ){
            int tempIndex = Arrays.binarySearch(idStorage, word_id[i]);
            listOfWords[i] = wordStorage[tempIndex];
        }

        return listOfWords;


    }
}
