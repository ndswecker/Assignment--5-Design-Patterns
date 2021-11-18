package main.java;

/**
 * Abstract Builder Class for Builder pattern.
 */
public abstract class StartupBuilder {
    
    final double LOW = 25.0;
    
    final double MID = 50.0;
    
    final double HIGH = 75.0;
    
    final int START = 1;
    
    public abstract void startRevenue();
    
    public abstract void startMarketShare();
    
    public abstract void startNetIncome();
    
    public abstract void startApproval();
    
    public abstract void startLevel();
    
    public abstract Startup getStartup();
    
    public abstract void startName(String name);
    
    public abstract void startTechType(TechType type);

}
