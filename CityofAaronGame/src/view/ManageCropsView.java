/*
 * Manage Crops View 
 */
package view;
import java.util.Scanner;


/**
 *
 * @author Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class ManageCropsView {
      
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public ManageCropsView(){
        
        message = "\n\n--------------------\n"
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
        
        inputs[0] = getUserInput("Choose the number of the next action you want to"
                + " take from the Menu.");
        
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
                acresPlanted();
                break;
            case "5":
                tithesPercent();
                break;
            case "X":
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
    
    
    private void buyLand(){
       BuyLandView view = new BuyLandView();
       view.displayView();
    }
    
    private void sellLand(){
       SellLandView view = new SellLandView();
       view.displayView();
    }
    
    private void feedPeople(){
       FeedPeopleView view = new FeedPeopleView();
       view.displayView();
    }
    
    private void acresPlanted(){
       PlantCropsView view= new PlantCropsView();
       view.displayView();
    }
    
    private void tithesPercent(){
       PayTithingView view= new PayTithingView();
       view.displayView();
    }   
    
}
