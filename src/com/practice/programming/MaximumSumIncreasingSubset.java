package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumIncreasingSubset {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(reader.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String input = reader.readLine();
            ArrayList<Integer> numbers = new ArrayList<>();
            ArrayList<String> inputArrayList = new ArrayList<>(Arrays.asList(input.split(" ")));
            inputArrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            System.out.println(getMaximumSum(numbers));
        }


    }

    private static int getMaximumSum(List<Integer> numbers) {
        if(numbers.size() == 0) return 0;
        List<Integer> globalList = new ArrayList<>();
        List<Integer> localList = new ArrayList<>();
        int localSum = 0, globalSum = Integer.MIN_VALUE;
        localSum = numbers.get(0);
        globalSum = localSum;
        localList.add(numbers.get(0));
        for(int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) <= numbers.get(i - 1)) {
                if(globalSum < localSum || ((globalSum == localSum) && globalList.size() < localList.size())) {
                    globalSum = localSum;
                    globalList = localList;
                }
                localSum = 0;
                localList = new ArrayList<>();
            }
            localSum += numbers.get(i);
            localList.add(numbers.get(i));
        }
        if(globalSum < localSum || ((globalSum == localSum) && globalList.size() < localList.size())) {
            globalSum = localSum;
            globalList = localList;
        }
        System.out.println(globalList);
        return globalSum;
    }
}
