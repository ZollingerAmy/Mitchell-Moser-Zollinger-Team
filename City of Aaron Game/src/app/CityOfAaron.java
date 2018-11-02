/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */
package app;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
import java.util.*;
import model.Game;
import model.Map;
import model.Player;
import model.Storehouse;
import model.Animal;
import model.Author;
import model.Provision;
import model.InventoryItem;
import model.ItemType;
import model.Condition;
import View.StartProgramView;
import View.NewGameView;
import View.MainMenuView;
import View.HelpMenuView;

public class CityOfAaron {

    /**
     * The starting point for our application.
     *
     * @param args Any parameters passed on the command line will be contained in this array.
     */
 public static Game currentGame = null;
 
 public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        currentGame = currentGame;
    }
    
    public static void main(String[] args) {
        
        

        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayView();
        
    
       
        
        //Delete code as per team instructions
//        Game theGame = new Game();
//        theGame.setThePlayer(new Player());
//        theGame.setTheMap(new Map());
//        theGame.setTheStorehouse(new Storehouse());
//        theGame.setCurrentPopulation(105);
//        theGame.setAcresOwned(2000);
//        theGame.setWheatInStorage(3000);
//      
//        //end of game stuff
//
//        //Amy Test
//        //Storehouse theStorehouse = new Storehouse();
////        ArrayList<String> animals = new ArrayList<String>();
////        animals.add("Cow");
//        //theStorehouse.setAnimals(animals);
//        //Provisions
//        // AMBER TESTS
//        // set up theStorehouse, pull it from theGame
//        Storehouse theStorehouse = theGame.getTheStorehouse();
//
//        // initialize Storehouse elements
//        theStorehouse.setAnimals(new ArrayList<Animal>());
//        theStorehouse.setTools(new ArrayList<InventoryItem>());
//        theStorehouse.setProvisions(new ArrayList<Provision>());
//
//        //object{ type: ItemType.Animal, name:"Bears", quantity: 2, condition: Condition.Good, age: 30 }
//        // set up an animal (one type for now!)
//        ArrayList<Animal> animals = theStorehouse.getAnimals(); // this is for the Storehouse class
//        Animal cows = new Animal(); // this is for the InventoryItem class
//        cows.setType(ItemType.Animal); // InventoryItem class...
//        cows.setQuantity(2); // InventoryItem class...
//        cows.setCondition(Condition.Good); // InventoryItem class...
//        // let's have two animals, ages as follows
//        ArrayList<Integer> ages = new ArrayList<Integer>();
//        ages.add(10);
//        ages.add(12);
//        cows.setAge(ages); // does this line even work?
//        cows.setName("Cows"); // InventoryItem class, or Animal class?
//        animals.add(cows); // now add it to the Storehouse!
//
//        // set up a provision (one for now!)
//        ArrayList<Provision> provisions = theStorehouse.getProvisions(); // this is for the Storehouse class
//        Provision bread = new Provision(); // this is for the Provision class
//        bread.setType(ItemType.Provision); // InventoryItem class...
//        bread.setQuantity(200); // InventoryItem class...
//        bread.setCondition(Condition.Good); // InventoryItem class...
//        bread.setName("Bread"); // Provision class...
//        bread.setPerishable(true); // Provision class...
//        provisions.add(bread); // now add it to the Storehouse!
//
//        // SECOND provision
//        // set up a provision (one for now!)
//        Provision corn = new Provision(); // this is for the Provision class
//        corn.setType(ItemType.Provision); // InventoryItem class...
//        corn.setQuantity(500); // InventoryItem class...
//        corn.setCondition(Condition.Good); // InventoryItem class...
//        corn.setName("Corn Ears (dried)"); // Provision class...
//        corn.setPerishable(false); // Provision class...
//        provisions.add(corn); // now add it to the Storehouse!
//        
//        // set up a tool (one for now!)
//        ArrayList<InventoryItem> tools = theStorehouse.getTools(); // this is for the Storehouse class
//        InventoryItem tool = new InventoryItem(); // this is for the InventoryItem class
//        tool.setName("Shovel"); // InventoryItem class...
//        tool.setType(ItemType.Tool); // InventoryItem class...
//        tool.setQuantity(26); // InventoryItem class...
//        tool.setCondition(Condition.Good); // InventoryItem class...
//        tools.add(tool); // now add it to the Storehouse!
//
//        // PRINT EVERYTHING!
//        System.out.println(theGame.toString());
//        System.out.println(theStorehouse.toString());
//        // END AMBER TESTS

    }
    
}

////////////////////////////////////////
// NOTES //////////////////////////////
///////////////////////////////////////
//(for array classes -- in their class defs)
//import java.util.Arrays; 
// @Override
//    public String toString() {
//          return "ClassName { "
//          + ", variable = " + Arrays.toString(variable)  
//          + " }";
//          }
//
//Then when you go to you main you can call it like this:
//
//ClassName theVariable = new ClassName();
//
//theVariable.setVarriable(new String[] {
//"Tip 1", "Tip 2", "Tip 3"
//});
