package main.java;

public class QOdd extends QuarterBuilder implements QOddEvents{
    
    private Quarter newQuarter = new Quarter();

    @Override
    public void setOrder(int order) {
        newQuarter.setOrder(order);
    }

    @Override
    public void addToSystem(MarketSystem system) {
        system.allQuarters.add(newQuarter);
    }
    
    @Override
    public Quarter getQuarter() {
        return newQuarter;
    }
    
    /**
     * Startup can gain or lose market share. The startup rolls their d20.
     * Startups use their market share modifier to effect the outcome.
     * [1,5] = -10% market share.
     * [6,14] = no change.
     * [15,20] + 10% market share.
     * */
    @Override
    public void marketShareVariance(MarketSystem system) {

    }

    @Override
    public void catchStartup(MarketSystem system) {
        // TODO Auto-generated method stub
        
    }

}
