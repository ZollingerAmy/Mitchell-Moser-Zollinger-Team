package control;

import app.CityOfAaron;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class PeopleControl {
    
    public static int calculateMortality(int bushelsSetAside, int currentPopulation){

// Calculate the number of people who are not fed the amount required to
// sustain life (20 bushels per person). They die. It is very sad.

    if (bushelsSetAside < 0 ){
        return -1;
    }

    if (currentPopulation < 0){ 
        return -1;
    }
    
    int numberOfPeopleFed = bushelsSetAside / 20;

    if (numberOfPeopleFed > currentPopulation){ 
            return 0; // everyone got fed
    }
    return (currentPopulation - numberOfPeopleFed);
    
}
    public static int calculateNewMoveIns(int currentPopulation) {
        int peopleMovedIn;
        int rand = GameControl.getRandomNumber(1,5);
        peopleMovedIn = currentPopulation * rand / 100;
        
        return peopleMovedIn;
    }
}