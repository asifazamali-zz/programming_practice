package com.practice.programming;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LeaderInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<String> arrayList  = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            Stack<Integer> ans = getLeaders(numbers);
            if(Objects.isNull(ans)) System.out.println();
                while(!ans.empty()) {
                    System.out.printf(ans.pop()+" ");
                }
        }
    }

    private static Stack<Integer> getLeaders(List<Integer> list) {
        if(list.size() == 0) return null;
        Stack<Integer> stack= new Stack<>();
        stack.push(list.get(list.size() - 1));
        for(int i = list.size() -2 ; i >= 0; i--) {
           if(list.get(i) >= stack.peek()) {
               stack.push(list.get(i));
           }
        }
        return stack;
    }
}
