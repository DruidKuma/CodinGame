package com.druidkuma.codingame.chucknorris;

import java.util.Scanner;

/**
 * 
 * @author DruidKuma
 *
 */
public class ChuckNorrisEncoding {

	public static void main(String[] args) {
		
		//get data
		Scanner in = new Scanner(System.in);
		char[] message = in.next().toCharArray();
		
		//convert data into binary format
		StringBuilder binary = new StringBuilder();
		for(char c : message) {
			String res = Integer.toBinaryString(c);
			
			//for non-letters
			while(res.length() < 7) res = '0' + res;
			
			binary.append(res);
		}
		
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
