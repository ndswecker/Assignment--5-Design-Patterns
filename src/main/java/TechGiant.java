package main.java;

import java.util.*;

/**
* Class: TechGiant represents a tech giant that owns startups.
*/

public class TechGiant implements TechGiantAttack{
    private double netIncome;
    private double revenue;
    private double publicApproval;
    private String name;
    
    private TechType techType;
    
    public LinkedList<Startup> ownedStartups;
    
    private D20 d20;
    
    public String toString() {
        String sendable = "*****\n" + name;
        sendable += "\nOwned Startups " + ownedStartups.size();
        sendable += "\nNet Income $M: " + this.netIncome;
        sendable += "\nPublic Approval %: " + this.publicApproval;
        sendable += "\n*****";
        return sendable;
    }
    
    public void adjNetIncome(double amount) {
        this.netIncome += amount;
    }
    
    public double getNetIncome() {
        return this.netIncome;
    }
  
    public void adjRevenue(double amount) {
        this.revenue += amount;
    }
    
    public double getRevenue() {
        return this.revenue;
    }
    
    public void adjPublicApproval(double amount) {
        this.publicApproval += amount;
    }
    
    public double getPublicApproval() {
        return this.publicApproval;
    }
    
    public void adjName(String newName) {
        this.name = newName;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void adjTechType(TechType type) {
        this.techType = type;
    }
    
    public TechType getTechType() {
        return this.techType;
    }
    
    public int getNumOfStartups() {
        return ownedStartups.size();
    }
    
    public void generateD20() {
        d20 = new D20();
    }
    
    public int roll(int mod) {
        return d20.roll(mod);
    }
    
    /**
     * Each TechGiant gets an initial Startup.
     * */
    public void firstStartup(MarketSystem system) {
        
        ownedStartups = new LinkedList<Startup>();
        
        // Make an initial startup for the tech giant to own
        StartupDirector director = new StartupDirector();
        StartupBuilder builder = new StartupMP();
        String startupName = "";
        
        switch (this.techType) {
            case HARDWARE:
                startupName = "Generic Hardware Inc.";
                break;
            case BUSINESSEXT:
                startupName = "Generic Business Extension Co.";
                break;
            case SERVICE:
                startupName = "Generic Service Tech LLC.";
                break;
            case MARKETPLACE:
                startupName = "Generic Online Sellers";
        }
        
        director.Construct(builder, startupName, techType, system);
        Startup firstSU = builder.getStartup();
        firstSU.setOverLord(this);
        this.ownedStartups.add(firstSU);
    }
    
    /**
     * Acquire a startup.
     * */
    public void consumeStartup(Startup sub) {
        // Add startup to list of owned startups
        this.ownedStartups.add(sub);
        // Set startup overlord to be this overlord
        sub.setOverLord(this);
        System.out.println(this.getName() + " captured " + sub.getName());
    }
    
    /**
     * Remove a Startup from the TechGiant's ownership.
     * */
//    public void releaseStartup(Startup sub) {
//        for (Iterator<Startup> iter = ownedStartups.iterator(); iter.hasNext();) {
//            Startup su = iter.next();
//            if (su == sub) {
//                iter.remove();
//            }
//        }
//        // Free startup to be wild
//        sub.makeIndependent();
//    }
    
    public LinkedList<Startup> getStartups(){
        return this.ownedStartups;
    }

    @Override
    public Startup catchStartup(Startup victim) {
        System.out.println(this.getName() + " attempting to capture " + victim.getName());
        int aggRoll = this.roll(0);
        int vicRoll = victim.roll(victim.getNetIncomeMod());
        if (aggRoll > vicRoll) {
            this.consumeStartup(victim);
        } else {
            System.out.println("failed to capture " + victim.getName());
        }
        return null;
    }

    /**
     * boostStats is a method for a tech giant to boost the stats of their startups.
     * */
    @Override
    public void boostAllStats() {
        for (Startup su : this.ownedStartups) {
            // MarketShare & Public Approval is a percentage, so adjust it by the boost rate
            su.adjMarketShare((100 - su.getMarketShare()) * Consts.BOOST);
            su.adjPublicApproval((100 - su.getPublicApproval()) * Consts.BOOST);
            su.adjNetIncome(su.getNetIncome() * Consts.BOOST);
            su.adjRevenue(su.getRevenue() * Consts.BOOST);
        }
        
    }

    @Override
    public void evolveAStartup(Startup ascender) {
        ascender.adjLevel(1);
        System.out.println(ascender.getName() + " gained a level");
        //ascender.adjNetIncome(ascender.getNetIncome() * 0.2); // 20% gain in net income
        //ascender.adjRevenue(ascender.getRevenue() * 0.2); // 20% gain in revenue;
    }

    @Override
    public void boostOneStats(Startup booster) {
        booster.adjMarketShare((100 - booster.getMarketShare()) * Consts.BOOST);
        booster.adjPublicApproval((100 - booster.getPublicApproval()) * Consts.BOOST);
        booster.adjNetIncome(booster.getNetIncome() * Consts.BOOST);
        booster.adjRevenue(booster.getRevenue() * Consts.BOOST);
        System.out.println(booster.getName() + " has been boosted");
    }
    
}
