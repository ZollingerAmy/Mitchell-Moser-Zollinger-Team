package model;

import java.io.Serializable;
/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class Map implements Serializable {
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
    public void setCurrentLocation(Point currentLocation){
      this.currentLocation = currentLocation;
 
    }
  
       
   // toString method
    @Override
    public String toString(){
        return "Map " + "Location:  " + currentLocation;    
    }
}
