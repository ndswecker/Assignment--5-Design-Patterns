package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import main.java.*;

public class StartupTest {
    
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
    
    @Before
    public void setup() throws Exception{
        
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
    }
    
    @After
    public void tearDown() throws Exception{
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
    
    @Test
    public void startupNameTest() {
        assertEquals(testMP.getName(), testNameMP);
    }
    
    @Test
    public void startupStartingLevelTest() {
        int lvl = 1;
        assertEquals(testMP.getLevel(), lvl);
    }
    
    @Test
    public void startupStartingApprovalTest() {
        double approve = Consts.SU_LOW;
        assertEquals(testMP.getPublicApproval(), approve, 0.001);
    }
    
    @Test
    public void startupStartingNetIncomeTest() {
        double netIncome = Consts.SU_HIGH;
        assertEquals(testMP.getNetIncome(), netIncome, 0.001);
    }
    
    @Test
    public void startupStartRevenueTest() {
        double rev = Consts.SU_MID;
        assertEquals(testMP.getRevenue(), rev, 0.001);
    }
    
    /**
     * Test new startups are by default wild.
     *  */
    @Test
    public void startupStartIndependent() {
        assertNull(testMP.getOverLord());
    }
    
    /**
     * Test making a wild startup to a captive startup
     * */
    @Test
    public void startupAddOverLord() {
        TechGiant testTG = techBuilder.getTechGiant();
        testMP.setOverLord(testTG);
        assertEquals(testTG, testMP.getOverLord());
    }
    
    /**
     * Test removing a TechGiant from a Startup.
     * */
    @Test
    public void addAndRemoveTG() {
        TechGiant testTG = techBuilder.getTechGiant();
        testMP.setOverLord(testTG);
        testMP.makeIndependent();
        assertNull(testMP.getOverLord());
    }
    
    /**
     * Test a hack server attack from one startup to multiple others.
     * Revenue
     * */
    @Test
    public void hackServerTest() {
        
        double vicRev = testHW.getRevenue();
        int outcome1 = testMP.hackServer(testHW);
        assertNotNull(outcome1);
        if (outcome1 == 0) {
            assertEquals(vicRev, testHW.getRevenue(), 0.001);
        } else if (outcome1 ==1) {
            assertEquals((vicRev - vicRev * 0.1), testHW.getRevenue(), 0.001);
        } else if (outcome1 == 2) {
            assertEquals((vicRev - vicRev * 0.2), testHW.getRevenue(), 0.001);
        }
        
        vicRev = testSE.getRevenue();
        int outcome2 = testMP.hackServer(testSE);
        assertNotNull(outcome2);
        if (outcome2 == 0) {
            assertEquals(vicRev, testSE.getRevenue(), 0.001);
        } else if (outcome2 ==1) {
            assertEquals((vicRev - vicRev * 0.1), testSE.getRevenue(), 0.001);
        } else if (outcome2 == 2) {
            assertEquals((vicRev - vicRev * 0.2), testSE.getRevenue(), 0.001);
        }
        
        vicRev = testBE.getRevenue();
        int outcome3 = testMP.hackServer(testBE);
        assertNotNull(outcome3);
        if (outcome3 == 0) {
            assertEquals(vicRev, testBE.getRevenue(), 0.001);
        } else if (outcome3 ==1) {
            assertEquals((vicRev - vicRev * 0.1), testBE.getRevenue(), 0.001);
        } else if (outcome3 == 2) {
            assertEquals((vicRev - vicRev * 0.2), testBE.getRevenue(), 0.001);
        }
    }
    
    /**
     * Test an undercut prices attack from one startup to multiple others.
     * Net Income
     * */
    @Test
    public void undercutPricesTest() {
        double vicNI = testMP.getNetIncome();
        int outcome1 = testHW.undercutPrices(testMP);
        assertNotNull(outcome1);
        if (outcome1 == 0) {
            assertEquals(vicNI, testMP.getNetIncome(), 0.001);
        } else if (outcome1 == 1) {
            assertEquals((vicNI - vicNI * 0.1), testMP.getNetIncome(), 0.001);
        } else if (outcome1 == 2) {
            assertEquals((vicNI - vicNI * 0.2), testMP.getNetIncome(), 0.001);
        }
        
        vicNI = testBE.getNetIncome();
        int outcome2 = testHW.undercutPrices(testBE);
        assertNotNull(outcome2);
        if (outcome2 == 0) {
            assertEquals(vicNI, testBE.getNetIncome(), 0.001);
        } else if (outcome2 ==1) {
            assertEquals((vicNI - vicNI * 0.1), testBE.getNetIncome(), 0.001);
        } else if (outcome2 == 2) {
            assertEquals((vicNI - vicNI * 0.2), testBE.getNetIncome(), 0.001);
        }
        
        vicNI = testSE.getNetIncome();        
        int outcome3 = testHW.undercutPrices(testSE);
        assertNotNull(outcome2);
        if (outcome3 == 0) {
            assertEquals(vicNI, testSE.getNetIncome(), 0.001);
        } else if (outcome3 ==1) {
            assertEquals((vicNI - vicNI * 0.1), testSE.getNetIncome(), 0.001);
        } else if (outcome3 == 2) {
            assertEquals((vicNI - vicNI * 0.2), testSE.getNetIncome(), 0.001);
        }
        assertNotNull(outcome3);
    }
    
    /**
     * Test a misinformationBlast attack from one startup to multiple others.
     * Public Approval
     * */
    @Test
    public void misninformationBlastTest() {

        double vicApproval = testHW.getPublicApproval();
        int outcome1 = testBE.misinformationBlast(testHW);
        assertNotNull(outcome1);
        if (outcome1 == 0) {
            assertEquals(vicApproval, testHW.getPublicApproval(), 0.001);
        } else if (outcome1 == 1) {
            assertEquals(vicApproval - ((100 - vicApproval) * 0.1), testHW.getPublicApproval(), 0.001);
        } else if (outcome1 == 2) {
            assertEquals(vicApproval - ((100 - vicApproval) * 0.2), testHW.getPublicApproval(), 0.001);;
        }
        
        vicApproval = testMP.getPublicApproval();
        int outcome2 = testBE.misinformationBlast(testMP);
        assertNotNull(outcome2);
        if (outcome2 == 0) {
            assertEquals(vicApproval, testMP.getPublicApproval(), 0.001);
        } else if (outcome2 == 1) {
            assertEquals(vicApproval - ((100 - vicApproval) * 0.1), testMP.getPublicApproval(), 0.001);
        } else if (outcome2 == 2) {
            assertEquals(vicApproval - ((100 - vicApproval) * 0.2), testMP.getPublicApproval(), 0.001);
        }
        
        vicApproval = testSE.getPublicApproval();
        int outcome3 = testBE.misinformationBlast(testSE);
        assertNotNull(outcome3);
        if (outcome3 == 0) {
            assertEquals(vicApproval, testSE.getPublicApproval(), 0.001);
        } else if (outcome3 == 1) {
            assertEquals(vicApproval - ((100 - vicApproval) * 0.1), testSE.getPublicApproval(), 0.001);
        } else if (outcome3 == 2) {
            assertEquals(vicApproval - ((100 - vicApproval) * 0.2), testSE.getPublicApproval(), 0.001);
        }
    }
    
    /**
     * Test a talentDrainTest() from one startup against multiple others.
     * */
//    @Test
//    public void talentDrainTest() {
//       boolean outcome1 = testSE.talentDrain(testBE);
//       boolean outcome2 = testSE.talentDrain(testHW);
//       boolean outcome3 = testSE.talentDrain(testMP);
//       assertNotNull(outcome1);
//       assertNotNull(outcome2);
//       assertNotNull(outcome3);
//    }
    
    /**
     * Test a BUSINESSEXT mods.
     * */
    @Test
    public void modBE() {
        assertEquals(testBE.getNetIncomeMod(), Consts.MOD_ZERO);
        assertEquals(testBE.getRevenueMod(), Consts.MOD_HIGH);
        assertEquals(testBE.getPublicApprovalMod(), Consts.MOD_MID);
        assertEquals(testBE.getMarketShareMod(), Consts.MOD_LOW);
    }
    
    /**
     * Test changing modifiers.
     * */
    
    @Test 
    public void changeMods() {
        testBE.adjNetIncomeMod(1);
        assertEquals(testBE.getNetIncomeMod(), Consts.MOD_ZERO + 1);
        testBE.adjNetIncomeMod(-1);
        assertEquals(testBE.getNetIncomeMod(), Consts.MOD_ZERO);
        
        testBE.adjRevenueMod(1);
        assertEquals(testBE.getRevenueMod(), Consts.MOD_HIGH + 1);
        testBE.adjRevenueMod(-2);
        assertEquals(testBE.getRevenueMod(), Consts.MOD_MID);
        
        testBE.adjPublicApprovalMod(1);
        assertEquals(testBE.getPublicApprovalMod(), Consts.MOD_MID + 1);
        testBE.adjPublicApprovalMod(-2);
        assertEquals(testBE.getPublicApprovalMod(), Consts.MOD_LOW);
        
        testBE.adjMarketShareMod(1);
        assertEquals(testBE.getMarketShareMod(), Consts.MOD_LOW + 1);
        testBE.adjMarketShareMod(-2);
        assertEquals(testBE.getMarketShareMod(), Consts.MOD_ZERO);
    }
    
    /**
     * Test a HARDWARE mods.
     * */
    @Test
    public void modHW() {
        assertEquals(testHW.getNetIncomeMod(), Consts.MOD_HIGH);
        assertEquals(testHW.getRevenueMod(), Consts.MOD_MID);
        assertEquals(testHW.getPublicApprovalMod(), Consts.MOD_LOW);
        assertEquals(testHW.getMarketShareMod(), Consts.MOD_ZERO);
    }
    
    /**
     * Test a SERVICE mods.
     * */
    @Test
    public void modSE() {
        assertEquals(testSE.getNetIncomeMod(), Consts.MOD_LOW);
        assertEquals(testSE.getRevenueMod(), Consts.MOD_ZERO);
        assertEquals(testSE.getPublicApprovalMod(), Consts.MOD_HIGH);
        assertEquals(testSE.getMarketShareMod(), Consts.MOD_MID);
    }
    
    /**
     * Test a MARKETPLACE mods.
     * */
    @Test
    public void modMP() {
        assertEquals(testMP.getNetIncomeMod(), Consts.MOD_MID);
        assertEquals(testMP.getRevenueMod(), Consts.MOD_LOW);
        assertEquals(testMP.getPublicApprovalMod(), Consts.MOD_ZERO);
        assertEquals(testMP.getMarketShareMod(), Consts.MOD_HIGH);
    }

}
