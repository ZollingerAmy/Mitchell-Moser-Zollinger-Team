/*
 * Main Menu class. This view engages on game startup right after the welcome message, and is 
 * bounced back to when deeper views exit.
 */
package view;

import java.util.Scanner;

/**
 *
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class MainMenuView extends ViewBase{

    public MainMenuView(){
        super();
    }
    

    /**
     * Constructor
     * @return 
     */
    @Override
    protected String getMessage() {
        return "\n\n--------------------\n"
                + "Main Menu\n"
                + "--------------------\n"
                + "N - Start new game\n"
                + "L - Load saved game\n"
                + "H - Help menu\n"
                + "Q - Quit game\n"
                + "\n";

    }

    
    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        String[] inputs = new String[1];
        inputs[0] = getUserInput("Please select a choice from the Main Menu.");

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
        switch (inputs[0].trim().toUpperCase()) {
            case "N":
                startNewGame();
                break;
            case "L":
                loadSavedGame();
                break;
            case "H":
                helpMenu();
                break;
            case "Q":
                System.out.println("Thank you for playing. Good-bye.");
                return false;
        }

        return true;
    }

   
    // Define action handlers here. These are the methods that doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void startNewGame() {
        NewGameView view = new NewGameView();
        view.displayView();
    }

    private void helpMenu() {
        HelpMenuView help = new HelpMenuView();
        help.displayView();
    }

    private void loadSavedGame() {
        System.out.println("***Saved game coming soon. Please choose a different option");//AZ
    }
}
