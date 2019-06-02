package com.practice.programming;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextLarger {
    private  static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException{
        //4 2 3 1 4 5 6
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0){
           int n = Integer.parseInt(bufferedReader.readLine());
           String[] inputs = bufferedReader.readLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for (String arg: inputs) {
                pushNum(Integer.parseInt(arg));
            }
            while(!stack.isEmpty()){
                System.out.printf("-1 ");
                stack.pop();
            }
        }

    }


    private static void pushNum(int n){
        if(stack.isEmpty()) {
            stack.push(n);
            return;
        }
        while (!stack.isEmpty() && stack.peek()< n) {
            System.out.printf(n + " ");
            stack.pop();
         }
         stack.push(n);
    }

}
