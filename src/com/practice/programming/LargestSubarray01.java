package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.lang.Math.max;

public class LargestSubarray01 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0)

        {
            String str = reader.readLine();
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            System.out.println(getLargestSubarray(numbers));
        }

    }
    private static int getLargestSubarray(ArrayList<Integer> input) {
        int ans = 0;
        int summ = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < input.size(); i++) {
            if(input.get(i) == 0)
                summ += -1;
            else
                summ += 1;
            if(hashMap.containsKey(summ)) {
                    ans = max(ans, i - hashMap.get(summ));
            }
            else {
                 if(summ == 0)
                     ans = i+1;
                 hashMap.put(summ, i);
            }
        }
        return ans;
    }

}
