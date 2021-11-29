package main.java;

public class D20 {
    
    int outcome;
    
    public int roll(int mod) {
        outcome = (int)(Math.random()*20) + 1 + mod;
        return outcome;
    }

}
