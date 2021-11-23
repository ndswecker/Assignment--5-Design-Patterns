package main.java;

public abstract class QuarterBuilder {
    
    public abstract void setOrder(int order);
    
    public abstract void addToSystem(MarketSystem system);
    
    public abstract Quarter getQuarter();

}
