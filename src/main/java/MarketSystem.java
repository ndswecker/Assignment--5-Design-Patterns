package main.java;

import java.util.*;

public class MarketSystem {
    
    public LinkedList<Startup> allStartups;
    
    public LinkedList<TechGiant> allTechGiants;
    
    public LinkedList<Quarter> allQuarters;
    
    public Scanner in;
    
    public MarketSystem(){
        allStartups = new LinkedList();
        allTechGiants = new LinkedList();
        allQuarters = new LinkedList();
        
        in = new Scanner(System.in);
    }
    
    public void listStartups() {
        for (Startup listElement : allStartups) {
            System.out.println(listElement.toString());
        }
    }
    
    public void listTechGiants() {
        for (TechGiant listElement : allTechGiants) {
            System.out.println(listElement.toString());
        }
    }
    
    public void listQuarters() {
        for (Quarter listElement : allQuarters) {
            System.out.println(listElement.toString());
        }
    }
    
    public Quarter getQuarter(int quart) {
        return allQuarters.get(quart);
    }
    
    public void marketLoop() {
        String input = "";
        boolean ongoing = true;
        while (ongoing) {
            //String input = in.next();
//            if (input.equals("exit")) {
//                ongoing = false;
//            }
            
            for (TechGiant tg : allTechGiants) { // Go thru each Tech Giant
                System.out.println(tg.getName() + " Select one of your startups");
                for (Startup su : tg.ownedStartups) { // iterate thru each startup
                    System.out.println(su.toString());
                }
                input = in.next();
                int selector = Integer.parseInt(input);
                if (selector == 1) {
                    System.out.println("you've selected " + tg.ownedStartups.get(selector - 1).getName());
                }
            }
            
            System.out.println(input);
        }
    }

}
