package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) throws IOException {
        String str = "geeeeeeeeksforgeeeeeks";
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(reader.readLine());
//        while (T-- > 0) {
//            String str = reader.readLine();
//            System.out.println(removeDups(str));
//        }
        System.out.println(removeDups(str));

    }

    private static String removeDups(String str) {
        int[] arr = new int[256];
        int k = 0;
        int n = str.length();
        boolean dupFlag = false;
        for(int i = 0; i < n-1 ;i++) {
            char c = str.charAt(i);
            int j = c;
//            System.out.println(c + " "+ j);

//            System.out.println(str);
            if(arr[j] == 0)
            {
                arr[j]++;
                if(dupFlag) {
                    str = str.substring(0, k) + c + str.substring(k+1);
//                    dupFlag = false;
//                    k=i;

                }
                else
                    str = str.substring(0, k) + c + str.substring(i+1);
                k++;
            }
            else {
                dupFlag = true;
//                str = str.substring(0, k) + c + str.substring(i);
            }
//            System.out.println(str);
        }
        return str.substring(0, k);
    }
}
