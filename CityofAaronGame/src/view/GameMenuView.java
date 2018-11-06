
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
                + "D - Display current report\n"
                + "V - View map\n"
                + "L - Move location\n"
                + "C - Manage crops\n"
                + "Y - Live year\n"
                + "S - View storehouse\n"
                + "G - Save game\n"
                + "R - Return to Main Menu\n";

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
            case "D":
                displayCurrentReport();
                break;
            case "V":
                viewMap();
                break;
            case "L":
                moveLocation();
                break;
            case "C":
                manageCrops();
                break;
            case "Y":
                liveYear();
                break;
            case "S":
                viewStorehouse();
                break;
            case "G":
                saveGame();
                break;
            case "R":
                mainMenu();
                break;
            case "Q":
                System.out.println("Thank you for playing. Good-bye.");
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
 
  private void viewMap() {
        MapView map = new MapView();
        System.out.println("***Game map coming soon. Please choose a different option");
    }
  
   private void moveLocation() {
        MoveLocationView location = new MoveLocationView();
        System.out.println("***Game location coming soon. Please choose a different option");
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
}
