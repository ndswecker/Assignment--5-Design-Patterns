package main.java;

public class QOdd extends QuarterBuilder{
    
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

}
