package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LongestCommonSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String str = reader.readLine();
            String str1 = reader.readLine();
            String str2 = reader.readLine();

//       String str1 = "ABCDGH";
//       String str2 = "ACDGHR";

            System.out.println(getCommonMaximumSubstring(str1, str2));
        }
    }

    private static int getCommonMaximumSubstring(String str1, String str2) {

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for(int i = 0; i <= str1.length(); i++ ) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int j = 0;  j <= str2.length(); j++) {
               arrayList.add(0);
            }
            arrayLists.add(arrayList);
        }
        int maxLength = 0;
        for(int i = 1; i <=str1.length(); i++ ) {
            for(int j = 1; j <= str2.length(); j++) {
               if(str1.charAt(i-1) == str2.charAt(j-1)) {
                   arrayLists.get(i).set(j,arrayLists.get(i-1).get(j-1) + 1);
                   maxLength = Math.max(maxLength, arrayLists.get(i).get(j));
               }
            }
        }
        return maxLength;
    }
}
