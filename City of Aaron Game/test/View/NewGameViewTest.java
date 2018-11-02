/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amy
 */
public class NewGameViewTest {
    
    public NewGameViewTest() {
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
     * Test of getUserInput method, of class NewGameView.
     */
    @Test
    public void testGetUserInput_String_boolean() {
        System.out.println("getUserInput");
        String prompt = "";
        boolean allowEmpty = false;
        NewGameView instance = new NewGameView();
        String expResult = "";
        String result = instance.getUserInput(prompt, allowEmpty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserInput method, of class NewGameView.
     */
    @Test
    public void testGetUserInput_String() {
        System.out.println("getUserInput");
        String prompt = "";
        NewGameView instance = new NewGameView();
        String expResult = "";
        String result = instance.getUserInput(prompt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInputs method, of class NewGameView.
     */
    @Test
    public void testGetInputs() {
        System.out.println("getInputs");
        NewGameView instance = new NewGameView();
        String[] expResult = null;
        String[] result = instance.getInputs();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doAction method, of class NewGameView.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        String[] inputs = null;
        NewGameView instance = new NewGameView();
        boolean expResult = false;
        boolean result = instance.doAction(inputs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayView method, of class NewGameView.
     */
    @Test
    public void testDisplayView() {
        System.out.println("displayView");
        NewGameView instance = new NewGameView();
        instance.displayView();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
