package main.java;

import java.util.*;

public class MarketSystem {
    
    public LinkedList<Startup> allStartups;
    
    public LinkedList<TechGiant> allTechGiants;
    
    public LinkedList<Quarter> allQuarters;
    
    public MarketSystem(){
        allStartups = new LinkedList();
        allTechGiants = new LinkedList();
        allQuarters = new LinkedList();
    }

}
