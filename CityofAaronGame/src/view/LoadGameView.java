package view;

import java.util.Scanner;

/**
 *
 * @author Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class LoadGameView {

    protected String message;

    /**
     * Constructor
     */
    public LoadGameView() {
        message = "Load a saved game.\n";
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

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("Please enter the name of your saved game.");

        return inputs;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs) {

        //if no input return to main menu
        if (inputs[0] == null || inputs[0].equals("")) {
            System.out.println("No game name entered. Returning to the Main Menu...");
            return false;
        }
        loadGame(inputs[0]);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        return false;
        //this continues to loop if true or false?
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
    // First Try
    private void loadGame(String filename) {
        // AM: need to actually call function to load game data from a JSON file.
        
        // AM: for now, just print success to user.
        System.out.print("Loaded game: " + filename + "\n");
        
    }
}
