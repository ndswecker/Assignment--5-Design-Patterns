package main.java;

public class StartupDirector {
    
    public void Construct(StartupBuilder builder, String name) {
        builder.startApproval();
        builder.startLevel();
        builder.startMarketShare();
        builder.startNetIncome();
        builder.startName(name);
    }

}
