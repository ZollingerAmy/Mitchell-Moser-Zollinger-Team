package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class Animal extends InventoryItem implements Serializable{
    private ArrayList<Integer> age = new ArrayList<>();    

    public Animal(){
    
    }

    public ArrayList<Integer> getAge() {
        return age;
    }

    public void setAge(ArrayList<Integer> age) {
        this.age = age;
    }

   
     // toString method
    @Override
    public String toString() {
        return "\n{ Animal: " 
               + name + ", "
               + age + ", "
               + type + ", "
               + quantity + ", "
               + condition + " }";
    }
}
