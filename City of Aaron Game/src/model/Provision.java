/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
/**
 *
 * @author Amy
 */
public class Provision implements Serializable {
    private String name;
    private boolean perishable;
    
    public Provision (){
        //Empty constructor for JavaBeans
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
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
        return "Provision{" 
                + "name=" + name 
                + ", perishable=" + perishable
                + '}';


    }
    
}
