package control;

import java.util.Random;
import model.Game;
import model.Player;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */

public class GameControl {
    
    private static Random randomGenerator = new Random();
    
    /**
     * Protected setter for tests to inject a mock random object.
     * @param random
     */
    protected static void setRandomGenerator(Random random) {
        randomGenerator = random;
    }
    
    public static Game createNewGame(Player thePlayer) {
        Game theGame = new Game();
        return theGame;
    }
    
    public static Player savePlayer(String name){
        System.out.println("*** savePlayer() called ***");
        return new Player();
    }
    
    /**
     * Generates a random integer between lowValue and highValue, inclusive.
     * <ul>Requirements:
     * <li>lowValue and highValue must be positive int (&gt;= 0) (return -1)</li>
     * <li>highValue must be greater than lowValue (return -2) </li>
     * <li>highValue cannot be equal to the max value for int (return -3)</li>
     * </ul>
     * @param lowValue
     * @param highValue
     * @return The random number
     */
    public static int getRandomNumber(int lowValue, int highValue) {
        // if low < 0 or high < 0 then return -1
        if (lowValue < 0 || highValue < 0) {
            return -1;
        }
        // if high <= low then return -2
        if (highValue <= lowValue) {
            return -2;
        }
        
        // if high is the max val for int, then return -3
        if (highValue == Integer.MAX_VALUE) {
            return -3;
        }
        
        // calc the size of the range; add one so Random() includes high val
        int range = (highValue - lowValue) + 1;
        
        
        // return low + random(range size)
        return lowValue + randomGenerator.nextInt(range);
        
    }

}
