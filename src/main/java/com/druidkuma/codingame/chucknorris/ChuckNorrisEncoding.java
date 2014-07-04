package com.druidkuma.codingame.chucknorris;

import java.util.Scanner;

/**
 * Binary with 0 and 1 is good, but binary with only 0, or almost, is even better! 
 * Originally, this is a concept designed by Chuck Norris to send so called unary messages.
 * 
 * Here is the encoding principle:
 * -The input message consists of ASCII characters (7-bit)
 * -The encoded output message consists of blocks of 0
 * -A block is separated from another block by a space
 * -Two consecutive blocks are used to produce a series of same value bits (only 1s or 0s):
 * 		-First block: it is always 0 or 00. If it is 0, then the series contains 1s, if not, it contains 0s
 * 		-Second block: the number of 0s in this block is the number of bits in the series
 * 
 * Write a program that takes an incoming message as input and displays as output the message encoded 
 * using Chuck Norris’ method.
 * 
 * INPUT:
 * Line 1: the message consisting of N ASCII characters (without carriage return)
 * 
 * OUTPUT:
 * The encoded message
 * 
 * CONSTRAINTS :
 * 0 < N < 100
 * 
 * @author DruidKuma
 * @version 1.0 Build 04.07.2014
 *
 */
public class ChuckNorrisEncoding {

	public static void main(String[] args) {
		
		//get data
		Scanner in = new Scanner(System.in);
		char[] message = in.nextLine().toCharArray();
		
		//convert data into binary format
		StringBuilder binary = new StringBuilder();
		for(char c : message) {
			String res = Integer.toBinaryString(c);
			
			//for non-letters
			while(res.length() < 7) res = '0' + res;
			
			binary.append(res);
		}
		
		//convert to unary and print to console
		int i = 0;
		char currentChar;
		while(i < binary.length()) {
			if(binary.charAt(i) == '0') {
				System.out.print("00 ");
				currentChar = '0';
			}
			else {
				System.out.print("0 ");
				currentChar = '1';
			}
			while(binary.charAt(i) == currentChar) {
				System.out.print("0");
				i++;
				if(i >= binary.length()) break;
			}
			if(i < binary.length()) System.out.print(" ");
		}
		in.close();
	}

}
