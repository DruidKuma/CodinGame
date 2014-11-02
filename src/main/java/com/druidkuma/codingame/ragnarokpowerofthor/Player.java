package com.druidkuma.codingame.ragnarokpowerofthor;

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

        //inappropriate titles, mixed up while writing logic (TX if for LX and so on)
        int TX = in.nextInt(); // the X position of the light of power
        int TY = in.nextInt(); // the Y position of the light of power
        int LX = in.nextInt(); // Thor's starting X position
        int LY = in.nextInt(); // Thor's starting Y position
        in.nextLine();

        Queue<String> moves = new LinkedList<String>();
        while(LX != TX || LY != TY) {
            if(LX == TX && TY < LY) {
                LY--;
                moves.add("N");
            }
            else if(TX > LX && TY < LY) {
                LX++;
                LY--;
                moves.add("NE");
            }
            else if(TY == LY && TX > LX) {
                LX++;
                moves.add("E");
            }
            else if(TY > LY && TX > LX) {
                LY++;
                LX++;
                moves.add("SE");
            }
            else if(TX == LX && TY > LY) {
                LY++;
                moves.add("S");
            }
            else if(TX < LX && TY > LY) {
                LX--;
                LY++;
                moves.add("SW");
            }
            else if(TY == LY && TX < LX) {
                LX--;
                moves.add("W");
            }
            else if(TX < LX && TY < LY) {
                LX--;
                LY--;
                moves.add("NW");
            }
        }

        //game loop
        while (true) {
            int E = in.nextInt(); // The level of Thor's remaining energy, representing the number of moves he can still make.
            in.nextLine();

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(moves.poll()); // A single line providing the move to be made: N NE E SE S SW W or NW
        }
    }
}