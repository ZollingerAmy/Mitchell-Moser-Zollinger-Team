package model;
import java.io.Serializable;
/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class Provision extends InventoryItem implements Serializable {
    private boolean perishable;
    
    public Provision (){
        //Empty constructor for JavaBeans
    }
    
    public boolean isPerishable(){
        return perishable;
    }
    
    public void setPerishable(boolean perishable){
        this.perishable = perishable;
    }
    
    // toSting method
    @Override
    public String toString() {
        return "\n{ Provision: " 
               + name + ", "
               + perishable + ", "
               + type + ", "
               + quantity + ", "
               + condition + " }";
    }
    
}
