package com.practice.programming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LongestDistinctSubstring {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(reader.readLine());
//        while (T-- > 0) {
//            String str = reader.readLine();
//            System.out.println(getDistinctSubs(str));
//        }
        String str = "geeksforgeeks";
        System.out.println(getDistinctSubs(str));
    }

    private static int getDistinctSubs(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxx = 1, start = 0;
        for(int i = 0; i < str.length(); i++){
           if(map.containsKey(str.charAt(i))) {
                  start = Math.max(start, map.get(str.charAt(i)) + 1);
                  map.put(str.charAt(i), i);
                  maxx = Math.max(maxx, i - start+1);
//                  map.put(str.charAt(i), i);
//                maxx = Math.max(maxx, (i - map.get(str.charAt(i))));
           }
           else {
               maxx = Math.max(maxx, i - start +1);
               map.put(str.charAt(i), i);
           }
        }

        return maxx;
    }
}
