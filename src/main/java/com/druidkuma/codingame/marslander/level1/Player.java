package com.druidkuma.codingame.marslander.level1;

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
        int N = in.nextInt(); // the number of points used to draw the surface of Mars.
        in.nextLine();

        int LAND_X = 0;
        int LAND_Y = 0;
        for (int i = 0; i < N; i++) {
            LAND_X = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            LAND_Y = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            in.nextLine();
        }

        // game loop
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int HS = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int VS = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int F = in.nextInt(); // the quantity of remaining fuel in liters.
            int R = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int P = in.nextInt(); // the thrust power (0 to 4).
            in.nextLine();

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            if(VS < 0 && Y < LAND_Y+1250) {
                P = P+1;
                if(P > 4) P = 4;
                System.out.println("0 " + P);
            }
            else {
                P = P - 1;
                if(P < 0) P = 0;
                System.out.println("0 " + P);
            }
        }
    }
}