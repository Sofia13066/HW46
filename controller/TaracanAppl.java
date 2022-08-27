package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


import model.Taracan;

public class TaracanAppl {
    

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Enter number of taracans:");
        BufferedReader taracansNumb = new BufferedReader(new InputStreamReader(System.in));
        int taracanNum = Integer.parseInt(taracansNumb.readLine());
        
        System.out.println("Enter distance:");
        BufferedReader dist = new BufferedReader(new InputStreamReader(System.in));
        int distance = Integer.parseInt(dist.readLine());

        ArrayList<Thread> taracans = new ArrayList<>(taracanNum);
        String winner = "";

        for(int i = 1; i <= taracanNum; i++){
            String name = "taracan"+i;
            Taracan var = new Taracan(name, distance, i, winner);
            Thread varThread = new Thread(var);
            taracans.add(varThread);
        }

        for(int i = 0; i < taracanNum; i++){
            taracans.get(i).start();
        }
    

        for(int i = 0; i < taracanNum; i++){
            taracans.get(i).join();
            
        }
        

        System.out.println("Congratulations to tarakan #" + Taracan.winner);
        
    }

    
    
}
