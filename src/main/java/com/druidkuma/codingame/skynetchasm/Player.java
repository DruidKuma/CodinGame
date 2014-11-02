package com.druidkuma.codingame.skynetchasm;

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
        int R = in.nextInt(); // the length of the road before the gap.
        in.nextLine();
        int G = in.nextInt(); // the length of the gap.
        in.nextLine();
        int L = in.nextInt(); // the length of the landing platform.
        in.nextLine();

        // game loop
        while (true) {
            int S = in.nextInt(); // the motorbike's speed.
            in.nextLine();
            int X = in.nextInt(); // the position on the road of the motorbike.
            in.nextLine();

            if(X == R - 1) {
                System.out.println("JUMP");
            }
            else if(X > R || S > G + 1) {
                System.out.println("SLOW");
            }
            else if(S < G + 1) {
                System.out.println("SPEED");
            }
            else {
                System.out.println("WAIT");
            }
        }
    }
}