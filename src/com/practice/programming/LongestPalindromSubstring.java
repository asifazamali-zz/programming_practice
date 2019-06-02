package com.practice.programming;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LongestPalindromSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String str = reader.readLine();
            System.out.println(getLongestPalindrome2(str));
        }
    }

    private static String getLongestPalindrome2(String str) {
        ArrayList<ArrayList<Boolean>> arrayLists = new ArrayList<>();
        int maxLen = 1;
        int start = 0;
        for(int i = 0; i <= str.length(); i++) {
            ArrayList<Boolean> arrayList = new ArrayList<>();
            for(int j = 0; j <= str.length(); j++) {
                arrayList.add(false);
            }
            arrayLists.add(arrayList);
        }

        for(int i = 1; i < arrayLists.size(); i++) {
           arrayLists.get(i).set(i, true);
        }

        for(int j = 0; j <str.length()-1; j++) {
            if(str.charAt(j) == str.charAt(j+1)) {
                arrayLists.get(j + 1).set(j + 2, true);
                maxLen = 2;
                start = j;
            }
        }
//        printArrayLists(arrayLists);

        for(int k = 3; k <= str.length(); k++) {
            for(int i = 1; i <= arrayLists.size() - k; i++){
                int j = i + k -1;
                if(arrayLists.get(i+1).get(j-1) && str.charAt(i-1) == str.charAt(j-1)) {
                    arrayLists.get(i).set(j, true);
                    maxLen = k;
                    start = i-1;
                }
            }
        }
        return str.substring(start, start + maxLen-1);



    }

    private static void printArrayLists(ArrayList<ArrayList<Boolean>> arrayLists) {
        for(int i = 0; i < arrayLists.size();i++)
            System.out.println(arrayLists.get(i));
        System.out.println();
    }

    private static String getLongestPalindrome(String str) {
        String ans = "";
        int start = 0;
        ArrayList<ArrayList<Boolean>> arrayLists = new ArrayList<>();
//        ArrayListfor(int i = 0; i <= str.length(); i++) {
//            ArrayList<Boolean> arrayList = new ArrayList<>();
//            for(int j= 0; j <= str.length(); j++){
//               arrayList.add(false);
//            }
//            arrayLists.add(arrayList);
//        }


        for(int i = 1; i < arrayLists.size(); i++) {
           arrayLists.get(i).set(i, true);
        }
        for(int i = 1; i < arrayLists.size()-1; i++) {
            if(str.charAt(i-1) == str.charAt(i)) {
                arrayLists.get(i).set(i+1, true);
                start = i;
            }
        }


        int maxLength = 1;

        for(int k = 3; k < arrayLists.size(); k++) {
            for(int i = 0; i < arrayLists.size()-k; i++) {
                int j = i + k -1;
                if(arrayLists.get(i+1).get(j-1) == true && str.charAt(i) == str.charAt(j)) {
                    arrayLists.get(i).set(k,true);
                    maxLength = k;
                    start = i;
                }
            }
        }
//        System.out.println(start + " "+ maxLength);
        if(start >= 0) {
            ans = str.substring(start,  start + maxLength );
        }
        return ans;
    }
}
