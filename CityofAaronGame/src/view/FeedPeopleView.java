/*
 * Describe class. This view engages when...
//Ask the user “How many bushels of grain do you want to give to the people?”
//User enters a value.
//Check to make sure that the value is positive. If it is not, show a message and ask the user to enter the value again.
//Make sure that the city has this much wheat in storage. If not, show a message and ask the user to enter the value again.
// save the number to WheatControl.setBushelsToFeedPeople()
// DURING LIVE THE YEAR >>>
//Subtract this amount from the wheat in storage. Display the amount of wheat you have left.
//Update the game state to save how many bushels of wheat you have set aside to feed the people.

 */
package view;

import control.WheatControl;
import java.util.Scanner;

/**
 *
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class FeedPeopleView {

    /**
     * The message that will be displayed by this view.
     */
    protected String message;

    /**
     * Constructor
     */
    public FeedPeopleView() {
        message = "\n\nFeed your People\n"
                + "\n";
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

        // Declare the array to have the number of elements we'll get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("How many bushels of wheat would you like to \n"
                + "set aside to feed your people this year?");

        // Repeat for each input we need, putting it into its proper slot in the array.
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
        // Validate input, use Try/Catch
        try {
            int bushelsToFeedPeople = Integer.parseInt(inputs[0].trim());
            feedPeople(bushelsToFeedPeople);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Not a valid number. Returning to Manage Crops Menu.");
        }
        // 


        // return false if we want this view to exit and return
        // to the view that called it.
        try {Thread.sleep(2000);} catch (InterruptedException e) {}
        return false;
    }

    /**
     * Control this view's display/prompt/action loop until the user chooses an action that causes this view to close.
     */
    public void displayView() {

        boolean keepGoing = true;

        while (keepGoing == true) {

            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    // Define action handlers here. These are the methods that the doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void feedPeople(int bushelsToFeedPeople) {
        WheatControl.setBushelsToFeedPeople(bushelsToFeedPeople);
    }
}
