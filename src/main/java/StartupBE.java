package main.java;

/**
* Class: StartupBE is a Business extension tech startup. 
*/

public class StartupBE extends StartupBuilder {
    
    private Startup newStartup = new Startup();
    
    @Override
    public void startRevenue() {
        newStartup.adjRevenue(Consts.SU_MID);
        
    }

    @Override
    public void startMarketShare() {
        newStartup.adjMarketShare(Consts.SU_MID);
        
    }

    @Override
    public void startNetIncome() {
        newStartup.adjNetIncome(Consts.SU_HIGH);
        
    }

    @Override
    public void startApproval() {
        newStartup.adjPublicApproval(Consts.SU_LOW);
        
    }

    @Override
    public void startLevel() {
        newStartup.adjLevel(Consts.START_LEVEL);
        
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

}
