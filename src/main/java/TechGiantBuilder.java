package main.java;

public abstract class TechGiantBuilder {
    
    final double LOW = 250.0;
    
    final double MID = 500.0;
    
    final double HIGH = 750.0;
    
    public abstract void startRevenue();
    
    public abstract void startNetIncome();
    
    public abstract void startApproval();
    
    public abstract TechGiant getTechGiant();
    
    public abstract void startName(String name);
    
    public abstract void startTechType(TechType type);
    
    public abstract void initialStartup(TechType type);

}
