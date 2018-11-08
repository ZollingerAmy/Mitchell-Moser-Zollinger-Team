package control;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class LandControl {
//    In my own implementation of the game, I have defined a variable in the LandControl to hold the 
//    current year's price (it would be a good discussion about whether this piece of data belongs in a model 
//    class somewhere). Then I added a method called updateYearlyLandPrice() in LandControl, which then 
//            gets the random number between 17 and 27 and sets the price for the year. 
//
//LandControl.updateYearlyLandPrice() can be called at the end of liveTheYear() 
//    to set up for the next year. (You'll have to make sure it gets called by the NewGameView, 
//            too, so the first year gets a valid price.)

    private static int currentLandPrice = 30;
    private static int bushelsForLand;

    
    public static int getCurrentLandPrice() {
        return currentLandPrice;
    }

    public static void updateYearlyLandPrice() {
        int price = GameControl.getRandomNumber(17,27);
        currentLandPrice = price;
    }

    public static int getBushelsForLand() {
        return bushelsForLand;
    }

    public static void updateBushelsForLand() {
        int bushels = GameControl.getRandomNumber(3,5);
        bushelsForLand = bushels;
    }


}
