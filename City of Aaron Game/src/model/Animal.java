package model;

import java.io.Serializable;
/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class Animal extends InventoryItem implements Serializable{
    private String name;
    private int age;
    
        public Animal(){
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
