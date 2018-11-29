/*
 * MoveLocationView class. This view engages when the user selects "Move" from the Game Menu.
 */
package view;

import app.CityOfAaron;
import control.MapControl;
import model.Location;
import model.Point;

/**
 *
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class MoveLocationView extends ViewBase {

    // get the map from the model;
    Location[][] mapArray = CityOfAaron.getCurrentGame().getTheMap().getLocations();

    /**
     * Constructor
     */
    public MoveLocationView() {
        super();
    }

    @Override
    protected String getMessage() {
        return "\nMove to a new location in the City of Aaron."
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
    @Override
    public boolean doAction(String[] inputs) {
        // Act on the user's input.
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.
        String go = inputs[0].trim().toUpperCase();
        String first = go.substring(0, 1);

        switch (first) {
            case "X":
                System.out.println("Returning to Game Menu.");
                return false;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                try {
                    int row = Integer.parseInt(first);
                    int col = Integer.parseInt(go.substring(go.length() - 1));
                    moveLocation(mapArray, row, col);
                } catch (NumberFormatException | NullPointerException |MapControlException MCE) {
                    System.out.println("Please enter a row and column number such as: '2/4'.");
                }
                pause(3000);
                System.out.println("\nMove successful. Returning to Game Menu.");
                return false;
            default:
                System.out.println("\nPlease enter a row and column number such as: '2/4'\n or 'X' to exit to Game Menu.");
                pause(3000);
        }

        // return false if we want this view to exit and return
        // to the view that called it.
        return true;
    }

    private void moveLocation(Location[][] mapArray, int row, int col) {
        // look up the location with above args
        Location thisLocation = mapArray[row-1][col-1];

     boolean moved = MapControl.moveLocation(row, col);

        // print to user
        System.out.println("\nYou have moved to:\n" + thisLocation.getMapSymbol() + " " + thisLocation.getName() + "\n"
                + thisLocation.getDescription() + "\n" + thisLocation.getGameTip());
    }

    private String viewMap(Location[][] mapArray) {

        // loop through and make it look pretty for the two dimensions
        String mapString = "";
        for (int i = 0; i < mapArray.length; i++) {
            mapString += "\n###################################################################################################################################\n";

            // AM: while loop for individual assignment week 8, change back to FOR loop later.
            int j = 0;
            while (j < mapArray[i].length) {
                String symbol = mapArray[i][j].getMapSymbol();
                String name = mapArray[i][j].getName();
                mapString += "##    " + symbol + "  " + name + "    ##";
                j++;
            }

            mapString += "\n###################################################################################################################################";
            //System.out.println(string)

        }

        // add prettiness to string?
        mapString += "\n\n";
        return mapString;
    }
}
