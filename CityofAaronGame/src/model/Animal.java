package model;

import java.io.Serializable;
import java.util.ArrayList;
import app.CityOfAaron;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class Animal extends InventoryItem implements Serializable {

    private ArrayList<Integer> ages = new ArrayList<>();

    public Animal() {
        // Empty constructor for bean
    }

    public Animal(String aName, int aQuantity, Condition aCondition, ArrayList<Integer> aAges) {
        setName(aName);
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
                + quantity + ", "
                + condition + " }";
    }

}
