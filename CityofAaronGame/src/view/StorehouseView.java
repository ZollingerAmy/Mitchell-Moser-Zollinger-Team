/*
 * StoreHouseView
 */
package view;
import java.util.Scanner;
/**
 *
 * @author TeresaMoser
 */
public class StorehouseView {

    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public StorehouseView(){
        
        message = "StoreHouse Reports: \n"
                + "A - View Animal report \n"
                + "T - View Tool report \n"
                + "P - View Provisions report\n"
                + "M - View the authors of this game\n";              
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
        
        inputs[0] = getUserInput("On the next line choose a letter from "
                + "the StoreHouse Reports and press enter.");
        
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
        // Act on the user's input.
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.
        
        // return false if you want this view to exit and return
        // to the view that called it.
        
        switch(inputs[0].trim().toUpperCase()){
            case "A":
                animals();
                break;
            case "T":
                tools();
                break;
            case "P":
                provisions();
                break;
            case "M":
                authors();
                return false;
        }
      return true;
    }
    
    
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
    
    
     private void animals(){
         System.out.println("***Animal Reports coming soon. Please choose a different option");
    }
    
    private void tools(){
         System.out.println("***Tool Reports coming soon. Please choose a different option");
    }
    
    private void provisions(){
        System.out.println("***Provision Reports coming soon. Please choose a different option");
    }
    
    private void authors(){
        System.out.println("***Authors List coming soon. Please choose a different option");
    }
    
}

