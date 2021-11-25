package main.java;

public class Quarter implements FinancialEvents, QOddEvents {
    
    private int order;
    
    public int getOrder() {
        return this.order;
    }
    
    public void setOrder(int num) {
        this.order = num;
    }

    @Override
    public void SupplyChainCollapse() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void InternationalConflict() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Nationalization() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void TaxCuts() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void marketShareVariance(MarketSystem system) {
        //System.out.println("calling marketShareVariance");
        for (Startup listElement : system.allStartups) {
            double currentMS = listElement.getMarketShare();
            int msRoll = listElement.roll(listElement.getMarketShareMod());
            System.out.println(listElement.getName() + " rolls " + msRoll);
            if (msRoll < 6) {
                listElement.adjMarketShare(-1 * (currentMS / 10) );
            } else if (msRoll < 15) {
                listElement.adjMarketShare(0);
            } else {
                listElement.adjMarketShare(currentMS / 10);
            }
        }
    }

    /**
     * catchStartup is a method for TechGiants to acquire wild startups.
     * */
    @Override
    public void catchStartup(MarketSystem system) {
        // Iterate thru all tech giants
        for (TechGiant listGiants : system.allTechGiants) {
            TechGiant aggressor = listGiants;
            System.out.println(aggressor.toString());
            System.out.println("--- vs ---");
            // Iterate thru all startups
            for (Startup listStartups : system.allStartups) {
                Startup victim = listStartups;
                System.out.println(victim.toString());
                // Only attempt to capture wild startups
                if (victim.getOverLord() == null) {
                    int aggRoll = aggressor.roll(0);
                    int vicRoll = victim.roll(victim.getNetIncomeMod());
                    System.out.println(aggressor.getName() + " attempting to capture " + victim.getName());
                    if (aggRoll > vicRoll) {
                        aggressor.consumeStartup(victim);
                    } else {
                        System.out.println(aggressor.getName() + " failled to capture " + victim.getName());
                    }
                } else {
                    System.out.println(victim.getName() + " is held by a Tech Giant.");
                }
            }
        }
        
    }

}
