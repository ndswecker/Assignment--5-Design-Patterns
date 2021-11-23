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
    
    public void listStartups() {
        for (Startup listElement : allStartups) {
            System.out.println(listElement.getName());
        }
    }
    
    public void listTechGiants() {
        for (TechGiant listElement : allTechGiants) {
            System.out.println(listElement.getName());
        }
    }
    
    public void listQuarters() {
        for (Quarter listElement : allQuarters) {
            System.out.println(listElement.getOrder());
        }
    }
    
    public Quarter getQuarter(int quart) {
        return allQuarters.get(quart);
    }

}
