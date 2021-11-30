package main.java;

import java.util.*;

public class MarketSystem implements Container {
    
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
    
    @Override
    public Iterator getIteratorSU() {
       return new StartupIterator();
    }
    
    @Override
    public Iterator getIteratorTG() {
        return new TechGiantIterator();
    }
    
    private class StartupIterator implements Iterator{
        int index;
        
        @Override
        public boolean hasNext() {
            if (index < allStartups.size()) {
                return true;
            }
            return false;
        }
        
        @Override
        public Object next() {
            if (this.hasNext()) {
                return allStartups.get(index++);
            }
            return null;
        }
    }
    private class TechGiantIterator implements Iterator{
        int index;
        
        @Override
        public boolean hasNext() {
            if (index < allTechGiants.size()) {
                return true;
            }
            return false;
        }
        
        @Override
        public Object next() {
            if (this.hasNext()) {
                return allTechGiants.get(index++);
            }
            return null;
        }
    }
    
    public void listStartups() {
        for (Iterator iter = this.getIteratorSU(); iter.hasNext();) {
            System.out.println(iter.next().toString());
        }
    }
    
    public void listTechGiants() {
        for (Iterator iter = this.getIteratorTG(); iter.hasNext();) {
            System.out.println(iter.next().toString());
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
    
    public Startup getByID(int num) {
        for (Startup su : this.allStartups) {
            if (su.getID() == num) {
                return su;
            }
        }
        return null;
    }
    
    /**
     * marketLoop simulates the 4 quarters.
     * */
    public void marketLoop() {
        String input = "";
        boolean ongoing = true;
        int counterQ = 0;
        Quarter currentQ = allQuarters.get(counterQ);
        while (ongoing) {
            // Financial event occurs at the beginning of each quarter
            switch (counterQ) {
            
            // FIRST QUARTER //
                case 0:
                    //Financial Event Round Up Wild Startups
                    currentQ.roundupStartups(this);
                    
                    // Tech Giants get a chance to boost or evolve one of their startups
                    for (TechGiant tg : allTechGiants) { // Go thru each Tech Giant
                        System.out.println("\n" + tg.getName() + " Select one of your startups");
                        for (Startup su : tg.ownedStartups) { // iterate thru each startup
                            System.out.println(su.toString());
                        }
                        input = in.next();
                        int selector = Integer.parseInt(input);
                        Startup selected = this.getByID(selector);
                        System.out.println(" you've selected " + selected.getName());
                        System.out.println("Would you like to (1) Evolve it, or (2) Boost its stats?");
                        input = in.next();
                        selector = Integer.parseInt(input);
                        if (selector == 1) {
                            tg.evolveAStartup(selected);
                        } else if (selector == 2) {
                            tg.boostOneStats(selected);
                        }
                    }
                    break; // FIRST QUARTER END
                    
                // SECOND QUARTER //
                case 1:
                    // Financial Event Market Share Variance
                    currentQ.marketShareVariance(this);
                    
                    // COMBAT //
                    for (TechGiant tg : allTechGiants) {
                        // Select an aggressor startup
                        System.out.println("\n" + tg.getName() + " Select your startup to engage in battle.");
                        for (Startup su : tg.ownedStartups) {
                            System.out.println(su.toString());
                        }
                        input = in.next();
                        int selector = Integer.parseInt(input);
                        Startup aggressor = this.getByID(selector);
                        System.out.println(" You've selected " + aggressor.getName());
                        
                        // Select a victim startup
                        System.out.println(" Select an enemy Startup to attack");
                        for (Startup su : this.allStartups) {
                            if (su.getOverLord() != null && su.getOverLord() != tg) {
                                System.out.println(su.toString());
                            }
                        }
                        input = in.next();
                        selector = Integer.parseInt(input);
                        Startup victim = this.getByID(selector);
                        System.out.println(" You've selected as a victim " + victim.getName());
                        
                        // Select an attack type
                        System.out.println("\nHow do you want to attack?\n(1)Hack Server\n(2)Undercut prices\n(3)Misinformation Blast\n(4)Talent Drain");
                        input = in.next();
                        selector = Integer.parseInt(input);
                        switch (selector) {
                            case 1:
                                aggressor.hackServer(victim);
                                break;
                            case 2:
                                aggressor.undercutPrices(victim);
                                break;
                            case 3:
                                aggressor.misinformationBlast(victim);
                                break;
                            case 4: 
                                aggressor.talentDrain(victim);
                        }
                    }
                    
                    break; // SECOND QUARTER END
                
                // THIRD QUARTER //
                case 2:
                    currentQ.taxCuts(this);
                    break; // THIRD QUARTER END
                
                    // FOURTH QUARTER //
                case 3:
                    currentQ.publicScandal(this);
                    break;// FOURTH QUARTER END
                }
            
            counterQ = (counterQ + 1) % 4;
            System.out.println("\n**** End of Quarter ****\n");
        }
    }

}
