package control;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class LandControl {
    // here we store all the upcoming data from user inputs (mostly from ManageCropsView) - GOES WITH WHEATCONTROL

    private static int currentLandPrice;
    private static int landToBuy;
    private static int landToSell;

    public static int getCurrentLandPrice() {
        return currentLandPrice;
    }

    public static void setCurrentLandPrice() {
        int price = GameControl.getRandomNumber(17, 27);
        currentLandPrice = price;
    }

    public static int getLandToBuy() {
        return landToBuy;
    }

    public static void setLandToBuy(int landToBuy) {
        LandControl.landToBuy = landToBuy;
    }

    public static int getLandToSell() {
        return landToSell;
    }

    public static void setLandToSell(int landToSell) {
        LandControl.landToSell = landToSell;
    }

}
