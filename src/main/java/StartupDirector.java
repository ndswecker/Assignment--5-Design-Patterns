package main.java;

public class StartupDirector {
    
    public void Construct(StartupBuilder builder, String name, TechType type) {
        builder.startApproval();
        builder.startLevel();
        builder.startMarketShare();
        builder.startNetIncome();
        builder.startName(name);
        builder.startTechType(type);
        builder.startRevenue();
    }

}
