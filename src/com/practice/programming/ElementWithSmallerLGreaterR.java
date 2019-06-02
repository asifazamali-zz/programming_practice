package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.min;
import static java.lang.StrictMath.max;

public class ElementWithSmallerLGreaterR {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            System.out.println(getEltSmallerLLargerR(numbers));
        }

    }
    private static int  getEltSmallerLLargerR(ArrayList<Integer> arrayList) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        left.add(arrayList.get(0));
        right.add(arrayList.get(arrayList.size() - 1));
        for(int i = 1; i < arrayList.size(); i++) {
            left.add(max(left.get(i - 1), arrayList.get(i)));
//            right.add(0, min(right.get(0), arrayList.get(arrayList.size() - i)));
        }

        int right_min = arrayList.get(arrayList.size() - 1);
        for(int i= arrayList.size()-2; i >= 1; i--) {
            if(left.get(i-1) < arrayList.get(i) && right_min> arrayList.get(i))
                return arrayList.get(i);
            else
                right_min = min(right_min, arrayList.get(i));
        }
        return  -1;
    }



}
