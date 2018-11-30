/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */
package app;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
//import java.util.*;
import model.AnnualReport;
import model.Game;
import view.StartProgramView;
import view.View;

public class CityOfAaron {

    /**
     * The starting point for our application.
     */
    public static Game currentGame = null;
    public static AnnualReport currentReport = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game thisCurrentGame) {
        currentGame = thisCurrentGame;
    }

    public static AnnualReport getCurrentReport() {
        return currentReport;
    }

    public static void setCurrentReport(AnnualReport currentReport) {
        CityOfAaron.currentReport = currentReport;
    }

    public static void main(String[] args) {
        try{
        View startProgramView = new StartProgramView();
        startProgramView.displayView();
        }
       catch (Throwable e){
           System.out.println(e.getMessage());
       }

    }

}
