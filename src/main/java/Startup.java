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
    private int id;
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
        sendable += "\n" + this.name + "(ID: " + this.getID() + " )";
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
    
    public void setID(int num) {
        this.id = num;
    }
    
    public int getID() {
        return this.id;
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
     * Revenue Attack.
     * */
    @Override
    public int hackServer(Startup defender) {
        System.out.println(this.getName() + " Now attacking " + defender.getName());
        int atkRoll = this.roll(this.getRevenueMod());
        int defRoll = defender.roll(defender.getRevenueMod());
        
        // Determine if the attacker wins
        // Attacker breaks ties.
        if (atkRoll < defRoll) {
            System.out.println("attack fails");
            return 0; // Do nothing
        } else if (atkRoll >= defRoll) {
            System.out.print("attack succesfull, ");
            if (atkRoll > defRoll + Consts.CRIT) {
                System.out.print("critical hit.\n");
                defender.adjRevenue(defender.getRevenue() * -0.2);
                return 2;
            } else {
                System.out.println("normal hit.\n");
                defender.adjRevenue(defender.getRevenue() * -0.1);
                return 1;
            }
        } 
        return 0;
    }
    
    /**
     * undercutPrices relies on the net income modifier.
     * Net Income Attack.
     * */
    @Override
    public int undercutPrices(Startup defender) {
        System.out.println(this.getName() + " Now attacking " + defender.getName());
        int atkRoll = this.roll(this.getNetIncomeMod());
        int defRoll = defender.roll(defender.getNetIncomeMod());
        
        // Determine if the attacker wins
        // Attacker breaks ties.
        if (atkRoll < defRoll) {
            System.out.println("attack fails");
            return 0; // Do nothing
        } else if (atkRoll >= defRoll) {
            System.out.print("attack succesfull, ");
            if (atkRoll > defRoll + Consts.CRIT) {
                System.out.print("critical hit.\n");
                defender.adjNetIncome(defender.getNetIncome() * -0.2);
                return 2;
            } else {
                System.out.println("normal hit.\n");
                defender.adjNetIncome(defender.getNetIncome() * -0.1);
                return 1;
            }
        } 
        return 0;
    }
    
    /**
     * misinformationBlast relies on the public approval modifier.
     * Public Approval Attack.
     * */
    @Override
    public int misinformationBlast(Startup defender) {
        System.out.println(this.getName() + " Now attacking " + defender.getName());
        int atkRoll = this.roll(this.getPublicApprovalMod());
        int defRoll = defender.roll(defender.getPublicApprovalMod());
        
        // Determine if the attacker wins
        // Attacker breaks ties.
        if (atkRoll < defRoll) {
            System.out.println("attack fails");
            return 0;
        } else if (atkRoll >= defRoll) {
            System.out.print("attack succesfull, ");
            if (atkRoll > defRoll + Consts.CRIT) {
                System.out.print("critical hit.\n");
                defender.adjPublicApproval((100 - defender.getPublicApproval()) * -0.2);
                return 2;
            } else {
                System.out.println("normal hit.\n");
                defender.adjPublicApproval((100 - defender.getPublicApproval()) * -0.1);
                return 1;
            }
        } 
        return 0;
    }
    
    /**
     * talentDrain relies on the market share modifier.
     * Market Share Attack.
     * */
    @Override
    public int talentDrain(Startup defender) {
        System.out.println(this.getName() + " Now attacking " + defender.getName());
        int atkRoll = this.roll(getMarketShareMod());
        int defRoll = defender.roll(defender.getMarketShareMod());
        
        // Determine if the attacker wins
        // Attacker breaks ties.
        if (atkRoll < defRoll) {
            System.out.println("attack fails");
            return 0;
        } else if (atkRoll >= defRoll) {
            System.out.print("attack succesfull, ");
            if (atkRoll > defRoll + Consts.CRIT) {
                System.out.print("critical hit.\n");
                defender.adjMarketShare(defender.getMarketShare() * -0.2);
                return 2;
            } else {
                System.out.println("normal hit.\n");
                defender.adjMarketShare(defender.getMarketShare() * -0.1);
                return 1;
            }
        } 
        return 0;
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
