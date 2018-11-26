/*
 * This model holds the in-between stuff that tells us what happened just in the previous round
 */
package model;
import java.io.Serializable;

public class AnnualReport implements Serializable {

    private int landPrice;
    private int acresPlanted;
    private int bushelsHarvested;
    private int bushelsPerAcre;

    private int tithingAmount;
    private int lostToRobbers;
    private int peopleStarved;
    private int peopleMovedIn;

    public AnnualReport() {
    }

    public AnnualReport(int aLandPrice, int aAcresPlanted, int aBushelsHarvested, int aBushelsPerAcre, int aTithingAmount, int aLostToRobbers, int aPeopleStarved, int aPeopleMovedIn) {
        setLandPrice(aLandPrice);
        setAcresPlanted(aAcresPlanted);
        setBushelsHarvested(aBushelsHarvested);
        setBushelsPerAcre(aBushelsPerAcre);
        setTithingAmount(aTithingAmount);
        setLostToRobbers(aLostToRobbers);
        setPeopleStarved(aPeopleStarved);
        setPeopleMovedIn(aPeopleMovedIn);
    }

    public int getLandPrice() {
        return landPrice;
    }

    public void setLandPrice(int landPrice) {
        this.landPrice = landPrice;
    }

    public int getAcresPlanted() {
        return acresPlanted;
    }

    public void setAcresPlanted(int acresPlanted) {
        this.acresPlanted = acresPlanted;
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
