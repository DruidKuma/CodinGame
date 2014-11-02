package com.druidkuma.codingame.kirksquestdescent;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 *
 * CONSTRAINTS:
 * 0 ≤ SX ≤ 7
 * 0 < SY ≤ 10
 * 0 ≤ MH ≤ 9
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int SX = in.nextInt();
            int SY = in.nextInt();
            in.nextLine();

            Integer max = null;
            Integer maxPosition = null;

            for (int i = 0; i < 8; i++) {
                int current = in.nextInt();
                if(max == null || max < current) {
                    max = current;
                    maxPosition = i;
                }
                in.nextLine();
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            if(SX == maxPosition) {
                System.out.println("FIRE");
            }
            else {
                System.out.println("HOLD"); // either:  FIRE (ship is firing its phase cannons) or HOLD (ship is not firing).
            }
        }
    }
}