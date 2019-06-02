package com.practice.programming;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinInAWindow {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(reader.readLine());
        while(T-- > 0) {
            ArrayList<String> nw= new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            int n = Integer.parseInt(nw.get(0));
            int w = Integer.parseInt(nw.get(1));
            String input = reader.readLine();
            ArrayList<Integer> numbers = new ArrayList<>();
            ArrayList<String> inputArrayList = new ArrayList<>(Arrays.asList(input.split(" ")));
            inputArrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            System.out.println(getMinWindow(numbers, w));
        }
    }

    private static ArrayList<Integer> getMinWindow(List<Integer> numbers, int w) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < w; i++) {
           while(!deque.isEmpty() && numbers.get(deque.getLast()) < numbers.get(i)) {
               deque.removeLast();
           }
           deque.addLast(i);
        }

        for(int i = w; i < numbers.size(); i++) {
           arrayList.add(numbers.get(deque.getFirst()));
           while(!deque.isEmpty() && deque.getFirst() <= (i-w))
               deque.removeFirst();
           while(!deque.isEmpty() && numbers.get(deque.getLast())< numbers.get(i)) {
               deque.removeLast();
           }
           deque.addLast(i);
        }
        arrayList.add(numbers.get(deque.getFirst()));
        return arrayList;
    }
}
