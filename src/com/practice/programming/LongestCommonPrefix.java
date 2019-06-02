package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) throws IOException {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String str = reader.readLine();
            ArrayList<String> input = new ArrayList<>(Arrays.asList((reader.readLine().split(" "))));

//        ArrayList<String> input = new ArrayList<>(Arrays.asList(("geeksforgeeks geeks geek geezer").split(" ")));
            String minString = input.get(0);
            int minSize = input.get(0).length();
            for (int i = 1; i < input.size(); i++) {
                if (input.get(i).length() < minSize) {
                    minSize = input.get(i).length();
                    minString = input.get(i);
                }
            }
//        System.out.println(minString);
            for (int i = 0; i < input.size(); i++) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int j = 0; j < minString.length(); j++) {
                    if (input.get(i).charAt(j) == minString.charAt(j)) {
                        stringBuffer.append(minString.charAt(j));
                    }
                }
//            System.out.println(stringBuffer);
                minString = stringBuffer.toString();
            }
        }
//        System.out.println(minString);
    }
}
