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
    
    @Override
    public void marketShareVariance(MarketSystem system) {

    }

    @Override
    public void catchStartup(MarketSystem system) {
        // TODO Auto-generated method stub
        
    }

}
