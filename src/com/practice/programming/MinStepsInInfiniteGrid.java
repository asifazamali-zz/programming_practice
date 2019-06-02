package com.practice.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class MinStepsInInfiniteGrid {


    public static void main(String[] args) {
        List<Integer> X = new ArrayList<>(Arrays.asList(new Integer[] {0, 1, 2, 5}));
        List<Integer> Y = new ArrayList<>(Arrays.asList(new Integer[] {0, 1, 3, 1}));

        System.out.println(minCost(X, Y));

    }

    public static int minCost(List<Integer> x, List<Integer> y) {
        int i , n = x.size();
        int minCost = 0;
        for(i = 0; i < n-1; i++) {
           int diffX = abs(x.get(i+1) - x.get(i));
           int diffY = abs(y.get(i+1) - y.get(i));
           if(diffX < diffY){
              minCost += diffX;
              minCost += abs(y.get(i+1) - (y.get(i) + (x.get(i+1) - x.get(i))));
           }
           else{
              minCost += diffY;
              minCost += abs(x.get(i+1) - (x.get(i) + (y.get(i+1) - y.get(i))));
           }
        }
        return minCost;
    }
}
