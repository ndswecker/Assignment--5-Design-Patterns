package main.java;

public class Start {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Initial fireup.");
        
        // Make a Startup
        StartupDirector director = new StartupDirector();
        StartupBuilder builder = new MPStartup();
        String name = "New Startup POW";
        director.Construct(builder, name, TechType.MARKETPLACE);
        Startup firstSU = builder.getStartup();
        
        System.out.println(firstSU.getLevel());
        System.out.println(firstSU.toString());
        
        // Make a TechGiant
        TechGiantDirector techDirector = new TechGiantDirector();
        TechGiantBuilder techBuilder = new NATechGiant();
        String techName = "North American Dominance INC";
        techDirector.Construct(techBuilder, techName, TechType.SERVICE);
        TechGiant firstTG = techBuilder.getTechGiant();
        
        System.out.println("North America's First Tech Giant:");
        System.out.println(firstTG.toString());

    }

}
