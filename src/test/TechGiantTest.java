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
     * 
     * */

}
