package main.java;

/**
* Class TechGiantDirector tells a builder the needed cardinal steps to make a tech giant.
*/

public class TechGiantDirector {
    
    public void Construct(TechGiantBuilder builder, String name, TechType type, MarketSystem system) {
        
        builder.startName(name);
        
        builder.startTechType(type);
        
        builder.startApproval();
        
        builder.startNetIncome();
        
        builder.startRevenue();
        
        builder.techD20();
        
        builder.initialStartup(type, system);
        
        builder.addToSystem(system);
    }

}
