package com.druidkuma.codingame.asciichart;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * In stations and airports you often see this type of screen. Have you ever asked yourself how it might be possible to simulate this display on a good old terminal? We have: with ASCII art!
 * 
 * ASCII art allows you to represent forms by using characters. To be precise, in our case, these forms are words. For example, the word "MANHATTAN" could be displayed as follows in ASCII art:
 * # #  #  ### # #  #  ### ###  #  ###
 * ### # # # # # # # #  #   #  # # # #
 * ### ### # # ### ###  #   #  ### # #
 * # # # # # # # # # #  #   #  # # # #
 * # # # # # # # # # #  #   #  # # # #
 * ​Your mission is to write a program that can display a line of text in ASCII art.
 * 
 * INPUT:
 * Line 1: the width L of a letter represented in ASCII art. All letters are the same width.
 * Line 2: the height H of a letter represented in ASCII art. All letters are the same height.
 * Line 3: The line of text T, composed of N ASCII characters.
 * Following Lines: the string of characters ABCDEFGHIJKLMNOPQRSTUVWXYZ? Represented in ASCII art.
 * 
 * OUTPUT:
 * The text T in ASCII art.
 * The characters a to z are shown in ASCII art by their equivalent in upper case.
 * The characters which are not in the intervals [a-z] or [A-Z] will be shown as a question mark in ASCII art.
 * 
 * CONSTRAINTS :
 * 0 < L < 30
 * 0 < H < 30
 * 0 < N < 200
 * 
 * @author DruidKuma
 * @version 1.0 Build 04.07.2014
 *
 */
public class AsciiChart {
	
	static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";

	public static void main(String[] args) {
		
		//getting the data using standard input
		Scanner in = new Scanner(System.in);
		int width = in.nextInt();
		in.nextLine();
		int height = in.nextInt();
		in.nextLine();
		String text= in.nextLine().toUpperCase();
		ArrayList<String> ascii = new ArrayList<String>();
		for(int i = 0; i < height; i++) {
			ascii.add(in.nextLine());
		}
		
		/* === Code for testing ===
		ascii.add(" #  ##   ## ##  ### ###  ## # # ###  ## # # #   # # ###  #  ##   #  ##   ## ### # # # # # # # # # # ### ###  ");
		ascii.add("# # # # #   # # #   #   #   # #  #    # # # #   ### # # # # # # # # # # #    #  # # # # # # # # # #   #   #  ");
		ascii.add("### ##  #   # # ##  ##  # # ###  #    # ##  #   ### # # # # ##  # # ##   #   #  # # # # ###  #   #   #   ##  ");
		ascii.add("# # # # #   # # #   #   # # # #  #  # # # # #   # # # # # # #    ## # #   #  #  # # # # ### # #  #  #        ");
		ascii.add("# # ##   ## ##  ### #    ## # # ###  #  # # ### # # # #  #  #     # # # ##   #  ###  #  # # # #  #  ###  #  ");
		*/
		
		//find the necessary indexes of letters
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for(char c : text.toCharArray()) {
			if(c < 'A' || c > 'Z') indexes.add(26);
			else {
				for(char letter : alphabet.toCharArray()) {
					if(c == letter) {
						indexes.add(alphabet.indexOf(letter));
					}
				}
			}
		}
		
		//print result
		for(int j = 0; j < height; j++) {
			for(int k = 0; k < indexes.size(); k++) {
				System.out.print(ascii.get(j).substring(indexes.get(k)*width, indexes.get(k)*width + width));
			}
			System.out.println();
		}
		in.close();
	}

}
