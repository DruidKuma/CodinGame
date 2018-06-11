package com.druidkuma.codingame.bracketsextreme;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class BracketsExtreme {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String expression = in.next();

        System.out.println(isValid(expression));
    }

    private static boolean isValid(String expression) {
        expression = expression.replaceAll("\\w", "");
        Stack<Character> parentheses = new Stack<>();
        for (char p : expression.toCharArray()) {
            //if sub-sequence start with closing bracket
            if(parentheses.empty() && p == ')') return false;

            if(parentheses.empty() || "({[".indexOf(p) >= 0) parentheses.push(p);
            else if((p == ')' && parentheses.peek() == '(')
                    || (p == '}' && parentheses.peek() == '{')
                    || (p == ']' && parentheses.peek() == '[')) parentheses.pop();
        }
        return parentheses.empty();
    }
}