package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static jdk.nashorn.internal.objects.NativeMath.min;

public class TrappedWater {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            System.out.println(getTrappedWater2(numbers));
        }
    }

    private static int getTrappedWater(ArrayList<Integer> arrayList) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        Stack<Integer> stackLeft = new Stack<>();
        Stack<Integer> stackRight = new Stack<>();

        int ans = 0;
        left.add(arrayList.get(0));
        right.add(arrayList.size()-1);
        for(int i = 1; i < arrayList.size(); i++) {
            left.add(left.get(i-1), arrayList.get(i));
        }

        for(int i = arrayList.size() -2 ; i >= 0; i--) {
            right.add(right.get(i+1), arrayList.get(i));
        }
        System.out.println(left);
        System.out.println(right);
        for(int i = 1; i < arrayList.size()-1; i++) {
            System.out.printf(arrayList.get(i) + " ");
            ans +=  min(right.get(arrayList.size()-i-1), left.get(i-1)) - arrayList.get(i);
            System.out.println(ans);
        }
        return  ans < 0 ? 0: ans;

    }

    private static int getTrappedWater2(ArrayList<Integer> arrayList) {
       int n = arrayList.size();
       int lo = 0, hi = n-1;
       int leftMax = 0, rightMax = 0;
       int ans = 0;
       while(lo < hi) {
           if(arrayList.get(lo) < arrayList.get(hi)) {
               if(leftMax < arrayList.get(lo))
                   leftMax = arrayList.get(lo);
               else
                    ans += leftMax - arrayList.get(lo);
               lo++;
           }
           else{
               if(rightMax < arrayList.get(hi)) {
                   rightMax = arrayList.get(hi);

               }
               else {
                   ans += rightMax - arrayList.get(hi);
               }
               hi--;
           }
       }
       return ans;
    }
}
