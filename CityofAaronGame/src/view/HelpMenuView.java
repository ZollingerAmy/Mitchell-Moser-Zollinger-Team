/*
 * Help Menu class. This view engages when the player chooses "H" from the Main Menu.
 */
package view;

import java.util.Scanner;

/**
 *
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class HelpMenuView {

    /**
     * The message that will be displayed by this view.
     */
    protected String message;

    /**
     * Constructor
     */
    public HelpMenuView() {

        message = "\n\n--------------------\n"
                + "Help Menu\n"
                + "--------------------\n"
                + "1 - Game Goals\n"
                + "2 - Where is the city of Aaron?\n"
                + "3 - How to view map\n"
                + "4 - How to move to another location\n"
                + "5 - How to display items in storehouse\n"
                + "X - Exit to the Main Menu\n";

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
        inputs[0] = getUserInput("Which help menu option would you like?");

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
        String which;
        which = inputs[0].trim().toUpperCase();
        switch (which) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                helpItemMessage(which);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException exception) {
                }

                break;
            case "X":
                return false;
        }
        return true;
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
    private void helpItemMessage(String which) {
        switch (which) {
            case "1":
                which = "\n\n--------------------\n"
                        + "Your goal, as steward of the City of Aaron, is\n"
                        + "to care for your people in such a way that they\n"
                        + "thrive (or at least don't die!). This is done by\n"
                        + "careful management of your wheat fields over the\n"
                        + "course of your term as leader."
                        + "\n--------------------\n";
                break;

            case "2":
                which = "\n\n--------------------\n"
                        + "The City of Aaron is a lovely Nephite land with fields\n"
                        + "and villages, rivers and wild lands, stretching from\n"
                        + "the center of rule to the border of Lamanite land."
                        + "\n--------------------\n";
                break;

            case "3":
                which = "\n\n--------------------\n"
                        + "View the Map at the start of any new or saved game\n"
                        + "or at any time from Game Menu."
                        + "\n--------------------\n";
                break;

            case "4":
                which = "\n\n--------------------\n"
                        + "Move to a new location at the start of any new or saved game\n"
                        + "or at any time from Game Menu."
                        + "\n--------------------\n";
                break;

            case "5":
                which = "\n\n--------------------\n"
                        + "You may view the Storehouse at the start of any new or saved game\n"
                        + "or at any time from Game Menu, by choosing the 'Reports Menu'."
                        + "\n--------------------\n";
                break;

        }
        System.out.println(which);
    }

}
