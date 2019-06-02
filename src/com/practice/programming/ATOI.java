package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class ATOI {
    public static void main(String[] args) throws IOException {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String str = reader.readLine();
            System.out.println(getInteger(str));
        }
//        String str1 = "123";
//        String str2 = "21a";
//        System.out.println(getInteger(str1));
    }

    private static int getInteger(String str) {
        int num = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) < '9') {
                num = num * 10 + Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            else
                return  -1;
        }
        return num;
    }
}
