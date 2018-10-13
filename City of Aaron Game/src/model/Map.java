/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author teresamoser
 */
public class Map {
    private Location[][] locations;
    private Point currentLocation;
    
    public Map(){
        // Empty constructor for bean
    }
    public Location[][] getLocations() {
        return locations;
    }
    public Point getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentLocation(Point point) {
        this.currentLocation = currentLocation;
    }
    
   //toString method
    @Override
    public String toString(){ 
        
    }
}
