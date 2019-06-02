package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFromArray {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String str = reader.readLine();
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            System.out.println(getMaxNumber(numbers));

        }
    }

    private static StringBuffer getMaxNumber(ArrayList<Integer> input) {
        StringBuffer stringBuffer = new StringBuffer();
        input.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (-1)*(o1.toString() + o2.toString()).compareTo(o2.toString() + o1.toString());
            }
        });
        for(int in: input) {
           stringBuffer.append(in);
        }
        return  stringBuffer;
    }
}
