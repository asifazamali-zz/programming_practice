package com.practice.programming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class DutchFlagProblem {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 0, 2, 0, 1, 1, 0));
        sortTheList(arrayList);
        String abc = "a c a d e";

    }

    private static void sortTheList(ArrayList<Integer> arrayList) {
        int start, mid , end, n = arrayList.size();
        start = 0; end = n-1;
        while(start < n && arrayList.get(start) == 0) start++;
        while(end >= 0 && arrayList.get(end) == 2) end--;
        mid = start;
        while(mid < end){
            if(arrayList.get(mid) == 0){
               swap(arrayList, start, mid);
               start++;
            }
            else if(arrayList.get(mid) == 1){
                mid++;
            }
            else{
                swap(arrayList, mid, end);
                end--;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(int i: arrayList){
            stringBuffer.append(i+" ");
        }
        System.out.println(stringBuffer);
    }

    private static void swap(ArrayList<Integer> arrayList, int start, int mid) {
        int temp = arrayList.get(start);
        arrayList.set(start, arrayList.get(mid));
        arrayList.set(mid, temp);
    }
}
