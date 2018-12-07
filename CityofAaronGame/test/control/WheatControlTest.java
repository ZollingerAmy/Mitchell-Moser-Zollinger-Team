package control;

import exceptions.GameControlException;
import exceptions.WheatControlException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amber Mitchell, Teresa Moser, Amy Zollinger
 */
public class WheatControlTest {

    public WheatControlTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calcLossToRobbers method, of class WheatControl.
     */
    @Test
    public void InputsNoNegativeWheatTest() throws WheatControlException, GameControlException {
        // test that wheat is not negative
        int wheat = WheatControl.calcLossToRobbers(10, -1);
        assertEquals(-1, wheat);
    }

    @Test
    public void InputValidTithesTest() throws WheatControlException, GameControlException {
        // test that tithes are not negative and not over 100
        int tithes = WheatControl.calcLossToRobbers(-1, 10);
        assertEquals(-2, tithes);

        tithes = WheatControl.calcLossToRobbers(101, 10);
        assertEquals(-2, tithes);
    }

    @Test
    public void ValidTest() throws WheatControlException, GameControlException {
        int[][] testRanges = new int[][]{
            {5, 3000},
            {10, 3000},
            {15, 3000}
        };

        for (int i = 0; i < testRanges.length; i++) {
            int tithes = testRanges[i][0];
            int wheat = testRanges[i][1];

            int loss = WheatControl.calcLossToRobbers(tithes, wheat);
            System.out.printf("Tithes: %d , Wheat: %d = Loss: %d\n", tithes, wheat, loss);

            assertTrue(
                    String.format("%d is lost from %d wheat", loss, wheat),
                    loss <= wheat);
        }
    }

    /**
     * Teresa Moser Test of calcHarvest method, of class WheatControl.
     */
    @Test
    public void testCalcHarvest() throws WheatControlException {
        int acresPlanted = 0;
        int tithesPercent = 0;
        int expResult = 0;
        int result = WheatControl.calcHarvest(acresPlanted, tithesPercent);
        assertEquals(expResult, result);

    }

    @Test
    public void InputsNoNegativeAcresPlantedTest() throws WheatControlException {
        // test that Acres Planted  is not negative
        int wheat = WheatControl.calcHarvest(-1, 10);
        assertEquals(-1, wheat);
    }

    @Test
    public void InputTrueTithesTest() throws WheatControlException {
        // test that tithes are not negative and not over 100
        int tithesPercent = WheatControl.calcHarvest(10, -1);
        assertEquals(-2, tithesPercent);

        tithesPercent = WheatControl.calcHarvest(10, 101);
        assertEquals(-2, tithesPercent);
    }

    @Test
    public void TrueTest() throws WheatControlException {
        int[][] testRanges = new int[][]{
            {8, 3000},
            {10, 3000},
            {12, 3000}
        };

        for (int i = 0; i < testRanges.length; i++) {
            int tithes = testRanges[i][0];
            int wheat = testRanges[i][1];
            int yield = WheatControl.calcHarvest(tithes, wheat);

            if (tithes < 8 && wheat <= 3000);

            assertTrue(
                    String.format("%d is gained from %d wheat", yield, wheat),
                    yield >= 30 && yield <= 90);

            if ((tithes >= 8 && tithes <= 12) && wheat <= 3000);

            assertTrue(
                    String.format("%d is gained from %d wheat", yield, wheat),
                    yield >= 60 && yield <= 120);

            if (tithes > 12 && wheat <= 3000);

            assertTrue(
                    String.format("%d is gained from %d wheat", yield, wheat),
                    yield >= 60 && yield <= 150);

            System.out.printf("Tithes: %d , Wheat: %d = Yield: %d\n", tithes, wheat, yield);

        }

    }

}
