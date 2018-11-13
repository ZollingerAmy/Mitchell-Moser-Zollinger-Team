/*
 * Describe class. This view engages when...
//Generate a random number between 17 and 27 for the price of an acre of land. Display the price to the user.
//Ask the user “How many acres of new land do you want buy”?
//The user enters a value
//Check to make sure the value is positive. If not, show a message and ask the user to enter the value again.
//Make sure that the player has enough wheat to make the purchase. If not, show a message and ask the user to enter the value again.
// save buy land number to LandControl.setLandToBuy()
// DURING LIVE THE YEAR >>>
//Add the number of acres purchased to the acres owned
//Subtract the wheat used to purchase the land from the wheat in storage

 */
package view;

import control.LandControl;
import java.util.Scanner;

/**
 *
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class BuyLandView extends ViewBase {

    /**
     * Constructor
     */
    public BuyLandView() {
        super();
    }

    @Override
    protected String getMessage() {
        return "\n\nBuy Land\n"
                + "\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements we'll get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("How much land would you like to buy?");

        // Repeat for each input we need, putting it into its proper slot in the array.
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
        // Validate input, use Try/Catch
        try {
            int acresToBuy = Integer.parseInt(inputs[0].trim());
            buyLand(acresToBuy);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Not a valid number. Returning to Manage Crops Menu.");
        }
        // 

        // return false if we want this view to exit and return
        // to the view that called it.
        pause(2000);
        return false;
    }

    private void buyLand(int acresToBuy) {
        LandControl.setLandToBuy(acresToBuy);
    }
}
