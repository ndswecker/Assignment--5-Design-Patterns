package main.java;

/**
 * Concrete Builder Class
 *  */

public class MPStartup extends StartupBuilder{
    
    private Startup newStartup = new Startup();

    @Override
    public void startRevenue() {
        newStartup.adjRevenue(50.0);
        
    }

    @Override
    public void startMarketShare() {
        newStartup.adjMarketShare(50.0);
        
    }

    @Override
    public void startNetIncome() {
        newStartup.adjNetIncome(75.0);
        
    }

    @Override
    public void startApproval() {
        newStartup.adjPublicApproval(25.0);
        
    }

    @Override
    public void startLevel() {
        newStartup.adjLevel(1);
        
    }

    @Override
    public Startup getStartup() {
        return newStartup;
        
    }

    @Override
    public void startName(String name) {
        newStartup.adjName(name);
        
    }

}
