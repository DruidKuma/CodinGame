package com.druidkuma.codingame.defibrillators;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static double customDoubleParse(String number) {
        number = number.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        in.nextLine();
        String LAT = in.next();
        in.nextLine();
        int N = in.nextInt();
        in.nextLine();

        Double min = null;
        String name = null;
        for (int i = 0; i < N; i++) {
            Defibrillator defibrillator = new Defibrillator(in.nextLine());
            double dist = defibrillator.dist(customDoubleParse(LON),
                                             customDoubleParse(LAT));
            if(min == null || dist < min) {
                min = dist;
                name = defibrillator.name;
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(name);
    }
}

class Defibrillator {

    public String id;
    public String name;
    public String adress;
    public String phone;
    public double lon;
    public double lat;

    public Defibrillator(String params) {
        String[] parsed = params.split("\\;");
        id = parsed[0];
        name = parsed[1];
        adress = parsed[2];
        if(parsed.length >= 6) {
            phone = parsed[3];
        }
        lat = Solution.customDoubleParse(parsed[parsed.length-1]);
        lon = Solution.customDoubleParse(parsed[parsed.length-2]);
    }

    public double dist(double xLon, double xLat) {
        double x = (lon - xLon) * Math.cos((lat + xLat)/2);
        double y = (lat - xLat);
        return Math.sqrt(x*x + y*y) * 6371;
    }
}