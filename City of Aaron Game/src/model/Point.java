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

public class Point implements Serializable {
    private int row;
    private int column;
    
    public Point(){
        //Empty constructor for bean
    }
    public int getRow(){
        return row;
    }
    public void setRow(int row){
        this.row = row;
    }
    public int getColumn(){
        return column;
    }
    public void setColumn(int column){
        this.column = column;
    }
   
    //toString method
    @Override
    public String toString(){ 
        return "Point" + 
        
    }
    
}
