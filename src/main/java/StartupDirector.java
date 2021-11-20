package main.java;

/**
* Class: StartupDirector directs a startup builder the cardinal steps to making a startup. 
*/

public class StartupDirector {
    
    public void Construct(StartupBuilder builder, String name, TechType type) {
        builder.startApproval();
        builder.startLevel();
        builder.startMarketShare();
        builder.startNetIncome();
        builder.startName(name);
        builder.startTechType(type);
        builder.startRevenue();
        builder.startupD20();
    }

}
