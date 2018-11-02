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
public class StartProgramViewTest {
    
    public StartProgramViewTest() {
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
     * Test of getUserInput method, of class StartProgramView.
     */
    @Test
    public void testGetUserInput_String_boolean() {
        System.out.println("getUserInput");
        String prompt = "";
        boolean allowEmpty = false;
        StartProgramView instance = new StartProgramView();
        String expResult = "";
        String result = instance.getUserInput(prompt, allowEmpty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserInput method, of class StartProgramView.
     */
    @Test
    public void testGetUserInput_String() {
        System.out.println("getUserInput");
        String prompt = "";
        StartProgramView instance = new StartProgramView();
        String expResult = "";
        String result = instance.getUserInput(prompt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInputs method, of class StartProgramView.
     */
    @Test
    public void testGetInputs() {
        System.out.println("getInputs");
        StartProgramView instance = new StartProgramView();
        String[] expResult = null;
        String[] result = instance.getInputs();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doAction method, of class StartProgramView.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        String[] inputs = null;
        StartProgramView instance = new StartProgramView();
        boolean expResult = false;
        boolean result = instance.doAction(inputs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayView method, of class StartProgramView.
     */
    @Test
    public void testDisplayView() {
        System.out.println("displayView");
        StartProgramView instance = new StartProgramView();
        instance.displayView();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
