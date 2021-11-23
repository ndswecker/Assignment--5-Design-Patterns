package main.java;

public class Q1 extends QuarterBuilder{
    
    private Quarter newQuarter = new Quarter();

    @Override
    public void setOrder(int order) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addToSystem() {
        Start.system.allQuarters.add(newQuarter);
        
    }

}
