package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import main.java.Startup;
//import main.java.Startup.TechType;
import main.java.TechGiant;

public class Blackbox {
    
    Startup testStartup;
    TechGiant testTechGiant;
    
    @Before
    public void setup() throws Exception{
        testStartup = null;
        
    }
    
    @After
    public void tearDown() throws Exception{
        testStartup = null;
    }
    
    @Test
    public void startupInit() {
        //testStartup = new Startup(TechType.HARDWARE);
        //assertEquals(testStartup.techType, TechType.HARDWARE);
    }

}
