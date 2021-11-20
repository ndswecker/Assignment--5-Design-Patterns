package main.java;

public class ASTechGiant extends TechGiantBuilder {
    
    private TechGiant newTechGiant = new TechGiant();

    @Override
    public void startRevenue() {
        newTechGiant.adjRevenue(Consts.TG_LOW);
    }

    @Override
    public void startNetIncome() {
        newTechGiant.adjNetIncome(Consts.TG_HIGH);
    }

    @Override
    public void startApproval() {
        newTechGiant.adjPublicApproval(Consts.TG_LOW / 10);
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
}
