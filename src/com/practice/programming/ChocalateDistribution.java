package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.min;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public class ChocalateDistribution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            int m = Integer.parseInt(reader.readLine());
            System.out.println(getMinDist(numbers, m));
        }
    }

    private static int getMinDist(ArrayList<Integer> arrayList, int m) {
        Collections.sort(arrayList);
        int ans =  Integer.MAX_VALUE, localmin = 0;
        for(int i = 0; i < arrayList.size() - m; i++) {
            localmin = arrayList.get(i + m-1) - arrayList.get(i);
            ans = min(localmin, ans);
            }
        return  ans;
    }

}
