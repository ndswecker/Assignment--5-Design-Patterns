package main.java;

/**
 * Concrete Builder Class
 *  */

public class MPStartup extends StartupBuilder{
    
    private Startup newStartup = new Startup();
    
    @Override
    public void startRevenue() {
        newStartup.adjRevenue(MID);
        
    }

    @Override
    public void startMarketShare() {
        newStartup.adjMarketShare(MID);
        
    }

    @Override
    public void startNetIncome() {
        newStartup.adjNetIncome(HIGH);
        
    }

    @Override
    public void startApproval() {
        newStartup.adjPublicApproval(LOW);
        
    }

    @Override
    public void startLevel() {
        newStartup.adjLevel(START);
        
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

}
