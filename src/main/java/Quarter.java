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

    /**
     * taxCuts is a financial event in an odd quarter.
     * TechGiants may be increase their net income
     * by rolling their d20.
     * [1,5] = no change.
     * [6,14] = 10% increase.
     * [15,20] = 15% increase.
     * */
    @Override
    public void taxCuts(MarketSystem system) {
        for (TechGiant listElement : system.allTechGiants) {
            double currrentNI = listElement.getNetIncome();
            int niRoll = listElement.roll(0);
            if (niRoll < 6) {
                // Do nothing
            } else if (niRoll < 15) {
                listElement.adjNetIncome(currrentNI * 0.1);
            } else {
                listElement.adjNetIncome(currrentNI * 0.15);
            }
        }
        
    }
    
    /**
     * marketShareVariance is a financial event in an odd quarter.
     * Startup can gain or lose market share. The startup rolls their d20.
     * Startups use their market share modifier to effect the outcome.
     * [1,5] = -10% market share.
     * [6,14] = no change.
     * [15,20] + 10% market share.
     * */
    @Override
    public void marketShareVariance(MarketSystem system) {
        //System.out.println("calling marketShareVariance");
        for (Startup listElement : system.allStartups) {
            double currentMS = listElement.getMarketShare();
            int msRoll = listElement.roll(listElement.getMarketShareMod());
            //System.out.println(listElement.getName() + " rolls " + msRoll);
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
     * catchStartup is a method for all TechGiants to acquire wild startups.
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
                System.out.println("\n" + victim.toString());
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
