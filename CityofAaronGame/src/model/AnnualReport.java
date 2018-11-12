/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

public class AnnualReport implements Serializable {

    private static final long serialVersionUID = 1L;

    private int endingWheatInStorage;
    private int endingPopulation;
    private int endingAcresOwned;

    private int landPrice;
    private int bushelsHarvested;
    private int bushelsPerAcre;

    private int tithingAmount;
    private int lostToRobbers;
    private int peopleStarved;
    private int peopleMovedIn;

    public AnnualReport() {
    }

    public int getEndingWheatInStorage() {
        return endingWheatInStorage;
    }

    public void setEndingWheatInStorage(int endingWheatInStorage) {
        this.endingWheatInStorage = endingWheatInStorage;
    }

    public int getEndingPopulation() {
        return endingPopulation;
    }

    public void setEndingPopulation(int endingPopulation) {
        this.endingPopulation = endingPopulation;
    }

    public int getEndingAcresOwned() {
        return endingAcresOwned;
    }

    public void setEndingAcresOwned(int endingAcresOwned) {
        this.endingAcresOwned = endingAcresOwned;
    }

    public int getLandPrice() {
        return landPrice;
    }

    public void setLandPrice(int landPrice) {
        this.landPrice = landPrice;
    }

    public int getBushelsHarvested() {
        return bushelsHarvested;
    }

    public void setBushelsHarvested(int bushelsHarvested) {
        this.bushelsHarvested = bushelsHarvested;
    }

    public int getBushelsPerAcre() {
        return bushelsPerAcre;
    }

    public void setBushelsPerAcre(int bushelsPerAcre) {
        this.bushelsPerAcre = bushelsPerAcre;
    }

    public int getTithingAmount() {
        return tithingAmount;
    }

    public void setTithingAmount(int tithingAmount) {
        this.tithingAmount = tithingAmount;
    }

    public int getLostToRobbers() {
        return lostToRobbers;
    }

    public void setLostToRobbers(int lostToRobbers) {
        this.lostToRobbers = lostToRobbers;
    }

    public int getPeopleStarved() {
        return peopleStarved;
    }

    public void setPeopleStarved(int peopleStarved) {
        this.peopleStarved = peopleStarved;
    }

    public int getPeopleMovedIn() {
        return peopleMovedIn;
    }

    public void setPeopleMovedIn(int peopleMovedIn) {
        this.peopleMovedIn = peopleMovedIn;
    }

}
