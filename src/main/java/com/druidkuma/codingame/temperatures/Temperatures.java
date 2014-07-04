package com.druidkuma.codingame.temperatures;

import java.util.*;

/**
 * In this exercise, you have to analyze records of temperature to find the closest to zero.
 * Write a program that prints the temperature closest to 0 among input data
 * 
 * INPUT:
 * Line 1: N, the number of temperatures to analyze
 * Line 2: The N temperatures expressed as integers ranging from -273 to 5526
 * 
 * OUTPUT:
 * Display 0 (zero) if no temperature is provided
 * Otherwise, display the temperature closest to 0, knowing that if two numbers are equally close to zero, 
 * positive integer has to be considered closest to zero (for instance, if the temperatures are -5 to 5, then display 5)
 * 
 * CONSTRAINTS:
 * 0 ≤ N < 10000
 * 
 * @author DruidKuma
 * @version 1.0 Build 4.07.2014
 *
 */
public class Temperatures {

	public static void main(String[] args) {
		
		//standard input
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		//if no temperatures provided
		if(n <= 0) {
			System.out.println(0); 
			in.close();
			return;
		}
		
		//find the closest number to the zero
		Integer closest = null;
		for(int i = 0; i < n; i++) {
			int current = in.nextInt();
			if(closest == null || Math.abs(closest) > Math.abs(current) 
					|| Math.abs(closest) == Math.abs(current) && closest < current) closest = current;
		}
		System.out.println(closest);
		in.close();
	}

}
