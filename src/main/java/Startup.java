package main.java;

import main.java.TechType;


/**
* Class: Startup represents startup that can be independent or owned by a tech giant.
*/

public class Startup {
    
    private double netIncome;
    private double revenue;
    private double marketShare;
    private double publicApproval;
    private String name;
    
    private int level;
    
    public TechGiant overLord;
    
    private TechType techType;
    
    /**
     * Custom ToString for readability.
     * */
    public String toString() {
        String sendable = "====== " + name + " =====";
        sendable += "\n===== Level " + level + " =====";
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
  
    public void adjMarketShare(double amount) {
        this.marketShare += amount;
    }
    
    public double getMarketShare() {
        return this.marketShare;
    }
  
    public void adjPublicApproval(double amount) {
        this.publicApproval += amount;
    }
    
    public double getPublicApproval() {
        return this.publicApproval;
    }
  
    public void adjLevel(int adj) {
        this.level++;    
    }
    
    public int getLevel() {
        return this.level;
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
    
    public void setOverLord(TechGiant giant) {
        this.overLord = giant;
    }
    
    public TechGiant getOverLord() {
        return this.overLord;
    }
    
    public void makeIndependent() {
        this.overLord = null;
    }
    
    // See https://www.linkedin.com/pulse/four-basic-types-technology-company-why-you-need-know-ben-blomerley
    //    public enum TechType {
    //        HARDWARE, SERVICE, BUSINESSEXT, MARKETPLACE
    //    }
    //    
    //    public TechType techType;
    //    
    //    public Startup(TechType type) {
    //        
    //        switch(type){
    //            case HARDWARE:
    //                this.techType = TechType.HARDWARE;
    //                break;
    //            case SERVICE:
    //                this.techType = TechType.SERVICE;
    //                break;
    //            case BUSINESSEXT:
    //                this.techType = TechType.BUSINESSEXT;
    //                break;
    //            case MARKETPLACE:
    //                this.techType = TechType.MARKETPLACE;
    //                break;
    //        }
    //    }

}
