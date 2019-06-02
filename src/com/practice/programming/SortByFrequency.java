package com.practice.programming;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortByFrequency {
    public static void main(String[] args) throws IOException {
//        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(5,5,4, 6, 4));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String str = reader.readLine();
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int in : numbers) {
                if (hashMap.containsKey(in))
                    hashMap.put(in, hashMap.get(in) + 1);
                else
                    hashMap.put(in, 1);
            }
            numbers.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (hashMap.get(o1) == hashMap.get(o2))
                        return (-1) * (o1.compareTo(o2));
                    return (-1) * (hashMap.get(o1).compareTo(hashMap.get(o2)));
                }
            });
            System.out.println(numbers);
        }
    }
}
