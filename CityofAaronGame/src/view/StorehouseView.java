/*
 * StoreHouseView
 */
package view;

import app.CityOfAaron;
import control.PeopleControl;
import control.StorehouseControl;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import model.Game;
import java.util.Scanner;
import model.Storehouse;
import java.util.ArrayList;

/**
 *
 * @author Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class StorehouseView extends ViewBase {

    Game thisGame = CityOfAaron.getCurrentGame();
    private Object TheStorehouse;

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
                + "5 - View Tools to replace\n"
                + "6 - Save Tools to replace\n"
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

        inputs[0] = getUserInput("Which report would you like?");

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
        try {
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
                case "5":
                    poorCondition();
                    break;
                case "6":
                    savePoorCondition();
                    break;
                case "7":
                    easterEgg();
                    break;
                case "X":
                    return false;
            }
            
        } catch (NullPointerException npe) {
           ErrorView.display(this.getClass().getName(), "A choice must be made.");
        }return true;
    }

    private void animals() {
        this.console.println(thisGame.getTheStorehouse().getAnimals());
    }

    private void tools() {
        this.console.println(thisGame.getTheStorehouse().getTools());
    }

    private void provisions() {
        this.console.println(thisGame.getTheStorehouse().getProvisions());
    }

    private void authors() {
        this.console.println(Arrays.toString(thisGame.getTheStorehouse().getAuthors()));
    }

    private void easterEgg() {
        String str = PeopleControl.prettyPrint("You found the easter egg!", "cyan");
        this.console.println(str);
    }

    private void poorCondition() {
        this.console.println(thisGame.getTheStorehouse().getPoorCondition());
    }

    private void savePoorCondition() {
//         System.out.println("Please enter a file name to save report.");
        try {
            String file = new String();
            file = getUserInput("Please enter a file name to save report.");
            File location = new File("C:\\Users\\Amy\\Documents\\" + file + ".txt");
            FileWriter write = new FileWriter(location);
            write.write("Coming Soon" /*StorehouseControl.printPoorCondition(thisGame.getTheStorehouse().getPoorCondition())*/);
            write.close();
        } catch (IOException e) {
            ErrorView.display(this.getClass().getName(), "Must enter file name.");
        }
        }
    }
