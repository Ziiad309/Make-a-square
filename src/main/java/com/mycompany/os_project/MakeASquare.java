package com.mycompany.os_project;

import java.util.ArrayList;
import java.util.HashMap;
public class MakeASquare {
    public static int[][] Square(HashMap<Integer, int[][]> sendPieces) throws InterruptedException {
        
        Paralleling.allPieces = sendPieces;
        Paralleling.foundBoard = false;

        
        Paralleling masterSlave = new Paralleling();
        ArrayList<Thread> slaves = new ArrayList<Thread>();
        for(int i = 0; i < constants.numberOfThreads; i++){
            Thread tmp = new Thread(masterSlave , Integer.toString(i));
            slaves.add(tmp);
        }
        
        for(int i = 0; i < constants.numberOfThreads; i++){
            slaves.get(i).start();
        }
        for(int i = 0; i < constants.numberOfThreads; i++){
            slaves.get(i).join();
        }

        if(Paralleling.foundBoard) return Paralleling.finallyBoard;
        else return null;
        
    }
}