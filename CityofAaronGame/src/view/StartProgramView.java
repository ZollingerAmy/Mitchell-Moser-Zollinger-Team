/*
 * Start Program class. This view engages on game startup.
 */
package view;

import java.util.Scanner;

/**
 *
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class StartProgramView {

    /**
     * The message that will be displayed by this view.
     */
    protected String message;

    /**
     * Constructor
     */
    public StartProgramView() {


        message ="\n\n--------------------\n"
                + "Welcome to the City of Aaron Game.\n" 
                +"You have been chosen to be the leader of the City of Aaron.\n"//Program start description
                +"Wheat is the staff of life, and is used as the main currency in the city.\n\n"//objective
                + "Your responsiblities are as follows:  \n"
                +"\n"
                +"  * to buy and sell land \n"
                +"  * to determine how much wheat to plant each year \n"
                +"  * to determine how much wheat to set aside to feed your people\n"
                +"\n"
                +"In addition, it will be your job to pay an annual tithe on the wheat that is harvested. \n"
                +"If you fail to produce enough wheat for your people, they will starve, and some people will die.\n"
                +"This will leave your workforce diminished. \n"
                +"To become a great leader you must plan wisely. And by the way, there will be chances of being raided by robbers!\n";

                
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

        String[] inputs = new String[1];
        inputs[0] = getUserInput("To begin, press Enter. Good luck!\n", true);

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
        startMainMenuView();

        return false;
    }

    /**
     * Control this view's display/prompt/action loop until the user chooses and action that causes this view to close.
     */
    public void displayView() {

        boolean keepGoing = true;

        while (keepGoing == true) {

            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }

    // Define action handlers here. These are the methods that doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void startMainMenuView() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
        }

        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayView();
    }
}
