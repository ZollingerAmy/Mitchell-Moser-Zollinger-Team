/*
 * Main class. This is the first code that will be executed when 
 * the program starts.
 */

package app;
import java.util.*;
/**
 *
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
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

public class CityOfAaron {

    /**
     * The starting point for our application. 
     * 
     * @param args Any parameters passed on the command line will be 
     * contained in this array.
     */
    public static void main(String[] args) {

        Game theGame = new Game();
        theGame.setThePlayer(new Player());
        theGame.setTheMap(new Map());
        //theGame.setTheStorehouse(new Storehouse());
        theGame.setCurrentPopulation(105);
        theGame.setAcresOwned(2000);
        theGame.setWheatInStorage(3000);
        
       System.out.println(theGame.toString());
       //end of game test
       
        //Amy Test
        Storehouse theStorehouse = new Storehouse();
        
        ArrayList<String> animals = new ArrayList<String>();
        animals.add("Cow");
        theStorehouse.setAnimals(animals);
      
        Provision theProvision = new Provision();
        
        ArrayList<String> provisions = new ArrayList<String>();
        provisions.add("Hay");
        theStorehouse.setProvisions(provisions);
         
       System.out.println(theStorehouse.toString());
        
        


        // AMBER TESTS
        System.out.println(Author.Amber.toString());
        InventoryItem theItem = new InventoryItem();
        theItem.setName("Shovel");
        theItem.setType(ItemType.Tool);
        theItem.setQuantity(46);
        theItem.setCondition(Condition.Good);
        System.out.println(theItem.toString());
        // END AMBER TESTS
        
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
