/*
 * StoreHouseView
 */
package view;

import app.CityOfAaron;
import control.GameControl;
import java.util.ArrayList;
import model.Condition;
import model.Game;
import model.Storehouse;
import model.InventoryItem;

/**
 *
 * @author Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class StorehouseView extends ViewBase {

    /**
     * Constructor
     */
    public StorehouseView() {
    }

    @Override
    protected String getMessage() {
        return "\n\n--------------------\n"
                + "The Storehouse\n"
                + "--------------------\n"
                + "1 - View Animal report \n"
                + "2 - View Tool report \n"
                + "3 - View Provisions report\n"
                + "4 - View the authors of this game\n"
                + "X - Return to the Game Menu\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("On the next line choose a letter from "
                + "the StoreHouse Reports and press enter.");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
        // Act on the user's input.
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.
        // return false if you want this view to exit and return
        // to the view that called it.
        switch (inputs[0].trim().toUpperCase()) {
            case "1":
                animals();
                break;
            case "2":
                tools();
                break;
            case "3":
                provisions();
                break;
            case "4":
                authors();
                break;
            case "X":
                return false;
        }
        return true;
    }

    Game thisGame = CityOfAaron.getCurrentGame();

    private void animals() {
        System.out.println("***Animal Reports coming soon. Please choose a different option");
    }

    private void tools() {
        System.out.println(thisGame.getTheStorehouse());
    }

    private void provisions() {
        System.out.println("***Provision Reports coming soon. Please choose a different option");
    }

    private void authors() {
        System.out.println("***Authors List coming soon. Please choose a different option");
    }

}
