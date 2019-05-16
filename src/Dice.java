//Dice class for random number generator

import java.util.Random;

public class Dice {

    private int value;

    public Dice(){
        value=0;
    }

    public int roll(){
        int result=0;
        Random diceRoll = new Random();
        result = diceRoll.nextInt(5)+1;
        return result;
    }



    public static void main(String [] args){

    }
}
