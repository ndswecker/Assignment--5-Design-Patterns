package main.java;

public class TechGiantDirector {
    
    public void Construct(TechGiantBuilder builder, String name, TechType type) {
        
        builder.startName(name);
        
        builder.startTechType(type);
        
        builder.startApproval();
        
        builder.startNetIncome();
        
        builder.startRevenue();
        
        builder.initialStartup(type);
    }

}
