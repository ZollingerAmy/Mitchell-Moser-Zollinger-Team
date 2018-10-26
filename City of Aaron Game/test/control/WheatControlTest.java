package control;

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
    public void InputsNoNegativeWheatTest() {
        // test that wheat is not negative
        int wheat = WheatControl.calcLossToRobbers(10, -1);
        assertEquals(-1, wheat);
    }
    
    @Test
    public void InputValidTithesTest() {
        // test that tithes are not negative and not over 100
        int tithes = WheatControl.calcLossToRobbers(-1, 10);
        assertEquals(-2, tithes);
        
        tithes = WheatControl.calcLossToRobbers(101, 10);
        assertEquals(-2, tithes);
    }

    @Test
    public void ValidTest() {
        int[][] testRanges = new int[][]{
            {5, 3000},
            {10, 3000},
            {15, 3000}
        };
        
        for (int i=0; i < testRanges.length; i++){
            int tithes = testRanges[i][0];
            int wheat = testRanges[i][1];
            
            int loss = WheatControl.calcLossToRobbers(tithes, wheat);
            System.out.printf("Tithes: %d , Wheat: %d = Loss: %d\n", tithes, wheat, loss);
            
            assertTrue(
                    String.format("%d is lost from %d wheat", loss, wheat),
                    loss <= wheat);
        }
    }
}
