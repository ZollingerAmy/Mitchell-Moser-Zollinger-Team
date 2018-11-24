package control;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class LandControl {
    // here we store all the upcoming data from user inputs (mostly from ManageCropsView) - GOES WITH WHEATCONTROL

    private static int upcomingLandPrice = 0;
    private static int landToBuy = 0;
    private static int landToSell = 0;

    public static int getUpcomingLandPrice() {
        return upcomingLandPrice;
    }

    public static void setUpcomingLandPrice() {
        int price = GameControl.getRandomNumber(17, 27);
        upcomingLandPrice = price;
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
