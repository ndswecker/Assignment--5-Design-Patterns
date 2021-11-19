package main.java;

import main.java.TechType;

public class TechGiant {
    private double netIncome;
    private double revenue;
    private double publicApproval;
    private String name;
    
    private int numOfStartups;
    
    private TechType techType;
    
    public String toString() {
        String sendable = "***** " + name + " *****";
        sendable += "\n**** ( " + numOfStartups + ") ****";
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
    
}
