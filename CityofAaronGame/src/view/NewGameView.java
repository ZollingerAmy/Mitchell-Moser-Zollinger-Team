/*
 * New Game class. This view engages when the player chooses "N" from the Main Menu.
 */
package view;

import java.util.Scanner;
import app.CityOfAaron;
import control.GameControl;
import control.LandControl;
import model.AnnualReport;
import model.Player;
import model.Game;

/**
 *
@author Amber Mitchell, Teresa Moser, Amy Zollinger */
public class NewGameView extends ViewBase{

    public NewGameView(){
        super();
    }
    
    @Override
    protected String getMessage() {

        return "\n\nLet's get to playing!\n\n";
    }

        /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements we get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("Please enter your name, or press 'Enter' to return to the Main Menu", true);

        return inputs;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
        // Act on the user's input.
        if (inputs[0] == null || inputs[0].equals("")) {
            System.out.println("No player name entered. Returning to the Main Menu...");
            return false;
        }

        String playerName = inputs[0];
        createAndStartGame(playerName);

        //return false so we don't loop.
        return false;
    }

   
    // Define action handlers here. These are the methods that doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void createAndStartGame(String playerName) {

        GameControl.createNewGame(playerName);

        Game thisGame = CityOfAaron.getCurrentGame();
        AnnualReport thisReport = CityOfAaron.getCurrentReport();

        System.out.println(
                "\nWelcome to the game, " + thisGame.getThePlayer().getName() + "! \n"
                + "Year: " + thisGame.getYear() + "\n"
                + "Acres of wheat fields: " + thisReport.getEndingAcresOwned() + "\n"
                + "Bushels per acre harvested: " + thisReport.getBushelsPerAcre() + "\n"
                + "Total bushels harvested: " + thisReport.getBushelsHarvested() + "\n"
                + "Bushels paid in tithes and offerings: " + thisReport.getTithingAmount() + "\n"
                + "Bushels stolen by robbers: " + thisReport.getLostToRobbers() + "\n"
                + "Bushels of wheat in store: " + thisReport.getEndingWheatInStorage() + "\n"
                + "People starved: " + thisReport.getPeopleStarved() + "\n"
                + "People arrived in city: " + thisReport.getPeopleMovedIn() + "\n"
                + "Current population: " + thisReport.getEndingPopulation() + "\n"
        );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        // now head over to the Game View!
        View gameMenu = new GameMenuView();
        gameMenu.displayView();
    }
}
