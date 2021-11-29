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
    public String toString() {
        String sendable = ":::::::::::";
        sendable += "\nQuarter " + this.getOrder();
        sendable += "\n::::::::::";
        return sendable;
    }
    
    /**
     * supplyChainCollapse is a financial event that effects net income.
     * [1,5] = 20% loss
     * [6,14] = 10% loss
     * [15,20] = no loss
     * */
    @Override
    public void supplyChainCollapse(MarketSystem system) {
        for (TechGiant tgElement : system.allTechGiants) {
            double currentNI = tgElement.getNetIncome();
            int niRoll = tgElement.roll(0);
            if (niRoll < 6) {
                tgElement.adjNetIncome(-1 * currentNI * 0.2);
            } else if (niRoll < 15) {
                tgElement.adjNetIncome(-1 * currentNI * 0.1);
            } else if (niRoll >=15) {
                // Do nothing
            }
        }
    }

    /**
     * internationalConflict is a financial event that effects revenue
     * [1,5] = 20% loss
     * [6,14] = no loss
     * [15,20] = 20% gain. The tech giant is able to exploit the conflict for gain.
     * */
    @Override
    public void internationalConflict(MarketSystem system) {
        for (TechGiant tgElement : system.allTechGiants) {
            double currentRE = tgElement.getRevenue();
            int reRoll =  tgElement.roll(0);
            if (reRoll < 6) {
                tgElement.adjRevenue(-1 * currentRE * 0.2);
            } else if (reRoll < 15) {
                // Do nothing
            } else if (reRoll >= 15) {
                tgElement.adjRevenue(currentRE * 0.2);
            }
        }
        
    }

    /**
     * publicScandal is a financial event that effects public approval.
     * TechGiants effected by this event.
     * [1,5] = handle poorly, lose approval.
     * [6,14] = hide it, nobody finds out.
     * [15,20] = positive spin! gain (100-current)*0.2
     * */
    @Override
    public void publicScandal(MarketSystem system) {
        for (TechGiant tgElement : system.allTechGiants) {
            double currentPA = tgElement.getPublicApproval();
            int paRoll = tgElement.roll(0);
            if (paRoll < 6) {
                tgElement.adjPublicApproval(-1 * (100 - currentPA) * 0.2);
            } else if (paRoll < 15) {
                // Do nothing
            } else if (paRoll >= 15) {
                tgElement.adjPublicApproval((100 - currentPA) * 0.2);
            }
        }
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
     * evolveSU is a method for startups to naturally evolve in an odd quarter.
     * Startups undergo random and chaotic events that can cause them to evolve.
     * Evolution occurs by the advancement of the startup level.
     * Evolution is influenced by the revenue modifier with a d20 roll.
     * [1,14] = no change
     * [15-20] = increase by one level
     * > 20 = increase by two levels
     * */
    @Override
    public void evolveSUs(MarketSystem system) {
        for (Startup listSU : system.allStartups) {
            int revRoll = listSU.roll(listSU.getRevenueMod());
            if (revRoll < 15) {
                // Do nothing
            } else if (revRoll <= 20) {
                listSU.adjLevel(1);
            } else if (revRoll > 20) {
                listSU.adjLevel(2);
            }
        }
        
    }

    /**
     * catchStartup is a method for all TechGiants to acquire wild startups.
     * */
    @Override
    public void roundupStartups(MarketSystem system) {
        System.out.println("INITIATING TECH GIANT ROUND UP OF WILD STARTUPS");
        // Iterate thru all tech giants
        for (TechGiant listGiants : system.allTechGiants) {
            TechGiant aggressor = listGiants;
            System.out.println(aggressor.getName());
            System.out.println("--- vs ---");
            // Iterate thru all startups
            for (Startup listStartups : system.allStartups) {
                Startup victim = listStartups;
                System.out.println("\n" + victim.getName());
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
