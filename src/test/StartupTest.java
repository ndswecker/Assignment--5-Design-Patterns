package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import main.java.*;

public class StartupTest {
    
    StartupDirector startupDirector;
    StartupBuilder startupBuilder;
    String startupTestName;
    String startupTestName2;
    String startupTestName3;
    Startup testSU;
    Startup test2SU;
    Startup test3SU;
    
    TechGiantDirector techDirector;
    TechGiantBuilder techBuilder;
    String techTestName;
    TechGiant testTG;
    
    @Before
    public void setup() throws Exception{
        startupDirector = new StartupDirector();
        startupBuilder = new StartupMP();
        startupTestName = "Test Startup";
        startupTestName2 = "The Other Guy";
        startupTestName3 = "Backdoor Bros";
        
        startupDirector.Construct(startupBuilder, startupTestName, TechType.MARKETPLACE);
        testSU = startupBuilder.getStartup();
        
        startupBuilder = new StartupHW();
        startupDirector.Construct(startupBuilder, startupTestName2, TechType.HARDWARE);
        test2SU = startupBuilder.getStartup();
        
        startupBuilder = new StartupSE();
        startupDirector.Construct(startupBuilder, startupTestName3, TechType.SERVICE);
        test3SU = startupBuilder.getStartup();
        
        techDirector = new TechGiantDirector();
        techBuilder = new TechGiantNA();
        techTestName = "Test Tech Giant of NA";
        techDirector.Construct(techBuilder, techTestName, TechType.SERVICE);
    }
    
    @After
    public void tearDown() throws Exception{
        startupDirector = null;
        startupBuilder = null;
        startupTestName = null;
        startupTestName2 = null;
        startupTestName3 = null;
        testSU = null;
        test2SU = null;
        test3SU = null;
        
        techDirector = null;
        techBuilder = null;
        techTestName = null;
        testTG = null;
    }
    
    @Test
    public void startupNameTest() {
        //Startup testSU = startupBuilder.getStartup();
        System.out.println(testSU.getName() + " vs " + startupTestName);
        assertEquals(testSU.getName(), startupTestName);
    }
    
    @Test
    public void startupStartingLevelTest() {
        int lvl = 1;
        //Startup testSU = startupBuilder.getStartup();
        assertEquals(testSU.getLevel(), lvl);
    }
    
    @Test
    public void startupStartingApprovalTest() {
        double approve = Consts.SU_LOW;
        //Startup testSU = startupBuilder.getStartup();
        assertEquals(testSU.getPublicApproval(), approve, 0.001);
    }
    
    @Test
    public void startupStartingNetIncomeTest() {
        double netIncome = Consts.SU_HIGH;
        //Startup testSU = startupBuilder.getStartup();
        assertEquals(testSU.getNetIncome(), netIncome, 0.001);
    }
    
    @Test
    public void startupStartRevenueTest() {
        double rev = Consts.SU_MID;
        //Startup testSU = startupBuilder.getStartup();
        assertEquals(testSU.getRevenue(), rev, 0.001);
    }
    
    /**
     * Test new startups are by default wild.
     *  */
    @Test
    public void startupStartIndependent() {
       // Startup testSU = startupBuilder.getStartup();
        assertNull(testSU.getOverLord());
    }
    
    /**
     * Test making a wild startup to a captive startup
     * */
    @Test
    public void startupAddOverLord() {
        //Startup testSU = startupBuilder.getStartup();
        TechGiant testTG = techBuilder.getTechGiant();
        testSU.setOverLord(testTG);
        assertEquals(testTG, testSU.getOverLord());
    }
    
    /**
     * Test removing a TechGiant from a Startup
     * */
    @Test
    public void addAndRemoveTG() {
        //Startup testSU = startupBuilder.getStartup();
        TechGiant testTG = techBuilder.getTechGiant();
        testSU.setOverLord(testTG);
        testSU.makeIndependent();
        assertNull(testSU.getOverLord());
    }
    
    /**
     * Test an attack from one startup to another
     * */
    @Test
    public void attackSU() {
    }

}
