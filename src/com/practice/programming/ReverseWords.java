package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.swap;

public class ReverseWords {
    public static void main(String[] args) throws IOException {
         String str1 = "i.like.this.program.very.much";
            String rev = reverse(str1, str1.length());
//            System.out.println(rev);
            String ans = "";
            String temp  = "";
            for(int i = 0; i < rev.length(); i++) {
                if(rev.charAt(i) == '.') {
                    temp = reverse(temp, temp.length());
                    ans += temp + ".";
                    temp = "";
                }
                else
                    temp += rev.charAt(i);


            }
            System.out.println(ans+temp);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(reader.readLine());
//        while (T-- > 0) {
//            String str = reader.readLine();
//
//            ArrayList<String> input = new ArrayList<>(Arrays.asList(str.split("\\.")));
//            System.out.println(getReverseWords(input));
//        }
    }


    public static String reverse(String str, int n) {
        int lo = 0, hi = n-1;
        while(lo < hi) {
            char temp = str.charAt(lo);
            str = str.substring(0, lo) + str.charAt(hi) + str.substring(lo+1, n);
            str = str.substring(0, hi)  + temp+ str.substring(hi+1, n);

            lo++;
            hi--;

        }
        return str;
    }
    private static String getReverseWords(ArrayList<String> input) {
        if(input.size() == 0) return "";
        int lo = 0, hi = input.size()-1;
        while(lo < hi) {
            swap(input, lo, hi);
            lo++;
            hi--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < input.size()-1; i++) {
           stringBuffer.append(input.get(i)+".");
        }
        stringBuffer.append(input.get(input.size()-1));
        return stringBuffer.toString();

    }
}

