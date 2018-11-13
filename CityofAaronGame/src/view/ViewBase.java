/*
 * This is our view base, that all the other views share.
 */
package view;

import java.util.Scanner;

/**
 *
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public abstract class ViewBase implements View {
    
    /**
     * Constructor
     */
    public ViewBase(){
    }
    
    /**
     * Get the view's content.
     */
    protected abstract String getMessage();


    /**
     * Get the set of inputs from the user.
     */
    protected abstract String[] getInputs();
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     */
    public abstract boolean doAction(String[] inputs);
    
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses an action that causes this view to close.
     */
    public void displayView(){
        boolean keepGoing = true;

        while(keepGoing == true){
            String message = getMessage();
            if (message != null) {
            System.out.println(getMessage());
            }
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
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
    
    protected static void pause(int milliseconds) {
        try {Thread.sleep(milliseconds);
        } catch (InterruptedException e) {}
    }
    
}
