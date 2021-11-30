package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import main.java.*;

public class TechGiantTest {
    
    StartupDirector startupDirector;
    StartupBuilder startupBuilder;
    String startupTestName;
    Startup testSU;
    
    TechGiantDirector techDirector;
    TechGiantBuilder techBuilder;
    String techTestName;
    TechGiant testTG;
    
    MarketSystem system;
    
    @Before
    public void setup() throws Exception{
        
        system = new MarketSystem();
        
        startupDirector = new StartupDirector();
        startupBuilder = new StartupMP();
        startupTestName = "Test Startup";
        startupDirector.Construct(startupBuilder, startupTestName, TechType.MARKETPLACE, system);
        
        techDirector = new TechGiantDirector();
        techBuilder = new TechGiantNA();
        techTestName = "Test Tech Giant of NA";
        techDirector.Construct(techBuilder, techTestName, TechType.SERVICE, system);
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
        
        system = null;
    }
    
    /**
     * Test TechGiant name
     * */
    @Test
    public void techNameTest() {
        TechGiant testTG = techBuilder.getTechGiant();
        assertEquals(testTG.getName(), techTestName);
    }
    
    /**
     * Test TechGiant starting public approval rating
     * */
    @Test
    public void startingApprovalTest() {
        double approve = Consts.TG_LOW / 10; 
        TechGiant testTG = techBuilder.getTechGiant();
        assertEquals(testTG.getPublicApproval(), approve, 0.001);
    }
    
    /**
     * Test TechGiant starting netIncome
     * */
    @Test
    public void startingNetIncome() {
        double income = Consts.TG_HIGH;
        testTG = techBuilder.getTechGiant();
        assertEquals(testTG.getNetIncome(), income, 0.001);
    }
    
    /**
     * Test TechGiant starting Revenue
     * */
    @Test
    public void startingRevenue() {
        double rev = Consts.TG_HIGH;
        testTG = techBuilder.getTechGiant();
        assertEquals(testTG.getRevenue(), rev, 0.001);
    }
    
    /**
     * Test acquisition of a startup
     * */
    @Test
    public void addAStartup() {
        testSU = startupBuilder.getStartup();
        testTG = techBuilder.getTechGiant();
        testTG.consumeStartup(testSU);
        assertEquals(testTG.getNumOfStartups(), 2);
    }
    
    /**
     * Test loss of a startup
     * */
    @Test
    public void looseAStartup() {
        testSU = startupBuilder.getStartup();
        testTG = techBuilder.getTechGiant();
        testTG.consumeStartup(testSU);
        //testTG.releaseStartup(testSU);
        assertEquals(testTG.getNumOfStartups(), 1);
        assertNull(testSU.getOverLord());
    }

}
