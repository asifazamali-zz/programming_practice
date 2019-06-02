package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class PermutationsOfString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String str = reader.readLine();
            ArrayList<String> arrayList;
            arrayList = getPermutation(str);
            arrayList.forEach(x -> System.out.printf(x + " "));
            System.out.println();
        }

    }
    private static ArrayList<String> getPermutation(String str) {
        String  temp = "";
        Set<String> treeSet = new TreeSet<>();
        ArrayList<String> arrayList = new ArrayList<>();
        permutationUtil(temp, str, treeSet);
//        System.out.println(treeSet);
        for(String str1: treeSet)
            arrayList.add(str1);
        return  arrayList;
    }

    private static void permutationUtil(String temp, String str, Set<String> treeSet) {
        if(str.length() == 0)
            treeSet.add(temp);

        for(int i = 0; i < str.length(); i++) {
            temp += str.charAt(i);
            permutationUtil(temp, str.substring(0, i) + str.substring(i+1, str.length()), treeSet);
            temp = temp.substring(0, temp.length()-1);
        }
    }
}
