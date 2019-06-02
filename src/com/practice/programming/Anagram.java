package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
//        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String str1 = "geeksforgeeks";
            String str2 = "forgeeksgeeks";
            boolean flag = false;
            HashMap<Character, Integer> hashMap = new HashMap<>();
            if (str1.length() != str2.length())
                System.out.println("NO");
            for (int i = 0; i < str1.length(); i++) {
                if (hashMap.containsKey(str1.charAt(i)))
                    hashMap.put(str1.charAt(i), hashMap.get(str1.charAt(i)) + 1);
                else
                    hashMap.put(str1.charAt(i), 1);
            }
            for (int i = 0; i < str2.length(); i++) {
                if (hashMap.containsKey(str2.charAt(i)) && hashMap.get(str2.charAt(i)) > 0) {
                    hashMap.put(str2.charAt(i), hashMap.get(str2.charAt(i)) - 1);
                } else {
                    flag = true;
                    System.out.println("NO");
                    break;
                }
            }
            if(!flag)
                System.out.println("YES");
        }

    }
}
