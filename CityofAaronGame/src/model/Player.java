/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
/**
 *
 * @author metauser
 */
public class Player implements Serializable {
    private String name;
    private int round;
    
    public Player(){
        // Empty constructor for bean
    }
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getRound(){
        return round;
    }
    
    public void setRound(int round){
        this.round = round;
    }
    // toString method
    @Override
    public String toString() {
        return "Player{" 
                + "name=" + name 
                + ", round=" + round
                + '}';
    }
    
}
