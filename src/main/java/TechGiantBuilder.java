package main.java;

/**
* Class TechGiantBuilder supports the Builder pattern for a tech giant.
*/

public abstract class TechGiantBuilder {
    
    public abstract void startRevenue();
    
    public abstract void startNetIncome();
    
    public abstract void startApproval();
    
    public abstract TechGiant getTechGiant();
    
    public abstract void startName(String name);
    
    public abstract void startTechType(TechType type);
    
    public abstract void initialStartup(TechType type, MarketSystem system);
    
    public abstract void techD20();
    
    public abstract void addToSystem(MarketSystem system);

}
