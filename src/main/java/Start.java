package main.java;

public class Start {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Initial fireup.");
        
        // Make a Director
        StartupDirector director = new StartupDirector();
        
        // 
        StartupBuilder builder = new MPStartup();
        
        String name = "New Startup POW";
        
        director.Construct(builder, name, TechType.MARKETPLACE);
        Startup firstSU = builder.getStartup();
        
        System.out.println(firstSU.getLevel());
        System.out.println(firstSU.toString());
    }

}
