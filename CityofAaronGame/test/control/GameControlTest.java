/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Game;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author metauser
 */
public class GameControlTest {
    
    public GameControlTest() {
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
     * Test of createNewGame method, of class GameControl.
     */
//    @Test
//    public void testCreateNewGame() {
//        System.out.println("createNewGame");
//        String playerName = "";
//        Game expResult = null;
//        Game result = GameControl.createNewGame(playerName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Tests of getRandomNumber method, of class GameControl.
     */
    @Test
    public void InputsNoNegativeTest() {
        int random = GameControl.getRandomNumber(-1, 10);
        assertEquals(-1, random);
        
        random = GameControl.getRandomNumber(10, -1);
        assertEquals(-1, random);
    }
    
    @Test
    public void InputOrderTest() {
        int random = GameControl.getRandomNumber(100, 10);
        assertEquals(-2, random);
        
        random = GameControl.getRandomNumber(5, 5);
        assertEquals(-2, random);
    }
    
    @Test
    public void MaxIntegerTest() {
        int random = GameControl.getRandomNumber(0, Integer.MAX_VALUE);
        assertEquals(-3, random);
    }
    
    @Test
    public void ValidRangeTest() {
        int[][] testRanges = new int[][]{
            {1, 3},
            {15, 100},
            {5, 6},
            {0, Integer.MAX_VALUE-1}
        };
        
        for (int i=0; i < testRanges.length; i++){
            int low = testRanges[i][0];
            int high = testRanges[i][1];
            
            int random = GameControl.getRandomNumber(low, high);
            System.out.printf("%d <= %d <= %d\n", low, random, high);
            
            assertTrue(
                    String.format("%d should be between %d and %d", random, low, high),
                    random >= low && random <= high);
        }
    }
}
