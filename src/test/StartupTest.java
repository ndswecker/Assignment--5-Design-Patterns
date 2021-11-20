package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import main.java.*;
//import main.java.Startup.TechType;
import main.java.TechGiant;

public class Blackbox {
    
    StartupDirector director;
    StartupBuilder builder;
    String testName;
    Startup testSU;
    
    @Before
    public void setup() throws Exception{
        director = new StartupDirector();
        builder = new MPStartup();
        testName = "Test Startup";
        director.Construct(builder, testName, TechType.MARKETPLACE);
    }
    
    @After
    public void tearDown() throws Exception{
        director = null;
        builder = null;
        testName = null;
        testSU = null;
    }
    
    @Test
    public void startupNameTest() {
        Startup testSU = builder.getStartup();
        assertEquals(testSU.getName(), testName);
    }
    
    @Test
    public void startupStartingLevelTest() {
        int lvl = 1;
        Startup testSU = builder.getStartup();
        assertEquals(testSU.getLevel(), lvl);
    }
    
    @Test
    public void startupStartingApprovalTest() {
        double approve = 25.0;
        Startup testSU = builder.getStartup();
        assertEquals(testSU.getPublicApproval(), approve, 0.001);
    }
    
    @Test
    public void startupStartingNetIncomeTest() {
        double netIncome = 75.0;
        Startup testSU = builder.getStartup();
        assertEquals(testSU.getNetIncome(), netIncome, 0.001);
    }
    
    @Test
    public void startupStartRevenueTest() {
        double rev = 50.0;
        Startup testSU = builder.getStartup();
        assertEquals(testSU.getRevenue(), rev, 0.001);
    }
    
    @Test
    public void startupStartIndependent() {
        Startup testSU = builder.getStartup();
        assertNull(testSU.getOverLord());
    }
    
    @Test
    public void startupAddOverLord() {
        Startup testSU = builder.getStartup();
        //testSU.setOverLord(giant);
    }

}
