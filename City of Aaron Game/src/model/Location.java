/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
/**
 *
 * @author teresamoser
 */

public class Location implements Serializable {
    private String name;
    private String description;
    private String mapSymbol;
    private String[] gameTips;
    
    public Location(){
        //Empty constructor for bean
    }
    public String getName(){
        return name();
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public String 
    
    
}
