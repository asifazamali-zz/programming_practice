package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CheckPythagoreanTriplet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            System.out.println(checkPythagoreanTriplet(numbers));
        }
    }

    private static boolean checkPythagoreanTriplet(ArrayList<Integer> arrayList) {
       ArrayList<Integer> arrayListSquared = new ArrayList<>();
       arrayList.forEach( x-> arrayListSquared.add(x*x));
       Collections.sort(arrayListSquared);
       for(int i = arrayListSquared.size() -1 ; i >= 1; i--) {
           if(checkSumPresent(arrayListSquared, 0, i-1, arrayListSquared.get(i)))
               return true;
       }
       return false;
    }

    private static boolean checkSumPresent(ArrayList<Integer> arrayListSquared, int i, int n, int summ) {
       int rangeSum = 0;
       while(i < n) {
           rangeSum = arrayListSquared.get(i) + arrayListSquared.get(n);
           if (rangeSum == summ)
               return true;
           if (rangeSum < summ) i++;
           else
               n--;
       }
       return true;
    }
}
