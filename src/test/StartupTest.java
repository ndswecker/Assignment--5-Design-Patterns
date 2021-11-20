package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import main.java.*;
//import main.java.TechGiant;

public class StartupTest {
    
    StartupDirector startupDirector;
    StartupBuilder startupBuilder;
    String startupTestName;
    Startup testSU;
    
    TechGiantDirector techDirector;
    TechGiantBuilder techBuilder;
    String techTestName;
    TechGiant testTG;
    
    @Before
    public void setup() throws Exception{
        startupDirector = new StartupDirector();
        startupBuilder = new MPStartup();
        startupTestName = "Test Startup";
        startupDirector.Construct(startupBuilder, startupTestName, TechType.MARKETPLACE);
        
        techDirector = new TechGiantDirector();
        techBuilder = new NATechGiant();
        techTestName = "Test Tech Giant of NA";
        techDirector.Construct(techBuilder, techTestName, TechType.SERVICE);
    }
    
    @After
    public void tearDown() throws Exception{
        startupDirector = null;
        startupBuilder = null;
        startupTestName = null;
        testSU = null;
        
        techDirector = null;
        techBuilder = null;
        techTestName = null;
        testTG = null;
    }
    
    @Test
    public void startupNameTest() {
        Startup testSU = startupBuilder.getStartup();
        assertEquals(testSU.getName(), startupTestName);
    }
    
    @Test
    public void startupStartingLevelTest() {
        int lvl = 1;
        Startup testSU = startupBuilder.getStartup();
        assertEquals(testSU.getLevel(), lvl);
    }
    
    @Test
    public void startupStartingApprovalTest() {
        double approve = 25.0;
        Startup testSU = startupBuilder.getStartup();
        assertEquals(testSU.getPublicApproval(), approve, 0.001);
    }
    
    @Test
    public void startupStartingNetIncomeTest() {
        double netIncome = 75.0;
        Startup testSU = startupBuilder.getStartup();
        assertEquals(testSU.getNetIncome(), netIncome, 0.001);
    }
    
    @Test
    public void startupStartRevenueTest() {
        double rev = 50.0;
        Startup testSU = startupBuilder.getStartup();
        assertEquals(testSU.getRevenue(), rev, 0.001);
    }
    
    /**
     * Test new startups are by default wild.
     *  */
    @Test
    public void startupStartIndependent() {
        Startup testSU = startupBuilder.getStartup();
        assertNull(testSU.getOverLord());
    }
    
    /**
     * Test making a wild startup to a captive startup
     * */
    @Test
    public void startupAddOverLord() {
        Startup testSU = startupBuilder.getStartup();
        TechGiant testTG = techBuilder.getTechGiant();
        testSU.setOverLord(testTG);
        assertEquals(testTG, testSU.getOverLord());
    }

}