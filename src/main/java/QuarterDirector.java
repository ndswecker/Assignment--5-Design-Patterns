package main.java;

public class QuarterDirector {
    
    public void Construct(QuarterBuilder builder, int num, MarketSystem system) {
        builder.setOrder(num);
        builder.addToSystem(system);
    }
    

}
