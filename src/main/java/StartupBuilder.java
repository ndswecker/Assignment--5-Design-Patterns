package main.java;

/**
 * Class StartupBuilder is an Abstract Builder Class for Builder pattern.
 */
public abstract class StartupBuilder {

    public abstract void startRevenue();
    
    public abstract void startMarketShare();
    
    public abstract void startNetIncome();
    
    public abstract void startApproval();
    
    public abstract void startLevel();
    
    public abstract Startup getStartup();
    
    public abstract void startName(String name);
    
    public abstract void startTechType(TechType type);
    
    public abstract void startIndependent();
    
    public abstract void startupD20();
    
    public abstract void setMods(int net, int rev, int app, int mar);
    
    public abstract void addToSystem(MarketSystem system);

}
