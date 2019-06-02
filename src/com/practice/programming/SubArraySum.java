package com.practice.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static void main(String[] args) {
        int[] arr = {5 , 7, 2, 9, 3, 2, 8, 7};
        int summ = 16;
        System.out.println(isSubarray(arr, summ));
    }

    private static ArrayList<Integer> isSubarray(int[] arr, int summ) {
        Map<Integer, Integer> map = new HashMap<>();
        int tempSum = 0;
        for(int i = 0; i < arr.length; i++){
           if(map.containsKey(summ - arr[i]))
               return (new ArrayList<>(Arrays.asList(map.get(summ - arr[i]), i)));
           map.put(tempSum + arr[i], i);
        }
        return (new ArrayList<>(Arrays.asList(-1, -1)));
    }
}
