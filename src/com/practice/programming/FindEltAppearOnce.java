package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FindEltAppearOnce {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            System.out.println(getUniqueElt(numbers));
        }

    }

    private static int getUniqueElt(ArrayList<Integer> arrayList) {
        int x = 0;
        for(int i: arrayList) {
            x ^= i;
        }
        return x;
    }

    private  static  int getUniqueElt2(ArrayList<Integer> arrayList) {
       int lo = 0, hi = arrayList.size()-1;
       while(lo < hi) {
           if(lo == hi) return  arrayList.get(lo);
           int mid = (hi - lo) /2 + lo;
           if(mid % 2 == 0) {
               if(arrayList.get(mid) == arrayList.get(mid+1))
                   lo = mid+2;
               else
                   hi = mid;
           }
           else {
               if(arrayList.get(mid) == arrayList.get(mid-1))
                   lo = mid+1;
               else
                   hi = mid-1;
           }
       }
       return -1;
    }
}
