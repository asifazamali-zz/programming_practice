package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RelativeSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String str = reader.readLine();
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> input1 = new ArrayList<>();
            arrayList1.forEach(x -> input1.add(Integer.parseInt(x)));
//        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(2,1,8,3));
//        ArrayList<Integer> input1 = new ArrayList<>(Arrays.asList(2,1,2,5,7,1,9,3,6,8,8));
            ArrayList<Integer> extras = new ArrayList<>();
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int cntr = 0;
            for (int in : numbers) {
                hashMap.put(in, cntr++);
            }
            for (int in : input1) {
                if (!hashMap.containsKey(in)) {
                    hashMap.put(in, cntr++);
                }
            }
            input1.sort((Integer i1, Integer i2) -> hashMap.get(i1).compareTo(hashMap.get(i2)));
            System.out.println(input1);
        }
    }

}
