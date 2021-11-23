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
        
        // netIcome, revenue, publicApproval, marketShare
        switch (type) {
        case HARDWARE: 
            builder.setMods(Consts.MOD_HIGH, Consts.MOD_MID, Consts.MOD_LOW, Consts.MOD_ZERO);
            break;
        case BUSINESSEXT:
            builder.setMods(Consts.MOD_ZERO, Consts.MOD_HIGH, Consts.MOD_MID, Consts.MOD_LOW);
            break;
        case SERVICE:
            builder.setMods(Consts.MOD_LOW, Consts.MOD_ZERO, Consts.MOD_HIGH, Consts.MOD_MID);
            break;
        case MARKETPLACE:
            builder.setMods(Consts.MOD_MID, Consts.MOD_LOW, Consts.MOD_ZERO, Consts.MOD_HIGH);
        }
        
        builder.addToSystem();
    }

}
