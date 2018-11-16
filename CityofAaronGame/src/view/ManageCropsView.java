/*
 * Manage Crops View 
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class ManageCropsView extends ViewBase {

    /**
     * Constructor
     */
    public ManageCropsView() {

    }

    @Override
    protected String getMessage() {
        return "\n\n--------------------\n"
                + "Manage Crops\n"
                + "--------------------\n"
                + "1 - Buy Land \n"
                + "2 - Sell Land \n"
                + "3 - Feed your People\n"
                + "4 - Plant Crops \n"
                + "5 - Pay Tithes and Offereings \n"
                + "X - Return to the Game Menu \n";
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

        inputs[0] = getUserInput("Choose the number of the next action you want to"
                + " take from the Menu.");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

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
                buyLand();
                break;
            case "2":
                sellLand();
                break;
            case "3":
                feedPeople();
                break;
            case "4":
                plantCrops();
                break;
            case "5":
                payTithes();
                break;
            case "X":
                return false;
        }
        return true;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void buyLand() {
        BuyLandView view = new BuyLandView();
        view.displayView();
    }

    private void sellLand() {
        SellLandView view = new SellLandView();
        view.displayView();
    }

    private void feedPeople() {
        FeedPeopleView view = new FeedPeopleView();
        view.displayView();
    }

    private void plantCrops() {
        PlantCropsView view = new PlantCropsView();
        view.displayView();
    }

    private void payTithes() {
        PayTithingView view = new PayTithingView();
        view.displayView();
    }

}
