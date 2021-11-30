package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import main.java.*;

public class D20Test {
    
    D20 d20;
    
    int mod1, mod2, mod3, mod4, roll;
    
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
    public void setup() throws Exception {
        d20 = new D20();
        
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
    public void tearDown() throws Exception {
        d20 = null;
        roll = 0;
        
        startupDirector = null;
        startupBuilder = null;
        startupTestName = null;
        
        techDirector = null;
        techBuilder = null;
        techTestName = null;
        
        system = null;
    }
    
    /**
     * Test basic D20 functionality
     * */
    @Test
    public void rollAnyNumber() {
        mod1 = 0;
        int roll = d20.roll(0);
        // System.out.println(roll);
        assertTrue("Error, roll is too high", roll <= (20 + mod1) );
        assertTrue("Error, roll is too low", roll > (0 + mod1) );
    }
    
    /**
     * Test that a startup can roll its own d20
     * */
    @Test
    public void startupRollD20() {
        mod1 = 0;
        testSU = startupBuilder.getStartup();
        int roll = testSU.roll(0);
        assertTrue("Error, roll is too high", roll <= (20 + mod1) );
        assertTrue("Error, roll is too low", roll > (0 + mod1) );
    }

}
