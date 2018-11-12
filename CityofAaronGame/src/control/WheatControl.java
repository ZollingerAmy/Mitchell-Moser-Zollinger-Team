package control;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class WheatControl {
    // here we store all the upcoming data from user inputs (mostly from ManageCropsView) - GOES WITH LANDCONTROL

    private static int bushelsToFeedPeople;
    private static int wheatToPlant;
    private static int acresToPlant;
    private static int tithingPercentToPay;

    public static int getBushelsToFeedPeople() {
        return bushelsToFeedPeople;
    }

    public static void setBushelsToFeedPeople(int bushelsToFeedPeople) {
        WheatControl.bushelsToFeedPeople = bushelsToFeedPeople;
    }

    public static int getWheatToPlant() {
        return wheatToPlant;
    }

    public static void setWheatToPlant(int wheatToPlant) {
        WheatControl.wheatToPlant = wheatToPlant;
    }

    public static int getAcresToPlant() {
        return acresToPlant;
    }

    public static void setAcresToPlant(int acresToPlant) {
        WheatControl.acresToPlant = acresToPlant;
    }

    public static int getTithingPercentToPay() {
        return tithingPercentToPay;
    }

    public static void setTithingPercentToPay(int tithingPercentToPay) {
        WheatControl.tithingPercentToPay = tithingPercentToPay;
    }

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
        
        return loss;

    }
    
// Teresa
    public static int calcHarvest (int perAcre, int acresPlanted){
        // Calculate the amount of wheat harvested, based on the percentage
        // of tithing paid. This is meant to be returned to the Annual Report harvest number
     
        if (acresPlanted < 0 || perAcre < 1) {
            return -1;
        }
     
        int yield = (perAcre * acresPlanted);
        return yield;
    }

    public static int calcBushelsPerAcre (int tithesPercent){
        // Calculate the amount of bushels per acre to be harvested, based on the percentage
        // of tithing paid. Assume that GameControl.getRandomNumber(low, high)
        // is available to be called. This is meant to be returned to the Annual Report bushels per acre number.
     
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
        
        int perAcre = GameControl.getRandomNumber(low, high);
        // store this number in the annual report
        return perAcre;
    }
    
}

