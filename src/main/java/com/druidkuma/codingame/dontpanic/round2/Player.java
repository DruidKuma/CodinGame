package com.druidkuma.codingame.dontpanic.round2;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt();
        int nbElevators = in.nextInt(); // number of elevators
        in.nextLine();

        Map<Integer, List<Integer>> elevators = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            int elevatorPos = in.nextInt(); // position of the elevator on its floor

            if(elevators.get(elevatorFloor) == null) {
                elevators.put(elevatorFloor, new ArrayList<Integer>());
            }

            elevators.get(elevatorFloor).add(elevatorPos);
            in.nextLine();
        }

        Map<Integer, Integer> createdElevators = new HashMap<Integer, Integer>();
        // game loop
        while (true) {
            
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT
            in.nextLine();

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            
            List<Integer> elevatorPos = elevators.get(cloneFloor);
            if((elevatorPos == null && createdElevators.get(cloneFloor) == null) ||
                    (elevatorPos != null && Math.abs(clonePos-getClosest(elevatorPos,clonePos)) > 10
                                        && createdElevators.get(cloneFloor) == null)) {
                    
                System.out.println("ELEVATOR");
                createdElevators.put(cloneFloor, 1);
            }
            else if((clonePos >= width-1) || (clonePos <= 0 && !direction.equals("NONE")) || 
                (createdElevators.get(cloneFloor) == null && elevatorPos != null && 
                    ((getClosest(elevatorPos,clonePos) < clonePos && direction.equals("RIGHT") ||
                            getClosest(elevatorPos,clonePos) > clonePos && direction.equals("LEFT")))) ||
                    (cloneFloor==exitFloor && (clonePos < exitPos && direction.equals("LEFT") ||
                        clonePos >= exitPos && direction.equals("RIGHT")))) {
                            
                System.out.println("BLOCK");
            }
            else {
                System.out.println("WAIT");
            }
        }
    }

    private static int getClosest(List<Integer> elevators, Integer clone) {
        int min = Integer.MAX_VALUE;
        int closest = clone;

        for (Integer v : elevators) {
            final int diff = Math.abs(v - clone);

            if (diff < min) {
                min = diff;
                closest = v;
            }
        }

        return closest;
    }
}