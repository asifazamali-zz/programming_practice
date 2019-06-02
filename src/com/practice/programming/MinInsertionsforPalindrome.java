package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinInsertionsforPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String str = reader.readLine();
            System.out.println(minInsertions(str, 0, str.length() -1 ));
        }
//        String str = "bbba";
//        System.out.println(minInsertions(str, 0, str.length() -1 ));
    }

    private static int minInsertions(String str, int l, int h) {
        if(l > h) return  Integer.MAX_VALUE;
        if(l == h) return 0;
        if(l == h-1) return (str.charAt(l) == str.charAt(h)? 0: 1);


        return (str.charAt(l) == str.charAt(h) ? minInsertions(str, l +1, h -1) :
                                                 1+ Math.min(minInsertions(str, l, h-1), minInsertions(str,l+1, h)));
    }


}
