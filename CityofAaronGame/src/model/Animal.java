package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class Animal extends InventoryItem implements Serializable {

    private ArrayList<Integer> ages = new ArrayList<>();

    public Animal() {
        // Empty constructor for bean
    }
    

    public Animal(String aName, ItemType aType, int aQuantity, Condition aCondition, ArrayList<Integer> aAges) {
        setName(aName);
        setType(aType);
        setQuantity(aQuantity);
        setCondition(aCondition);
        setAge(aAges);
    }

    public ArrayList<Integer> getAge() {
        return ages;
    }

    public void setAge(ArrayList<Integer> ages) {
        this.ages = ages;
    }

    // toString method
    @Override
    public String toString() {
        return "\n{ Animal: "
                + name + ", "
                + ages + ", "
                + type + ", "
                + quantity + ", "
                + condition + " }";
    }
     //bubble sort for Animals Array List

        public String animals;

        public Animal(String animals) {
            this.animals = animals;
        }

        public String getName() {
            return animals;
        }

        public void main(String[] args) {
            //create the unsorted array
            Animal[] animals = new Animal[5];
            ArrayList<Integer> ages = null;
            animals[0] = new Animal("Dairy Cows", ItemType.Animal, 20, Condition.Good, ages);
            animals[1] = new Animal("Oxen", ItemType.Animal, 20, Condition.Good, ages);
            animals[2] = new Animal("Horse", ItemType.Animal, 20, Condition.Good, ages);
            animals[3] = new Animal("Pig", ItemType.Animal, 20, Condition.Good, ages);
            animals[4] = new Animal("Chicken", ItemType.Animal, 20, Condition.Good, ages);

            //two for-loops, one inside the other
            for (int i = 0; i < animals.length - 1; i++) {
                for (int j = i + 1; j < animals.length; j++) {
                    //if animal[i] > animal[j] then, swap them...
                    if (animals[i].getName().compareTo(animals[j].getName()) > 0) {
                        Animal temp = animals[i];
                        animals[i] = animals[j];
                        animals[j] = temp;
                    }
                }
            }
        }
    }

