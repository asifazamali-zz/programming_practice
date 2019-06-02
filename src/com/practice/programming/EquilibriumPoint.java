package com.practice.programming;

import sun.rmi.server.InactiveGroupException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquilibriumPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while(T-- > 0) {
           int n = Integer.parseInt(reader.readLine());
           String inp = reader.readLine();
           List<Integer> numbers = new ArrayList<>();
           List<String> input = new ArrayList<>(Arrays.asList(inp.split(" ")));
           input.forEach(x -> numbers.add(Integer.parseInt(x)));
           System.out.println(getEquilibriumPoint(numbers));
        }


    }

    private static int getEquilibriumPoint(List<Integer> input) {
        int summ = 0, valueFromLeft = 0, valueFromRight = -1 ;
        for(int i : input) {
            summ += i;
        }
        for(int i = 0; i < input.size(); i++) {
            int val = input.get(i);
            valueFromLeft += val;
            valueFromRight = summ - valueFromLeft;
            if(valueFromRight == (valueFromLeft- val)) return  i;
        }
        return - 1;
    }
}
