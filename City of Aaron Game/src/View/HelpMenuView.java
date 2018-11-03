/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;

/**
 *
 * @author Amy
 */
public class HelpMenuView {
    
   
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
  
    
    /**
     * Constructor
     */
    public HelpMenuView(){
        
        message = "Help Menu\n"
                + "--------------------\n"
                + "G - Game Goals\n"
                + "W - Where is the city of Aaron?\n"
                + "V - How to view map\n"
                + "M - How to move to another location\n"
                + "D - How to display items in storehouse\n"
                + "Q - Quit\n";
                
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
        
        inputs[0] = getUserInput("Which help menu option would you like?");
      
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
            case "G":
                gameGoals();
                break;
            case "W":
                cityofAaronLocation();
                break;
            case "V":
                viewMap();
                break;
            case "M":
                move();
                break; 
            case "D":
                displayStorehouseItems();
                break;
            case "Q":
                System.out.println("Thank you for playing. Good-bye.");
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
    
    
   
     private void gameGoals(){
       System.out.println("Goals of the Game");
        System.out.println("Goals of the Game");
    }
    
    private void cityofAaronLocation(){
      System.out.println("***   City of Aaron location coming soon.");
    }
    
    private void  viewMap(){
        System.out.println("***   Map view coming soon.");
    }

    private void  move(){
        System.out.println("*** move() called. Need to implement");
    }
     
    private void  displayStorehouseItems(){
        System.out.println("***   Storehouse items coming soon.");
    }
}