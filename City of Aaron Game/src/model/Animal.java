package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class Animal extends InventoryItem implements Serializable{
    private String name;
    private ArrayList<Integer> age = new ArrayList<>();    

    public Animal(){
    
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
        return "Animal{" 
                + "name=" + name 
                + ", age=" + age
                + '}';
    }
}
