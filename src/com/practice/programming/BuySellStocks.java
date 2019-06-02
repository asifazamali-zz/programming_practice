package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BuySellStocks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            ArrayList<Integer> ans = getStockInterval(numbers);
            for(int i= 0; i <ans.size(); i += 2) {
                System.out.printf("(" + ans.get(i) + " " + ans.get(i + 1) + ") ");
            }
            System.out.println();
        }
    }


    private static ArrayList<Integer> getStockInterval(ArrayList<Integer> arrayList) {
        if (arrayList.size() < 2) return null;
        boolean flag = false;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i - 1) < arrayList.get(i)) {
                if (!flag) {
                    ans.add(i - 1);
                    flag = true;
                }
            } else {
                if (flag) {
                    ans.add(i - 1);
                    flag = false;
                }
            }
        }
        if (flag) {
            ans.add(arrayList.size() - 1);
        }

        return ans;
    }

}