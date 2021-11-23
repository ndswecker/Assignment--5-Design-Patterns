package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import main.java.*;

public class QuarterTest {
    
    StartupDirector startupDirector;
    StartupBuilder startupBuilder;
    String testNameMP;
    String testNameHW;
    String testNameSE;
    String testNameBE;
    
    Startup testMP;
    Startup testHW;
    Startup testSE;
    Startup testBE;
    
    TechGiantDirector techDirector;
    TechGiantBuilder techBuilder;
    String techTestName;
    TechGiant testTG;
    
    MarketSystem system;
    
    Quarter q1, q2, q3, q4;
    QuarterDirector qDirector;
    QuarterBuilder qBuilder;
    
    @Before
    public void setup() throws Exception {
        
        system = new MarketSystem();
        
        startupDirector = new StartupDirector();
        startupBuilder = new StartupMP();
        testNameMP = "Test Startup";
        testNameHW = "The Other Guy";
        testNameSE = "Backdoor Bros";
        testNameBE = "Better Service";
        
        startupDirector.Construct(startupBuilder, testNameMP, TechType.MARKETPLACE, system);
        testMP = startupBuilder.getStartup();
        
        startupBuilder = new StartupHW();
        startupDirector.Construct(startupBuilder, testNameHW, TechType.HARDWARE, system);
        testHW = startupBuilder.getStartup();
        
        startupBuilder = new StartupSE();
        startupDirector.Construct(startupBuilder, testNameSE, TechType.SERVICE, system);
        testSE = startupBuilder.getStartup();
        
        startupBuilder = new StartupBE();
        startupDirector.Construct(startupBuilder, testNameBE, TechType.BUSINESSEXT, system);
        testBE = startupBuilder.getStartup();
        
        techDirector = new TechGiantDirector();
        techBuilder = new TechGiantNA();
        techTestName = "Test Tech Giant of NA";
        techDirector.Construct(techBuilder, techTestName, TechType.SERVICE, system);
        
        qDirector = new QuarterDirector();
        qBuilder = new QOdd();
        qDirector.Construct(qBuilder, 1, system);
        q1 = qBuilder.getQuarter();
        
        qBuilder = new QEven();
        qDirector.Construct(qBuilder, 2, system);
        q2 = qBuilder.getQuarter();
        
        qBuilder = new QOdd();
        qDirector.Construct(qBuilder, 3, system);
        q3 = qBuilder.getQuarter();
        
        qBuilder = new QEven();
        qDirector.Construct(qBuilder, 4, system);
        q4 = qBuilder.getQuarter();
        
    }
    
    @After
    public void tearDown() throws Exception {
        
        startupDirector = null;
        startupBuilder = null;
        testNameMP = null;
        testNameHW = null;
        testNameSE = null;
        testMP = null;
        testHW = null;
        testSE = null;
        testBE = null;
        
        techDirector = null;
        techBuilder = null;
        techTestName = null;
        testTG = null;
        
        system = null;
    }
    
    /**
     * Test instantiation of a financial system object
     * */
    @Test
    public void finSystemInitTest() {
        assertNotNull(system);
        assertNotNull(system.allStartups);
        assertNotNull(system.allTechGiants);
        assertNotNull(system.allQuarters);
        
    }
    
    /**
     * Test Quarter attr
     * */
    @Test
    public void qAttr() {
        assertEquals(system.allQuarters.size(), 4);
        assertEquals(system.allQuarters.get(0).getOrder(), 1);
        assertEquals(system.allQuarters.get(1).getOrder(), 2);
        assertEquals(system.allQuarters.get(2).getOrder(), 3);
        assertEquals(system.allQuarters.get(3).getOrder(), 4);
    }
    
    /**
     * Test marketShareVariance event of QOdd
     * */
    @Test
    public void msVarEventTest() {
        Quarter current = system.getQuarter(1);
        current.marketShareVariance(system);
    }

}
