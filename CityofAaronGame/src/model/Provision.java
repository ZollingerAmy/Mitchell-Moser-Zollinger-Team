package model;

import app.CityOfAaron;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class Provision extends InventoryItem implements Serializable {

    private boolean perishable;

    public Provision() {
        //Empty constructor for JavaBeans
    }

    public Provision(String aName, ItemType aType, int aQuantity, Condition aCondition, boolean aPerishable) {
        setName(aName);
        setType(aType);
        setQuantity(aQuantity);
        setCondition(aCondition);
        setPerishable(aPerishable);
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    // toSting method
    @Override
    public String toString() {
        return "\nProvision: "
                + name + ", "
                + type + ", "
                + quantity + ", "
                + condition + ", "
                + perishable;
    }

}
