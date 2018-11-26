package control;

import model.Game;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class PeopleControl {

    // store the user rating message
    private static String userMessage = "";

    public static int calculateMortality(int bushelsSetAside, int currentPopulation) {

// Calculate the number of people who are not fed the amount required to
// sustain life (20 bushels per person). They die. It is very sad.
        if (bushelsSetAside < 0) {
            return -1;
        }

        if (currentPopulation < 0) {
            return -1;
        }

        int numberOfPeopleFed = bushelsSetAside / 20;

        if (numberOfPeopleFed > currentPopulation) {
            return 0; // everyone got fed
        }
        return (currentPopulation - numberOfPeopleFed);

    }

    public static int calculateNewMoveIns(int currentPopulation) {
        int peopleMovedIn;
        int rand = GameControl.getRandomNumber(1, 5);
        peopleMovedIn = currentPopulation * rand / 100;

        return peopleMovedIn;
    }

    public static int calculateUserRating(Game game) {
        String[] heroes = {
            "You have the wisdom of King Benjamin and have led your people well!",
            "As strategic as Captain Moroni you have been able to provide for the people and keep your city safe.",
            "Even as King Mosiah you have brought the people to a time of prosperity!",
            "With the strength of Teancum, you have blessed your city and will run for another term!",
            "Just as King Zeniff ruled his people, you have displayed courage in your decisions!"
        };
        String[] villains = {
            "Your name is equal to that of Amalickiah--Nephite traitor King of the Lamanites, you have betrayed your people and laid waste to all the land!",
            "Wow! You should be the next chief of the Gadianton Robbers!",
            "Kishkumen wants to recruit you to be one of his tactical raiders!",
            "With the cunning of Korihor, the antichrist, you have waylaid destruction to all your people and lands!",
            "Did you take notes on how Wicked King Noah ruled, you are cleverly following his example!"
        };

        int userRating = 0;
        // grab a random for use
        int rand = GameControl.getRandomNumber(0,4);
        int pop = game.getCurrentPopulation();
        int wheat = game.getWheatInStorage();
        int land = game.getAcresOwned();

        // first look at current population for GameControl.gameShouldEnd()
        if (pop <= 10) {
            return userRating;
        } else if (pop < 100 || wheat < 3000 || land < 1000) {
            // VILLAIN message
            userMessage = villains[rand];
            userRating = 1;
        } else {
            // then HERO message
            userMessage = heroes[rand];
            userRating = 2;
        }

        return userRating;
    }

    public static String getUserMessage() {
        return userMessage;
    }
}
