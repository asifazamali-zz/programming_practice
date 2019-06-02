package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiinNumberofPlatforms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String input = reader.readLine();
            ArrayList<Integer> arrival = new ArrayList<>();
            ArrayList<Integer> departure = new ArrayList<>();
            ArrayList<String> inputArrayList = new ArrayList<>(Arrays.asList(input.split(" ")));
            ArrayList<String> deptArrayList = new ArrayList<>(Arrays.asList(input.split(" ")));
            inputArrayList.forEach(x -> arrival.add(Integer.parseInt(x)));
            deptArrayList.forEach(x -> departure.add(Integer.parseInt(x)));
            System.out.println(getMinPlatform(arrival, departure));

        }
    }


    private static int getMinPlatform(List<Integer> arrival, List<Integer> departure) {
        int count = 0, maxx = 0;
        int i = 0, j = 0;
        while(i < arrival.size()) {
            if(arrival.get(i) < departure.get(j)) {
                i++;
                count++;
                if(maxx < count) maxx = count;
            }
            else if(arrival.get(i) == departure.get(j)){
                i++;
                j++;
            }
            else {
                j++;
                count--;
            }
        }
        return maxx;
    }
}
