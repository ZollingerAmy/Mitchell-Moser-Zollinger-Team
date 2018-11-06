/*
 * MoveLocationView class. This view engages when the user selects "Move" from the Game Menu.
 */
package view;

import app.CityOfAaron;
import java.util.Scanner;
import model.Location;
import model.Point;

/**
 *
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class MoveLocationView {

    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    // get the map from the model;
    Location[][] mapArray = CityOfAaron.getCurrentGame().getTheMap().getLocations();

    /**
     * Constructor
     */
//    The user will be prompted to enter the coordinates of the location on the map that they 
//            want to move to. Upon arriving at the new location, the program will display the name 
//                    of the location and the description of what can be seen at this location.
    public MoveLocationView() {
        message = "\nMove to a new location in the City of Aaron."
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

        inputs[0] = getUserInput("Type a row and column to move location -- format: row/col \nor type 'X' to return to the Game Menu.");

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
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.
        String go = inputs[0].trim().toUpperCase();

        switch (go.substring(0, 1)) {
            case "X":
                System.out.println("Returning to Game Menu.");
                return false;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                try {
                    int row = Integer.parseInt(go.substring(0, 1));
                    int col = Integer.parseInt(go.substring(go.length() - 1));
                    moveLocation(mapArray, row, col);
                } catch (NumberFormatException | NullPointerException e) {
                    System.out.println("Please enter a row and column number such as: '2/4'.");
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }

        }

        // return false if we want this view to exit and return
        // to the view that called it.
        return true;
    }

    /**
     * Control this view's display/prompt/action loop until the user chooses an action that causes this view to close.
     */
    public void displayView() {

        boolean keepGoing = true;

        while (keepGoing == true) {

            System.out.println(message);
            // here is where we'll print the WHOLE MAP (using handler??)
            String printableMap = viewMap(mapArray);
            System.out.println(printableMap);

            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    // Define action handlers here. These are the methods that the doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void moveLocation(Location[][] mapArray, int row, int col) {
        // look up the location with above args
        row--;
        col--;
        Location thisLocation = mapArray[row][col];

        // update current location
        Point point = new Point();
        point.setRow(row);
        point.setColumn(col);
        CityOfAaron.getCurrentGame().getTheMap().setCurrentLocation(point);

        // print to user
        System.out.println(thisLocation.getMapSymbol() + " " + thisLocation.getName() + "\n"
                + thisLocation.getDescription() + "\n" + thisLocation.getGameTip());
    }

    private String viewMap(Location[][] mapArray) {

// loop through and make it look pretty for the two dimensions
        String mapString = "";
        for (int i = 0; i < mapArray.length; i++) {
            mapString += "\n###################################################################################################################################\n";

            for (int j = 0; j < mapArray[i].length; j++) {
                String symbol = mapArray[i][j].getMapSymbol();
                String name = mapArray[i][j].getName();

                mapString += "##    " + symbol + "  " + name + "    ##";
            }

            mapString += "\n###################################################################################################################################";
            //System.out.println(string)

        }

        // add prettiness to string?
        mapString += "\n\n";
        return mapString;
    }
}
