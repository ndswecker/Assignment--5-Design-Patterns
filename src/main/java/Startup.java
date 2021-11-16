package main.java;

public class Startup {
    
    // See https://www.linkedin.com/pulse/four-basic-types-technology-company-why-you-need-know-ben-blomerley
    public enum TechType {
        HARDWARE, SERVICE, BUSINESSEXT, MARKETPLACE
    }
    
    public TechType techType;
    
    public Startup(TechType type) {
        
        switch(type){
            case HARDWARE:
                this.techType = TechType.HARDWARE;
                break;
            case SERVICE:
                this.techType = TechType.SERVICE;
                break;
            case BUSINESSEXT:
                this.techType = TechType.BUSINESSEXT;
                break;
            case MARKETPLACE:
                this.techType = TechType.MARKETPLACE;
                break;
        }
    }

}
