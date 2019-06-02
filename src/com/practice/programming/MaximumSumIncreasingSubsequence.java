
package com.practice.programming;

import java.util.*;
import java.lang.*;


public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        //1, 101, 2, 3, 100, 4, 5
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 101, 2, 3, 100, 4, 5));
        System.out.println(getMaximumSum2(numbers));
    }

    private static int getMaximumSum2(List<Integer> numbers) {
        int ans = 0, localSum = 0;
        ArrayList<Integer> summList = new ArrayList<>();
        numbers.forEach(x ->
            summList.add(1));
        for(int i = 0; i < numbers.size(); i++) {
            localSum = numbers.get(i);
            for(int j = 0; j < i; j++) {
                 if(numbers.get(j) < numbers.get(i)) {
//                     summList.set(i, summList.get(i) + 1);
                     localSum += numbers.get(j);
                 }

             }
            ans = localSum;
            summList.set(i, ans);
        }

        return (int) Collections.max(summList);
    }
    private static int getMaximumSum(List<Integer> numbers) {
        numbers.add(0, Integer.MIN_VALUE);
        return getMaximumSumUtil(numbers, 0, Integer.MIN_VALUE, 1, numbers.size());
    }

    private static int getMaximumSumUtil(List<Integer> numbers, int summ, int prevVal, int i, int n) {
       if(i == n) return summ;
       else
           return Math.max((prevVal < numbers.get(i) ? (getMaximumSumUtil(numbers, summ+ numbers.get(i), numbers.get(i),i+1, n)) : summ),
                    getMaximumSumUtil(numbers, summ, prevVal, i+1, n));
    }

}