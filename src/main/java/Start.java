package main.java;

import java.util.*;

public class Start {
    
    //public static MarketSystem system;

    public static void main(String[] args) {
        
        System.out.println("Initial fireup.");
        
        // Build a financial market system
        MarketSystem system = new MarketSystem();
        
        // Build quarters
        Quarter q1, q2, q3, q4;
        QuarterDirector qDirector;
        QuarterBuilder qBuilder;
        
        qDirector = new QuarterDirector();
        qBuilder = new QOdd();
        qDirector.Construct(qBuilder, 1, system);
        q1 = qBuilder.getQuarter();
        
        qBuilder = new QEven();
        qDirector.Construct(qBuilder, 2, system);
        q2 = qBuilder.getQuarter();
        
        qBuilder = new QOdd();
        qDirector.Construct(qBuilder, 3, system);
        q3 = qBuilder.getQuarter();
        
        qBuilder = new QEven();
        qDirector.Construct(qBuilder, 4, system);
        q4 = qBuilder.getQuarter();
        
        // Build independent Startups
        Startup suBE, suMP, suSE, suHW;
        StartupDirector sDirector = new StartupDirector();
        StartupBuilder sBuilder = new StartupMP();
        sDirector.Construct(sBuilder, "Agrion Platform", TechType.MARKETPLACE, system);
        suMP = sBuilder.getStartup();
        sBuilder = new StartupBE();
        sDirector.Construct(sBuilder, "Hyporon Business Solutions", TechType.BUSINESSEXT, system);
        suBE = sBuilder.getStartup();
        sBuilder = new StartupSE();
        sDirector.Construct(sBuilder, "Apollyon Services", TechType.SERVICE, system);
        suSE = sBuilder.getStartup();
        sBuilder = new StartupHW();
        sDirector.Construct(sBuilder, "Spartan Steel", TechType.HARDWARE, system);
        suHW = sBuilder.getStartup();
        
        //system.listStartups();
        
        // Build TechGiants
        TechGiant tgNA, tgAS, tgEU;
        TechGiantDirector tDirector = new TechGiantDirector();
        TechGiantBuilder tBuilder = new TechGiantNA();
        tDirector.Construct(tBuilder, "Huberus Enterprises", TechType.SERVICE, system);
        tgNA = tBuilder.getTechGiant();
        tBuilder = new TechGiantAS();
        tDirector.Construct(tBuilder, "Final Harmony", TechType.MARKETPLACE, system);
        tgAS = tBuilder.getTechGiant();
        tBuilder = new TechGiantEU();
        tDirector.Construct(tBuilder, "Precision Snobbery", TechType.BUSINESSEXT, system);
        tgEU = tBuilder.getTechGiant();
        
        system.listTechGiants();
        system.listStartups();
        system.listQuarters();

    }

}
