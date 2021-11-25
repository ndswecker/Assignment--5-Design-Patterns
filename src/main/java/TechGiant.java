package main.java;

import java.util.*;

/**
* Class: TechGiant represents a tech giant that owns startups.
*/

public class TechGiant {
    private double netIncome;
    private double revenue;
    private double publicApproval;
    private String name;
    
    private TechType techType;
    
    private LinkedList<Startup> ownedStartups;
    
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
    public void releaseStartup(Startup sub) {
        for (Iterator<Startup> iter = ownedStartups.iterator(); iter.hasNext();) {
            Startup su = iter.next();
            if (su == sub) {
                iter.remove();
            }
        }
        // Free startup to be wild
        sub.makeIndependent();
    }
    
}
