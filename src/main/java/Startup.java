package main.java;

import main.java.TechType;


/**
* Class: Startup represents startup that can be independent or owned by a tech giant.
* 
* netIncome:        effects under cut prices attack.
* revenue:          effects hack server attack.
* marketShare:      effects talent drain attack.
* publicApproval:   effects misinformation attack.
* 
* <p>Attacker wins ties.
*/

public class Startup implements StartupAttack{
    
    private double netIncome;
    private double revenue;
    private double marketShare;
    private double publicApproval;
    private String name;
    
    private int level;
    
    public TechGiant overLord;
    
    private TechType techType;
    
    private D20 d20;
    
    private int netIncomeMod, revenueMod, marketShareMod, publicApprovalMod;
    
    /**
     * Custom ToString for readability.
     * */
    public String toString() {
        String sendable = "===========";
        sendable += "\n" + this.name;
        sendable += "\nLevel " + level;
        sendable += "\nNet Income " + this.netIncome + " ( " + this.netIncomeMod + " )";
        sendable += "\nRevenue " + this.revenue + " ( " + this.revenueMod + " )";
        sendable += "\nPublic Approval " + this.publicApproval + " ( " + this.publicApprovalMod + " )";
        sendable += "\nMarket Share " + this.marketShare + " ( " + this.marketShareMod + " )";
        if (this.getOverLord() == null) {
            sendable += "\nWild Startup";
        } else {
            sendable += "\nOwned by " + this.getOverLord().getName();
        }
        sendable += "\n===========";
        return sendable;
    }
    
    public void adjNetIncome(double amount) {
        this.netIncome += amount;
    }
    
    public double getNetIncome() {
        return this.netIncome;
    }
    
    public void setNetIncome(double amount) {
        this.netIncome = amount;
    }
  
    public void adjRevenue(double amount) {
        this.revenue += amount;
    }
    
    public void setRevenue(double amount) {
        this.revenue = amount;
    }
    
    public double getRevenue() {
        return this.revenue;
    }
  
    public void adjMarketShare(double amount) {
        this.marketShare += amount;
    }
    
    public void setMarketShare(Double amount) {
        this.marketShare = amount;
    }
    
    public double getMarketShare() {
        return this.marketShare;
    }
  
    public void adjPublicApproval(double amount) {
        this.publicApproval += amount;
    }
    
    public void setPublicApproval(double amount) {
        this.publicApproval = amount;
    }
    
    public double getPublicApproval() {
        return this.publicApproval;
    }
  
    public void adjLevel(int adj) {
        this.level++;    
    }
    
    public void setLevel(int lvl) {
        this.level = lvl;
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
    
    public int roll(int mod) {
        return d20.roll(mod);
    }
    
    ///////////////////// MODIFIERS /////////////////////
    
    /**
     * Net Income Modifier.
     * */
    public int getNetIncomeMod() {
        return this.netIncomeMod;
    }
    
    public void startNetIncomeMod(int mod) {
        this.netIncomeMod = mod;
    }
    
    public void adjNetIncomeMod(int adj) {
        this.netIncomeMod += adj;
    }
    
    /**
     * Revenue Modifier.
     * */
    public int getRevenueMod() {
        return this.revenueMod;
    }
    
    public void startRevenueMod(int mod) {
        this.revenueMod = mod;
    }
    
    public void adjRevenueMod(int adj) {
        this.revenueMod += adj;
    }
    
    /**
     * Public Approval Modifier.
     * */
    public int getPublicApprovalMod() {
        return this.publicApprovalMod;
    }
    
    public void startPublicApprovalMod(int mod) {
        this.publicApprovalMod = mod;
    }
    
    public void adjPublicApprovalMod(int adj) {
        this.publicApprovalMod += adj;
    }
    
    /**
     * Marketshare Modifier.
     * */
    public int getMarketShareMod() {
        return this.marketShareMod;
    }
    
    public void startMarketShareMod(int mod) {
        this.marketShareMod = mod;
    }
    
    public void adjMarketShareMod(int adj) {
        this.marketShareMod += adj;
    }
    
    public void generateD20() {
        d20 = new D20();
    }
    
///////////////////// ATTACKS /////////////////////

    /**
     * hackServer relies on the revenue mod.
     * */
    @Override
    public boolean hackServer(Startup defender) {
        
        int atkRoll = this.roll(this.getRevenueMod());
        int defRoll = defender.roll(defender.getRevenueMod());
        
        if (atkRoll < defRoll) {
            return false;
        }
        
        return true;
    }
    
    /**
     * undercutPrices relies on the net income modifier.
     * */
    @Override
    public boolean undercutPrices(Startup defender) {
        int atkRoll = this.roll(this.getNetIncomeMod());
        int defRoll = defender.roll(defender.getNetIncomeMod());
        
        if (atkRoll < defRoll) {
            return false;
        }
        return true;
    }
    
    /**
     * misinformationBlast relies on the public approval modifier.
     * */
    @Override
    public boolean misinformationBlast(Startup defender) {
        int atkRoll = this.roll(this.getPublicApprovalMod());
        int defRoll = defender.roll(defender.getPublicApprovalMod());
        
        if (atkRoll < defRoll) {
            return false;
        }
        return true;
    }
    
    /**
     * talentDrain relies on the market share modifier.
     * */
    @Override
    public boolean talentDrain(Startup defender) {
        int atkRoll = this.roll(getMarketShareMod());
        int defRoll = defender.roll(defender.getMarketShareMod());
        
        if (atkRoll < defRoll) {
            return false;
        }
        return true;
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
