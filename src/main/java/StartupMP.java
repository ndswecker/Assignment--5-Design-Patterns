package main.java;

/**
* Class StartupMP represents a marketplace startup
*/

public class StartupMP extends StartupBuilder implements StartupAttack {
    
    private Startup newStartup = new Startup();
    
    @Override
    public void startRevenue() {
        newStartup.setRevenue(Consts.SU_MID);
        
    }

    @Override
    public void startMarketShare() {
        newStartup.setMarketShare(Consts.SU_MID);
        
    }

    @Override
    public void startNetIncome() {
        newStartup.setNetIncome(Consts.SU_HIGH);
        
    }

    @Override
    public void startApproval() {
        newStartup.setPublicApproval(Consts.SU_LOW);
        
    }

    @Override
    public void startLevel() {
        newStartup.setLevel(Consts.START_LEVEL);
        
    }

    @Override
    public Startup getStartup() {
        return newStartup;
        
    }

    @Override
    public void startName(String name) {
        newStartup.adjName(name);
        
    }
    
    @Override
    public void startTechType(TechType type) {
        newStartup.adjTechType(type);
    }
    
    @Override
    public void startIndependent() {
        newStartup.makeIndependent();
    }
    
    @Override
    public void startupD20() {
        newStartup.generateD20();
        
    }

    @Override
    public int hackServer(Startup defender) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int undercutPrices(Startup defender) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int misinformationBlast(Startup defender) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int talentDrain(Startup defender) {
        
        return 0;
    }
    
    @Override
    public void setMods(int net, int rev, int app, int mar) {
        newStartup.startNetIncomeMod(net);
        newStartup.startRevenueMod(rev);
        newStartup.startPublicApprovalMod(app);
        newStartup.startMarketShareMod(mar);
        
    }
    
    @Override
    public void addToSystem(MarketSystem system) {
        system.allStartups.add(newStartup);
        
    }

    @Override
    public void setID() {
        GenerateID newID = GenerateID.getInstance();
        newStartup.setID(newID.getNewID());
    }

}
