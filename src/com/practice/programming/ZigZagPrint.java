package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Collections.swap;

public class ZigZagPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            getZigzag(numbers);
            StringBuffer stringBuffer = new StringBuffer();
            for (Integer i : numbers) {
                stringBuffer.append(i + " ");
            }
            System.out.println(stringBuffer);
        }
    }

    private static void getZigzag(ArrayList<Integer> arrayList) {
        boolean flag = true;
        for(int i = 1; i < arrayList.size(); i++) {
           if(flag) {
               if(arrayList.get(i) < arrayList.get(i-1))
                   swap(arrayList, i, i - 1);
                flag = false;
           }
           else {
               if(arrayList.get(i) > arrayList.get(i-1))
                   swap(arrayList, i, i-1);
               flag = true;
           }
        }
    }
}
