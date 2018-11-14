/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public abstract class ViewBase implements View {
    
    public ViewBase(){
        
    }
    
protected abstract String getMessage();

protected abstract String[] getInputs();

protected abstract boolean doAction(String[] inputs);

 public void displayView() {

        boolean keepGoing = true;

        while (keepGoing == true) {

            String message = getMessage();
            if (message!= null){
            System.out.println(getMessage());
            }
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }
 
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

        
    
}
