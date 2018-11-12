package view;

import app.CityOfAaron;
import control.GameControl;
import control.LandControl;
import control.WheatControl;
import java.util.Scanner;
import model.AnnualReport;
import model.Game;

/**
 *

 * @author Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class GameMenuView {
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;

    /**
     * Constructor
     */
    public GameMenuView() {


        message = "\n\n--------------------\n"
                + "Game Menu Options\n"
                + "--------------------\n"
                + "1 - Show Annual Report\n"
                + "2 - View Map\n"
                + "3 - Move Location\n"
                + "4 - Manage crops\n"
                + "5 - Live year\n"
                + "6 - View storehouse\n"
                + "7 - Save game\n"
                + "X - Exit to Main Menu\n";

    }

    /**
     * Get the user's input. Keep prompting them until they enter a value.
     *
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a return key)
     * @return
     */
    protected String getUserInput(String prompt, boolean allowEmpty) {

        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;

        while (inputReceived == false) {

            System.out.println(prompt);
            input = keyboard.nextLine();

            // Make sure we avoid a null-pointer error.
            if (input == null) {
                input = "";
            }

            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();

            if (input.equals("") == false || allowEmpty == true) {
                inputReceived = true;
            }
        }

        return input;
    }

    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we don't have to type it ourselves.
     *
     * @param prompt
     * @return
     */
    protected String getUserInput(String prompt) {
        return getUserInput(prompt, false);
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    public String[] getInputs() {


        String[] inputs = new String[1];
        inputs[0] = getUserInput("Which game menu option would you like?");


        return inputs;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs) {
        // Act on the user's input.
        switch (inputs[0].trim().toUpperCase()) {

            case "1":
                displayAnnualReport();
                break;
            case "2":
                viewMap();
                break;
            case "3":
                moveLocation();
                break;
            case "4":
                manageCrops();
                break;
            case "5":
                liveYear();
                break;
            case "6":
                viewStorehouse();
                break;
            case "7":
                saveGame();
                break;
            case "X":
                System.out.println("Returning to Main Menu.");
                return false;
        }

        return true;
    }

    /**
     * Control this view's display/prompt/action loop until the user chooses and action that causes this view to close.
     */
    public void displayView() {

        boolean keepGoing = true;

        while (keepGoing == true) {

            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    
 private void displayAnnualReport() {
        AnnualReportView report = new AnnualReportView();
        report.displayView();
    }
   
    private void viewMap() {
        MapView view = new MapView();
        view.displayView();
    }

    private void moveLocation() {
        MoveLocationView view = new MoveLocationView();
        view.displayView();
    }

    private void manageCrops() {
        ManageCropsView crops = new ManageCropsView();
        crops.displayView();
    }
   
     private void liveYear() {
        // we better check that we have all the data to live the year properly (tithesPercent, bushelsForFood, acresToPlant)
         
        Game thisGame = CityOfAaron.getCurrentGame();
        int tithesPercent = WheatControl.getTithingPercentToPay();
        int bushelsForFood = WheatControl.getBushelsToFeedPeople();
        int acresToPlant = WheatControl.getAcresToPlant();
        
        // live the year and return a report 
        AnnualReport thisReport = GameControl.liveTheYear(thisGame, tithesPercent,
            bushelsForFood, acresToPlant);

        // update the main report
        CityOfAaron.setCurrentReport(thisReport);
        
        // this may be a good place to check GameControl.gameShouldEnd();

        // now display the report
        System.out.println("\nAnnual Report for " + thisGame.getThePlayer().getName() + "! \n");
        System.out.println("Year: " + thisGame.getYear() + "\n");
        System.out.println("People starved: " + thisReport.getPeopleStarved() + "\n");
        System.out.println("People arrived in city: " + thisReport.getPeopleMovedIn() + "\n");
        System.out.println("Current population: " + thisReport.getEndingPopulation() + "\n");
        System.out.println("Acres of wheat fields: " + thisReport.getEndingAcresOwned() + "\n");
        System.out.println("Bushels per acre harvested: " + thisReport.getBushelsPerAcre() + "\n");
        System.out.println("Total bushels harvested: " + thisReport.getBushelsHarvested() + "\n");
        System.out.println("Bushels paid in tithes and offerings: " + thisReport.getTithingAmount() + "\n");
        System.out.println("Bushels stolen by robbers: " + thisReport.getLostToRobbers() + "\n");
        System.out.println("Bushels of wheat in store: " + thisReport.getEndingWheatInStorage() + "\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        
    }
     
      private void viewStorehouse() {
        StorehouseView storehouse = new StorehouseView();
        storehouse.displayView();
    }

    private void saveGame() {
        SaveGameView save = new SaveGameView();
        save.displayView();
    }

}