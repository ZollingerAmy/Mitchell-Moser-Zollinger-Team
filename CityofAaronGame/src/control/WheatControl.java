package control;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class WheatControl {

//AMBER
    public static int calcLossToRobbers(int tithesPercent, int wheatInStorage) {
        // Calculate the amount of wheat in storage lost to robbers, based on
        // the percentage of tithing paid. Assume that GameControl.getRandomNumber(low, high) is available to be called.
        if (wheatInStorage < 0) {
            return -1;
        }
        if (tithesPercent < 0 || tithesPercent > 100) {
            return -2;
        }

        int low = 1;
        int high = 100;
        int chanceOfRobbers = GameControl.getRandomNumber(low, high);

        if (chanceOfRobbers >= 30) {
            return 0;
        }

        if (tithesPercent < 8) {
            low = 6;
            high = 10;
        }

        if (tithesPercent >= 8 && tithesPercent <= 12) {
            low = 3;
            high = 7;
        }
        if (tithesPercent > 12) {
            low = 3;
            high = 5;
        } 
            
        
        int percentLost = GameControl.getRandomNumber(low, high);
        int loss = wheatInStorage * percentLost / 100;
        System.out.println("Percentage of Loss: " + percentLost + " (total below)");

        return loss;

    }
    
// Teresa
    public static int calcHarvest (int acresPlanted, int tithesPercent){
        // Calculate the amount of wheat harvested, based on the percentage
        // of tithing paid. Assume that GameControl.getRandomNumber(low, high)
        // is available to be called.
     
        if (acresPlanted < 0) {
            return -1;
        }
     
        if (tithesPercent < 0 || tithesPercent > 100) {
            return -2;
        }
        
        int low = 1;
        int high = 5;

        if (tithesPercent < 8) {
            low = 1;
            high = 3;   
        }
     
        if (tithesPercent >= 8 && tithesPercent <= 12) {
             low = 2;
             high = 4;       
        }
     
        if (tithesPercent > 12) {
            low = 2;
            high = 5;
        }
        
        int harvest = GameControl.getRandomNumber(low, high);
        int yield = (harvest * acresPlanted);
        return yield;
    }
    
}

