package main.java;

/**
 * StartupAttack uses 4 attacks based on the 4 main attr of a startup.
* netIncome:        effects under cut prices attack.
* revenue:          effects hack server attack.
* marketShare:      effects talent drain attack.
* publicApproval:   effects misinformation attack.
 * */

public interface StartupAttack {
    
    public int hackServer(Startup defender); 
    
    public int undercutPrices(Startup defender); 
    
    public int misinformationBlast(Startup defender); 
    
    public int talentDrain(Startup defender); 

}
