
package view;

import java.util.Scanner;

/**
 *

 * @author Amy
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
                + "1 - View Map\n"
                + "2 - Move Location\n"
                + "3 - Manage crops\n"
                + "4 - Live year\n"
                + "5 - View storehouse\n"
                + "6 - Save game\n"
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
                viewMap();
                break;
            case "2":
                moveLocation();
                break;
            case "3":
                manageCrops();
                break;
            case "4":
                liveYear();
                break;
            case "5":
                viewStorehouse();
                break;
            case "6":
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

    
 private void displayCurrentReport() {
        StorehouseView report = new StorehouseView();//where will this be?
        System.out.println("***Game report coming soon. Please choose a different option");
    }
   
    private void manageCrops() {
        ManageCropsView crops = new ManageCropsView();
        System.out.println("***Game crops coming soon. Please choose a different option");
    }
   
    
     private void liveYear() {
        GameMenuView year = new GameMenuView();//where will this be?
        System.out.println("***Game year coming soon. Please choose a different option");
    }
     
      private void viewStorehouse() {
        StorehouseView storehouse = new StorehouseView();
        System.out.println("***View storehouse coming soon. Please choose a different option");
    }

    private void saveGame() {
        SaveGameView save = new SaveGameView();
        save.displayView();
    }

    private void mainMenu() {
        MainMenuView mainmenu = new MainMenuView();
        mainmenu.displayView();
    }

    private void viewMap() {
        MapView view = new MapView();
        view.displayView();
    }
    private void moveLocation() {
        MoveLocationView view = new MoveLocationView();
        view.displayView();
    }

}
