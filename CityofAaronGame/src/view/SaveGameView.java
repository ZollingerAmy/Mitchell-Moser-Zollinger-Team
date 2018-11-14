package view;



/**
 *
 * @author Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class SaveGameView extends ViewBase{

    public SaveGameView(){
        super();
    }
    
    @Override
    protected String getMessage() {
        return "Save your current game.\n";
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

        inputs[0] = getUserInput("Please enter a name for your game.");

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

        //if no input return to main menu
        if (inputs[0] == null || inputs[0].equals("")) {
            System.out.println("No game name entered. Returning to the Main Menu...");
            return false;
        }
        saveGame(inputs[0]);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        return false;
        
    }

    /**
     * Control this view's display/prompt/action loop until the user chooses and action that causes this view to close.
     */
    
    private void saveGame(String filename) {
        // AM: need to actually call function to save game data to JSON.
        
        // AM: for now, just print success to user.
        System.out.print("Saved game: " + filename + "\n");
        
    }
}
