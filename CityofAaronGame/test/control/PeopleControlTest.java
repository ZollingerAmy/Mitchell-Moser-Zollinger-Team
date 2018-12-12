package control;

import exceptions.PeopleControlException;
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
public class PeopleControlTest {
    
    public PeopleControlTest() {
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
    // I actually am understanding this now!!! That is so exciting.
    // I changed L05 test matrix as per feedback received on graded assignment
    
    @Test
    public void CurrentPopulation() throws PeopleControlException{
        int result = PeopleControl.calculateMortality(1500, 100);
            assertEquals(25, result); // 25 died because not enough food was set aside
    }
    
    @Test
    public void BushelsSetAside() throws PeopleControlException{
        int result = PeopleControl.calculateMortality(100, 1500);
            assertEquals(1495, result); // 1495 died because not enough food was set aside
    }
    
    @Test
    public void CurrentPopulation2() throws PeopleControlException{
        int result = PeopleControl.calculateMortality(183, -1);
            assertEquals(-1, result); // Population less than 0 returns -1
    }
    
    @Test
    public void BushelsSetAside2() throws PeopleControlException{
        int result = PeopleControl.calculateMortality(-1, 183);
            assertEquals(-1, result); // Bushels less than 0 returns -1
    }
    
    @Test
    public void CurrentPopulation3() throws PeopleControlException{
        int result = PeopleControl.calculateMortality(1340, -1);
            assertEquals(-1, result); // Population less than 0 returns -1
    }
    
    @Test
    public void BushelsSetAside3() throws PeopleControlException{
            int result = PeopleControl.calculateMortality(-1, 1340);
            assertEquals(-1, result); // Bushels less than 0 returns -1
    }
    
    @Test
    public void CurrentPopulation4() throws PeopleControlException{
        int result = PeopleControl.calculateMortality(20, 1);
            assertEquals(0, result); // plenty of food no one died
    }
    
    @Test
    public void CurrentPopulation5() throws PeopleControlException{
        int result = PeopleControl.calculateMortality(5000, 250);
            assertEquals(0, result); // plenty of food no one died
    }
    /**
     * Test of calculateMortality method, of class PeopleControl.
     */
    @Test
    public void testCalculateMortality() throws PeopleControlException {
        System.out.println("calculateMortality");
        int bushelsSetAside = 0;
        int currentPopulation = 0;
        int expResult = 0;
        int result = PeopleControl.calculateMortality(bushelsSetAside, currentPopulation);
        assertEquals(expResult, result);

    }
    
}
