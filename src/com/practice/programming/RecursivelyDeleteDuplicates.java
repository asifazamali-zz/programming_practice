package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RecursivelyDeleteDuplicates {
    public static void main(String[] args) throws IOException {
            String str = "mississipie";
            System.out.println(getStringWithoutDup2(str));

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(reader.readLine());
//        while (T-- > 0) {
//            String str = reader.readLine();
//
//            System.out.println(getStringWithoutDup(str));
//        }
    }

    private static String getStringWithoutDup2(String str) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> delStack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {

        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.empty()) stringBuilder.insert(0, stack.pop());
        return stringBuilder.toString();
    }

    private static String getStringWithoutDup(String str) {
        Stack<Character> stack = new Stack<>();
        boolean popFlag = false;
        for(int i = 0; i < str.length(); i++ ){
            if(stack.empty()) {
                stack.push(str.charAt(i));
            }
            else {
               if(popFlag && stack.peek() != str.charAt(i)) {
                   stack.pop();
                   popFlag = false;
               }
               if(!stack.empty() && stack.peek() == str.charAt(i)) {
                   popFlag = true;
               }
               else {
                   stack.push(str.charAt(i));
               }
            }

        }
        if(popFlag && !stack.empty())
            stack.pop();

        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop());
        }
        return stringBuilder.toString();
    }
}
