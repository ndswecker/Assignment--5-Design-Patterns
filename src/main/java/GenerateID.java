package main.java;

public class GenerateID {
    
    private static GenerateID single_id = null;
    
    public int countID;
    
    private GenerateID() {
        countID = 1;
    }
    
    public static GenerateID getInstance() {
        if (single_id == null) {
            single_id = new GenerateID();
        }
        return single_id;
    }
    
    public int getNewID() {
        countID++;
        return (countID - 1);
    }

}
