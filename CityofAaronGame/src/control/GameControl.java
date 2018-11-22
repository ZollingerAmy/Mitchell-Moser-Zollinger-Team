package control;

import app.CityOfAaron;
import java.util.ArrayList;
import java.util.Random;
import model.Animal;
import model.AnnualReport;
import model.Condition;
import model.Game;
import model.InventoryItem;
import model.ItemType;
import model.Map;
import model.Player;
import model.Provision;
import model.Storehouse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class GameControl {

    private static Random randomGenerator = new Random();
    private static String filepath = "";

    public static Game createNewGame(String thePlayer) {
        // set our player
        Player player = new Player();
        player.setName(thePlayer);
        player.setRound(1);

        // set up our game object
        Game theGame = new Game();
        Storehouse theStorehouse = new Storehouse();
        theGame.setTheStorehouse(theStorehouse);
        theGame.setThePlayer(player);
        theGame.setCurrentPopulation(100);
        theGame.setAcresOwned(1000);
        theGame.setWheatInStorage(3000);
        theGame.setYear(1);

        //
        // AM: fill up the Annual Report for use in the Game Menu
        //
        AnnualReport report = new AnnualReport();
        // update the report
        report.setBushelsPerAcre(3);
        report.setBushelsHarvested(3000);
        report.setTithingAmount(10);
        report.setLostToRobbers(0);
        report.setPeopleStarved(0);
        report.setPeopleMovedIn(5);

        report.setEndingWheatInStorage(theGame.getWheatInStorage());
        report.setEndingPopulation(theGame.getCurrentPopulation());
        report.setEndingAcresOwned(theGame.getAcresOwned());

        // create the map (call MapControl)
        Map thisMap = new Map();
        thisMap = MapControl.createMap(thisMap);
        // set this map to this game
        theGame.setTheMap(thisMap);

//
//        // initialize Storehouse elements
        theStorehouse.setAnimals(new ArrayList<Animal>());
        theStorehouse.setTools(new ArrayList<InventoryItem>());
        theStorehouse.setProvisions(new ArrayList<Provision>());
//
//        //object{ type: ItemType.Animal, name:"Bears", quantity: 2, condition: Condition.Good, age: 30 }
//        // set up an animal (one type for now!)
        ArrayList<Animal> animals = theStorehouse.getAnimals(); // this is for the Storehouse class
        Animal cows = new Animal(); // this is for the InventoryItem class
        cows.setType(ItemType.Animal); // InventoryItem class...
        cows.setQuantity(2); // InventoryItem class...
        cows.setCondition(Condition.Good); // InventoryItem class...
//        // let's have two animals, ages as follows
        ArrayList<Integer> ages = new ArrayList<Integer>();
        ages.add(10);
        ages.add(12);
        cows.setAge(ages); // does this line even work?
        cows.setName("Cows"); // InventoryItem class, or Animal class?
        animals.add(cows); // now add it to the Storehouse!
//
//        // set up a provision
        ArrayList<Provision> provisions = theStorehouse.getProvisions(); // this is for the Storehouse class
        Provision bread = new Provision(); // this is for the Provision class
        bread.setType(ItemType.Provision); // InventoryItem class...
        bread.setQuantity(200); // InventoryItem class...
        bread.setCondition(Condition.Good); // InventoryItem class...
        bread.setName("Bread"); // Provision class...
        bread.setPerishable(true); // Provision class...
        provisions.add(bread); // now add it to the Storehouse!
//
//        // SECOND provision
        Provision corn = new Provision(); // this is for the Provision class
        corn.setType(ItemType.Provision); // InventoryItem class...
        corn.setQuantity(500); // InventoryItem class...
        corn.setCondition(Condition.Good); // InventoryItem class...
        corn.setName("Corn Ears (dried)"); // Provision class...
        corn.setPerishable(false); // Provision class...
        provisions.add(corn); // now add it to the Storehouse!
//        
//        // set up a tool (one for now!)
        ArrayList<InventoryItem> tools = theStorehouse.getTools(); // this is for the Storehouse class
        InventoryItem tool = new InventoryItem("Shovel", ItemType.Tool, 26, Condition.Good);
        tools.add(tool); // now add it to the Storehouse!

        // now save all this to the app so it's easy to get in other places!
        CityOfAaron.setCurrentGame(theGame);
        CityOfAaron.setCurrentReport(report);

        // set a year-2 land price
        LandControl.setCurrentLandPrice();

        return theGame;
    }

    public static boolean loadGameFromFile(String filename) {
        boolean worked = false;
        String filepathA = filepath + filename + ".txt";
        Object obj;
        Object obj2;
        try (FileInputStream fi = new FileInputStream(filepathA); ObjectInputStream oi = new ObjectInputStream(fi)) {
            obj = oi.readObject();
            obj2 = oi.readObject();
            Game game = (Game) obj;
            AnnualReport report = (AnnualReport) obj2;
            CityOfAaron.setCurrentGame(game);
            CityOfAaron.setCurrentReport(report);
            worked = true;
            return worked;
        } catch (Exception e) {
            return worked;
        }

    }

    public static void saveGameToFile(String filename, Game game, AnnualReport report) {
        try {
            // make the game a regular object
            Object obj = (Object) game;
            Object obj2 = (Object) report;
            String filepathB = filepath + filename + ".txt";
            FileOutputStream f = new FileOutputStream(filepathB);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(obj);
            o.writeObject(obj2);
            o.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean gameShouldEnd(Game game, int PreviousPopulation) {
        boolean ended = false;
        // AM: need logic here...

        // game should not end
        return ended;
    }

    public static double calcFinalUserRating(Game game) {
        double rating = 0;
        return rating;
    }

    /**
     * Process the current year's results and update the Game Object.
     *
     * @param game The current Game object (pass by reference)
     * @param tithesPercent The percentage of tithing selected for the year
     * @param bushelsForFood The number of bushels of wheat allocated as food for the year
     * @param acresToPlant The number of acres to be used for planting
     *
     * @return The year's Annual Report data
     */
    public static AnnualReport liveTheYear(
            Game game, int tithesPercent,
            int bushelsForFood, int acresToPlant) {
        if (game == null || tithesPercent < 0 || tithesPercent > 100
                || bushelsForFood < 0 || acresToPlant < 0) {
            return null;
        }

        AnnualReport report = new AnnualReport();

        // first, let's get the current land price (random number generated in LandControl
        report.setLandPrice(LandControl.getCurrentLandPrice());
        // next get the current total of wheat bushels in storage
        int totalWheat = game.getWheatInStorage();
        // now figure out our harvest
        int perAcre = WheatControl.calcBushelsPerAcre(tithesPercent);
        int harvested = WheatControl.calcHarvest(perAcre, acresToPlant);
        int tithingAmount = (int) (double) ((tithesPercent / 100.0) * harvested);
        int lostToRobbers = WheatControl.calcLossToRobbers(tithesPercent, totalWheat);

        // now figure out what our population should be
        int peopleStarved = PeopleControl.calculateMortality(bushelsForFood, game.getCurrentPopulation());
        int peopleMovedIn = PeopleControl.calculateNewMoveIns(game.getCurrentPopulation());

        /// Store the new number of wheat bushels in storage and new population as we end the year
        totalWheat = totalWheat + harvested - tithingAmount - lostToRobbers;
        game.setWheatInStorage(totalWheat);
        game.setCurrentPopulation(game.getCurrentPopulation() - peopleStarved + peopleMovedIn);
        // advance the year by one
        int newYear = game.getYear() + 1;
        game.setYear(newYear);

        // update the report
        report.setBushelsPerAcre(perAcre);
        report.setBushelsHarvested(harvested);
        report.setTithingAmount(tithingAmount);
        report.setLostToRobbers(lostToRobbers);
        report.setPeopleStarved(peopleStarved);
        report.setPeopleMovedIn(peopleMovedIn);

        report.setEndingWheatInStorage(game.getWheatInStorage());
        report.setEndingPopulation(game.getCurrentPopulation());
        report.setEndingAcresOwned(game.getAcresOwned());

        return report;
    }

    /**
     * Generates a random integer between lowValue and highValue, inclusive.
     * <ul>Requirements:
     * <li>lowValue and highValue must be positive int (&gt;= 0) (return -1)</li>
     * <li>highValue must be greater than lowValue (return -2) </li>
     * <li>highValue cannot be equal to the max value for int (return -3)</li>
     * </ul>
     *
     * @param lowValue
     * @param highValue
     * @return The random number
     */
    public static int getRandomNumber(int lowValue, int highValue) {
        // if low < 0 or high < 0 then return -1
        if (lowValue < 0 || highValue < 0) {
            return -1;
        }
        // if high <= low then return -2
        if (highValue <= lowValue) {
            return -2;
        }

        // if high is the max val for int, then return -3
        if (highValue == Integer.MAX_VALUE) {
            return -3;
        }

        // calc the size of the range; add one so Random() includes high val
        int range = (highValue - lowValue) + 1;

        // return low + random(range size)
        return lowValue + randomGenerator.nextInt(range);

    }

    /**
     * Protected setter for tests to inject a mock random object.
     *
     * @param random
     */
    protected static void setRandomGenerator(Random random) {
        randomGenerator = random;
    }

}
