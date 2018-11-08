/*
 * Awesome game model here
 */
package model;

import java.io.Serializable;

/**
 * @authors Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class Game implements Serializable {

    private Player thePlayer;
    private Map theMap;
    private Storehouse theStorehouse;
    private int currentPopulation;
    private int acresOwned;
    private int wheatInStorage;
    private int yearPlaying;

    public static class builder {

        private int acresOwned;
        private int currentPopulation;
        private int wheatInStorage;

        public builder acresOwned(int acresOwned) {
            this.acresOwned = acresOwned;
            return this;
        }

        public builder currentPopulation(int currentPopulation) {
            this.currentPopulation = currentPopulation;
            return this;
        }

        public builder wheatInStorage(int wheatInStorage) {
            this.wheatInStorage = wheatInStorage;
            return this;
        }

        public Game build() {
            Game game = new Game();
            game.acresOwned = this.acresOwned;
            game.currentPopulation = this.currentPopulation;
            game.wheatInStorage = this.wheatInStorage;

            return game;
        }

    }

    public Game() {
        // Empty constructor for bean
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public Map getTheMap() {
        return theMap;
    }

    public void setTheMap(Map theMap) {
        this.theMap = theMap;
    }

    public Storehouse getTheStorehouse() {
        return theStorehouse;
    }

    public void setTheStorehouse(Storehouse theStorehouse) {
        this.theStorehouse = theStorehouse;
    }

    public int getCurrentPopulation() {
        return currentPopulation;
    }

    public void setCurrentPopulation(int currentPopulation) {
        this.currentPopulation = currentPopulation;
    }

    public int getAcresOwned() {
        return acresOwned;
    }

    public void setAcresOwned(int acresOwned) {
        this.acresOwned = acresOwned;
    }

    public int getWheatInStorage() {
        return wheatInStorage;
    }

    public void setWheatInStorage(int wheatInStorage) {
        this.wheatInStorage = wheatInStorage;
    }

    public int getYear() {
        return yearPlaying;
    }

    public void setYear(int yearPlaying) {
        this.yearPlaying = yearPlaying;
    }

    // toString method
    @Override
    public String toString() {
        return "Game{\n"
                + "The Player: " + thePlayer
                + "\nThe Map: " + theMap
                + "\nThe Storehouse: " + theStorehouse
                + "\nCurrent Population: " + currentPopulation
                + "\nAcres Owned: " + acresOwned
                + "\nWheat in Storage: " + wheatInStorage
                + "\n}";
    }

}

/// AM: note using Lombok for building models:
// import lombok.*
//
//@Data
//@Builder
//public class Game {
//    private Player thePlayer;
//    private Storehouse theStorehouse;
//    private Map theMap;
//    
//    private int currentPopulation;
//    private int acresOwned;
//    private int wheatInStorage;
//}