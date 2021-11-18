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
    
    @Before
    public void setup() throws Exception{
        director = new StartupDirector();
        builder = new MPStartup();
        testName = null;
    }
    
    @After
    public void tearDown() throws Exception{
        director = null;
        builder = null;
        testName = null;
    }
    
    @Test
    public void startupNameTest() {
        testName = "Test Startup";
        director.Construct(builder, testName, TechType.MARKETPLACE);
        Startup testSU = builder.getStartup();
        assertEquals(testSU.getName(), testName);
    }
    
    @Test
    public void startupStartingLevelTest() {
        testName = "Test Startup";
        int lvl = 1;
        director.Construct(builder, testName, TechType.MARKETPLACE);
        Startup testSU = builder.getStartup();
        assertEquals(testSU.getLevel(), lvl);
    }
    
    @Test
    public void startupStartingApprovalTest() {
        testName = "Test Startup";
        director.Construct(builder, testName, TechType.MARKETPLACE);
        double approve = 25.0;
        Startup testSU = builder.getStartup();
        assertEquals(testSU.getPublicApproval(), approve, 0.001);
    }
    
    @Test
    public void startupStartingNetIncomeTest() {
        testName = "Test Startup";
        director.Construct(builder, testName, TechType.MARKETPLACE);
        double netIncome = 75.0;
        Startup testSU = builder.getStartup();
        assertEquals(testSU.getNetIncome(), netIncome, 0.001);
    }
    
    @Test
    public void startupStartRevenueTest() {
        testName = "Test Startup";
        director.Construct(builder, testName, TechType.MARKETPLACE);
        double rev = 50.0;
        Startup testSU = builder.getStartup();
        assertEquals(testSU.getRevenue(), rev, 0.001);
    }

}
