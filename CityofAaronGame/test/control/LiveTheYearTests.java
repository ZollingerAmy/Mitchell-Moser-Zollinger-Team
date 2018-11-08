package control;

import org.junit.Test;
import org.junit.Before;

import model.AnnualReport;
import model.Game;

import static org.junit.Assert.*;

public class LiveTheYearTests {


    private Game game;

    @Before
    public void initializeTest(){

        GameControl.setRandomGenerator(new java.util.Random());
        // AM: below line is VERY INTERESTING...
//        game = Game.builder()
//        .acresOwned(1000)
//        .currentPopulation(500)
//        .wheatInStorage(20000)
//        .build();
        game = new Game();
        game.setAcresOwned(1000);
        game.setCurrentPopulation(500);
        game.setWheatInStorage(20000);
    }



    @Test
    public void nullGameTest(){
        AnnualReport report = GameControl.liveTheYear(null, 0, 0, 0);
        assertNull(report);
    }

    @Test
    public void lowTithingTest(){
        AnnualReport report = GameControl.liveTheYear(game, -1, 0, 0);
        assertNull(report);
    }
    
    @Test
    public void highTithingTest(){
        AnnualReport report = GameControl.liveTheYear(game, 101, 0, 0);
        assertNull(report);
    }

    @Test
    public void lowBushelsTest(){
        AnnualReport report = GameControl.liveTheYear(game, 10, -1, 0);
        assertNull(report);
    }

    @Test
    public void lowAcresTest(){
        AnnualReport report = GameControl.liveTheYear(game, 10, 0, -1);
        assertNull(report);
    }

    @Test
    public void liveTheYearTest() {
        final int TITHING = 10;
        final int ACRES_PLANTED = 1000;

        int startingWheat = game.getWheatInStorage();
        int startingPopulation = game.getCurrentPopulation();

        AnnualReport report = GameControl.liveTheYear(game, 10, 10000, 1000);

        assertNotNull(report);

        // 10% tithing = 2 to 4 bushels per acre
        int lowHarvest = ACRES_PLANTED * 2; 
        int highHarvest = ACRES_PLANTED * 4; 
        assertTrue(
            report.getBushelsHarvested() >= lowHarvest
            && report.getBushelsHarvested() <= highHarvest);

        // 10% tithing on low/high Harvest
        assertTrue(
            report.getTithingAmount() >= (double)lowHarvest * (TITHING/100.0)
            && report.getTithingAmount() <= (double)highHarvest * (TITHING/100.0) );

        // 10% tithing = 0 or 3% to 7% of wheatInStorage
        int lowRobbersLoss = (int)(game.getWheatInStorage() * 0.03);
        int highRobbersLoss = (int)(game.getWheatInStorage() * 0.07);
        assertTrue(
            report.getLostToRobbers() == 0
            || (report.getLostToRobbers() >= lowRobbersLoss
                && report.getLostToRobbers() <= highRobbersLoss) );

        // People starved should be 0 in this case because 10000 bushels
        // are allocated for 500 people to eat. At 20/person, that's 10000.
        assertEquals(0, report.getPeopleStarved());

        // People moved in should be 1% to 5% of starting population
        int lowPeople = (int)(startingPopulation * 0.01);
        int highPeople = (int)(startingPopulation * 0.05);
        assertTrue(
            report.getPeopleMovedIn() >= lowPeople
            && report.getPeopleMovedIn() <= highPeople );

        int endingWheat = 
            startingWheat
            + report.getBushelsHarvested()
            - report.getTithingAmount()
            - report.getLostToRobbers();
        assertEquals(endingWheat, report.getEndingWheatInStorage());

        int endingPopulation = 
            startingPopulation
            - report.getPeopleStarved()
            + report.getPeopleMovedIn();
        assertEquals(endingPopulation, report.getEndingPopulation());

        // Acres Owned should be untouched
        assertEquals(game.getAcresOwned(), report.getEndingAcresOwned());
    }

}