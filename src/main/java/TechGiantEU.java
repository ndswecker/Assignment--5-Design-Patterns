package main.java;

/**
* Class TechGiantEU represents and European tech giant. 
*/

public class TechGiantEU extends TechGiantBuilder {
    
    private TechGiant newTechGiant = new TechGiant();

    @Override
    public void startRevenue() {
        newTechGiant.adjRevenue(Consts.TG_MID);
    }

    @Override
    public void startNetIncome() {
        newTechGiant.adjNetIncome(Consts.TG_MID);
    }

    @Override
    public void startApproval() {
        newTechGiant.adjPublicApproval(Consts.TG_HIGH / 10);
    }

    @Override
    public TechGiant getTechGiant() {
        return newTechGiant;
    }

    @Override
    public void startName(String name) {
        newTechGiant.adjName(name);
    }

    @Override
    public void startTechType(TechType type) {
        newTechGiant.adjTechType(type);
    }

    @Override
    public void initialStartup(TechType type) {
        newTechGiant.firstStartup();
    }
    
    @Override
    public void addToSystem() {
        Start.system.allTechGiants.add(newTechGiant);
        
    }
}
