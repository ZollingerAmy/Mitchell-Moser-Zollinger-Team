package control;

import model.Game;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */

public class GameControl {
    
    public static Game createNewGame(String playerName) {
        Game theGame = new Game();
        return theGame;
    }

}
