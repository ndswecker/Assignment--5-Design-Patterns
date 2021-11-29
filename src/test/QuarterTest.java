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
    
    TechGiant tgNA, tgAS, tgEU;
    TechGiantDirector tDirector;
    TechGiantBuilder tBuilder;
    
    MarketSystem system;
    
    Quarter q1, q2, q3, q4;
    QuarterDirector qDirector;
    QuarterBuilder qBuilder;
    
    @Before
    public void setup() throws Exception {
        
        system = new MarketSystem();
        
        startupDirector = new StartupDirector();
        startupBuilder = new StartupMP();
        testNameMP = "Rando MP.";
        testNameHW = "The Other Guy HW.";
        testNameSE = "Backdoor Bros SE.";
        testNameBE = "Better Service BE.";
        
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
        
        tDirector = new TechGiantDirector();
        tBuilder = new TechGiantNA();
        tDirector.Construct(tBuilder, "Huberus Enterprises", TechType.SERVICE, system);
        tgNA = tBuilder.getTechGiant();
        tBuilder = new TechGiantAS();
        tDirector.Construct(tBuilder, "Final Harmony", TechType.MARKETPLACE, system);
        tgAS = tBuilder.getTechGiant();
        tBuilder = new TechGiantEU();
        tDirector.Construct(tBuilder, "Precision Snobbery", TechType.BUSINESSEXT, system);
        tgEU = tBuilder.getTechGiant();
        
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
        
        system = null;
        
        tgNA = null;
        tgAS = null;
        tgEU = null;
        tDirector = null;
        tBuilder = null;
    }
    
    /**
     * Test instantiation of a financial system object.
     * */
    @Test
    public void finSystemInitTest() {
        assertNotNull(system);
        assertNotNull(system.allStartups);
        assertNotNull(system.allTechGiants);
        assertNotNull(system.allQuarters);
        
    }
    
    /**
     * Test Quarter attr.
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
        System.out.println("\nNOW TESTING MARKET SHARE VARIANCE EVENT\n");
        system.listStartups();
        Quarter current = system.getQuarter(0);
        current.marketShareVariance(system);
        System.out.println("\nPOST MARKET SHARE VARIANCE EVENT\n");
        system.listStartups();
    }
    
    /**
     * Test catchStartup financial event in first quarter.
     * */
    @Test
    public void catchStartupTest() {
        Quarter current = system.getQuarter(0);
        current.roundupStartups(system);
        system.listTechGiants();
    }
    
    @Test
    public void taxCutTest() {
        System.out.println("\nNOW TESTING TAX CUTS EVENT\n");
        system.listTechGiants();
        Quarter current = system.getQuarter(0);
        current.taxCuts(system);
        System.out.println("\nPOST TAX CUTS EVENT\n");
        system.listTechGiants();
    }
    
    @Test
    public void evolveSUsTest() {
        System.out.println("\nNOW TESTING EVOLVE STARTUPS\n");
        system.listStartups();
        Quarter current = system.getQuarter(0);
        current.evolveSUs(system);
        System.out.println("\nPOST EVOLVE STARTUPS EVENT\n");
        system.listStartups();
    }
    
    @Test
    public void publicScandalTest() {
        System.out.println("\nNOW TESTING PUBLIC SCANDAL\n");
        system.listTechGiants();
        Quarter current = system.getQuarter(0);
        current.publicScandal(system);
        System.out.println("\nPOST PUBLIC SCANDAL EVENT\n");
        system.listTechGiants();
    }
    
    @Test
    public void internationalConflictTest() {
        System.out.println("\nNOW TESTING INTERNATIONAL CONFLICT\n");
        system.listTechGiants();
        Quarter current = system.getQuarter(0);
        current.internationalConflict(system);
        System.out.println("\nPOST INTERNATIONAL CONFLICT EVENT\n");
        system.listTechGiants();
    }
    
    @Test
    public void supplyChainCollapseTest() {
        System.out.println("\nNOW TESTING SUPPLY CHAIN COLLAPSE\n");
        system.listTechGiants();
        Quarter current = system.getQuarter(0);
        current.supplyChainCollapse(system);
        System.out.println("\nPOST SUPPLY CHAIN COLLAPSE EVENT\n");
        system.listTechGiants();
    }

}
