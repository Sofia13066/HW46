package model;

import java.util.ArrayList;
import java.util.Random;

public class Taracan implements Runnable {
    
    private static final int minSleep = 2;
    private static final int maxSleep = 5;
    

    String name;
    int distance;
    static int taracanNum;
    int time;
    public static String winner;
    static ArrayList<Taracan> finishedTaracans = new ArrayList<>(taracanNum);
    
    
    public Taracan(String name, int distance, int taracanNum, String winner) {
        this.name = name;
        this.distance = distance;
        Taracan.winner = winner;
    }

   @Override
    public void run() {
        try {

            for(int i = 0; i < distance; i++){
                int toSleep = rnd(minSleep, maxSleep);
                this.time += toSleep;
                System.out.println("Taracan " + name + " race" + i + " sleeps " + toSleep + "ms");
                Thread.sleep(toSleep);
            }

            finishedTaracans.add(this);
            

        } catch (Exception e) {

        }

        winner = finishedTaracans.get(0).name;
    }



    private static int rnd(int a, int b) {
        Random rand = new Random();
        int x  =  a +  rand.nextInt(b - a + 1);
        return x;
}



}
