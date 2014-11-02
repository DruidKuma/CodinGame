package com.druidkuma.codingame.mimetype;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Map<String, String> types = new HashMap<String, String>();

        int N = in.nextInt(); // Number of elements which make up the association table.
        in.nextLine();
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        in.nextLine();
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.

            types.put(EXT.toLowerCase(), MT);
            in.nextLine();
        }

        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            if(!FNAME.contains(".") || FNAME.split("\\.").length < 2 || FNAME.charAt(FNAME.length()-1) == '.') {
                System.out.println("UNKNOWN");
            }
            else {
                String[] parsed = FNAME.split("\\.");
                if(!types.containsKey(parsed[parsed.length-1].toLowerCase())) {
                    System.out.println("UNKNOWN");
                }
                else {
                    System.out.println(types.get(parsed[parsed.length-1].toLowerCase()));
                }
            }
        }
    }
}