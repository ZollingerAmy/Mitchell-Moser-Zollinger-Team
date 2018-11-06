/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */
package app;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
import java.util.*;
import model.Game;
import view.StartProgramView;

public class CityOfAaron {

    /**
     * The starting point for our application.
     *
     * @param args Any parameters passed on the command line will be contained in this array.
     */
    public static Game currentGame = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game thisCurrentGame) {
        currentGame = thisCurrentGame;
    }

    public static void main(String[] args) {

        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayView();

    }

}
