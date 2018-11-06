/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.util.Scanner;

/**
 *
 * @author Amy
 */
public class LoadGameView {
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public LoadGameView(){
        
        message = "\n\nLoad a saved game.\n\n"
                + "L - load saved game\n"
                + "N - Start new game\n"
                + "R - Return to Main Menu\n";
    }
    
    
    /**
     * Get the user's input. Keep prompting them until they enter a value.
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a return key)
     * @return 
     */
    protected String getUserInput(String prompt, boolean allowEmpty){
        
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;
        
        while(inputReceived == false){
            
            System.out.println(prompt);
            input = keyboard.nextLine();
            
            // Make sure we avoid a null-pointer error.
            if (input == null){
                input = "";
            }
            
            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();
            
            if (input.equals("") == false || allowEmpty == true){
                inputReceived = true;
            }
        }
        
        return input;
    }
    
    
    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we don't have 
     * to type it ourselves.
     * @param prompt
     * @return 
     */
    protected String getUserInput(String prompt){
        return getUserInput(prompt, false);
    }
    
    /**
     * Get the set of inputs from the user.
     * @return 
     */
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        inputs[0] = getUserInput("Please enter name of saved game you would like to play.");
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
    }
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){
         if (inputs[0] == null || inputs[0].equals("")) {
            System.out.println("No game entered. Returning to the Main Menu...");
            return false;
        }
       // MainMenuView.loadSavedGame();
        
        return false;
    }
//    public boolean doAction(String[] inputs) {
//        // Act on the user's input.
//        if (inputs[0] == null || inputs[0].equals("")) {
//            System.out.println("No player name entered. Returning to the Main Menu...");
//            return false;
//        }
//
//        String playerName = inputs[0];
//        createAndStartGame(playerName);
//
//        //return false so we don't loop.
//        return false;
//    }
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses and action that causes this view to close.
     */
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private boolean loadSavedGame(){
        // Define whatever code you need here to accomplish the action.
        // You can make this a void method if you want. Whatever you need 
        // here, you are free to do.
        //
        // Generally, though, this is where you will call into your Control
        // classes to do the work of the application.
        
        return true;
    }
}

//doAction(inputs): boolean {
//Convert input values to the appropriate datatype as needed
//Call a Control Layer method to perform the action
//IF the Control Layer method returns an error then
// display an error message
// RETURN false (Repeats the current view)
//ENDIF
//DISPLAY a success message
//IF a new view is to be displayed THEN
// Create the new View
// Display the new view
//ENDIF
//RETURN true (Terminates the current view)
//}
