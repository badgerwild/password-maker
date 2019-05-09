//Dice class for random number generator

import java.util.Random;

public class Dice {

    private int value;

    public Dice(){
        value=0;
    }

    public int roll(int seed){
        int result=0;
        Random diceRoll = new Random(seed);
        result = diceRoll.nextInt(5);
        return result;
    }

    public static void main(String [] args){

    }
}
