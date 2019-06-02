package com.practice.programming;

import java.util.ArrayList;

public class KMPSearchAlgorithm {
    public static void main(String[] args) {
        String str = "AAAAAABAAAAAAAAAAB";
        String pat = "AAAAB";
        //lps         01230
        System.out.println(getPatterMatch(str, pat));
    }

    private static int getPatterMatch(String str, String pat) {
        int[]  lps = new int[pat.length()];
        computeLps(lps, pat);
        for(int i = 0; i < lps.length; i++)
            System.out.println(lps[i]);
        int i = 0;
        int j = 0;
        while(i < str.length()) {
//            System.out.println(str.charAt(i) +" "+str.charAt(j));
            if(str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == pat.length()) //pattern found
                return i-pat.length();
            else if(i < str.length() && str.charAt(i) != pat.charAt(j)){
//            System.out.println(str.charAt(i) +" "+str.charAt(j));
                    if (j == 0) {
                        i++;
                    } else
                        j = lps[j - 1];
            }
        }


        return -1;
    }



    private static void computeLps(int[] lps, String pat) {
        int i = 1;
        int len = 0;
        lps[0] = 0;
        while(i < pat.length()) {
            if(pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len == 0) {
                    ///AAAACBAAAA
                    // 0123
                    lps[i] = 0;
                    i++;
                }
                else
                    len = lps[len-1];
            }
        }
    }
}
