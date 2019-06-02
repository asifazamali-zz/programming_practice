package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ParanthesisMatcher {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String str = reader.readLine();
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split("")));
//        ArrayList<String> input = new ArrayList<>(Arrays.asList("{", "}", "[", "{", "(", ")"));
            System.out.println(checkParanthesis(arrayList));
        }
    }

    private static boolean checkParanthesis(ArrayList<String> input) {
        Stack<String> stack = new Stack<>();
        for(String str : input) {
            if(str.equals("{") || str.equals("[") || str.equals("(") )
                stack.push(str);
            if (str.equals("}") || str.equals("]") || str.equals(")")) {
                if(stack.empty())
                    return  false;
                if (str.equals("}") && stack.peek().equals("{")) {
                    stack.pop();
                } else if (str.equals("]") && stack.peek().equals("[")) {
                    stack.pop();
                } else if (str.equals(")") && stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    return false;
                }

            }


        }
        if(!stack.empty())
            return  false;
        return  true;
    }
}
