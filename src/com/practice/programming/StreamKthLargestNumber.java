package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

import static java.util.Collections.max;
import static java.util.Collections.swap;

class MaxHeap {
    public ArrayList<Integer> arrayList;
    public int heapsize;
    public int maxLimit;
    public MaxHeap(ArrayList<Integer> arrayList, int maxLimit) {
       this.arrayList = arrayList;
       this.heapsize = arrayList.size();
       this.maxLimit = maxLimit;
    }
    public int left(int i) {
       return (2*i + 1);
    }

    public int right(int i) {
        return  (2*i + 2);
    }
    public void createMaxHeap() {
       int i = (heapsize - 1 ) / 2;
       while(i >= 0) {
           heapify(i);
           i--;
       }
    }
    public void add(int elt) {
        arrayList.add(elt);
        heapsize = arrayList.size();
        createMaxHeap();

    }
    private void heapify(int i) {
        int largest  = i;
        int l = left(i);
        int r = right(i);
        if(l < heapsize && arrayList.get(l) < arrayList.get(largest))
            largest = l;
        if(r < heapsize && arrayList.get(r) < arrayList.get(largest))
            largest = r;
        if(largest  != i) {
            swap(arrayList,  largest, i);
            heapify(largest);
        }
    }
    public int peekMax() {
        return arrayList.get(0);
    }

    public int poll() {
        int ret = arrayList.get(0);
        arrayList.remove(0);
        heapsize--;
        return ret;
    }

    public String toString() {
        return arrayList.toString();
    }

    public void replaceMin(Integer integer) {
        arrayList.set(0, integer);
        heapify(0);
    }
}
public class StreamKthLargestNumber {
    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(reader.readLine());
//        while (T-- > 0) {
//        ArrayList<String> nk = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
//        int n = Integer.parseInt(nk.get(0));
//        int k = Integer.parseInt(nk.get(1));
//        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
//        ArrayList<Integer> numbers = new ArrayList<>();
//        arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
        ArrayList<Integer> numbers= new ArrayList<>(Arrays.asList(857, 744, 492, 228, 366, 860, 937, 433, 552, 438, 229, 276, 408, 475, 122));
        int k = 3;
        ArrayList<Integer> ans = getKthLargestNum2(numbers, k);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i :ans)
            stringBuffer.append(i + " ");
        System.out.println(stringBuffer);
//        }
    }


    private static ArrayList<Integer> getKthLargestNum2(ArrayList<Integer> numbers, int k) {
        MaxHeap maxHeap;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < k -1; i++) {
            arrayList.add(-1);
            temp.add(numbers.get(i));
        }
        maxHeap = new MaxHeap(temp, k);
        maxHeap.createMaxHeap();
        System.out.println(maxHeap);
        arrayList.add(maxHeap.peekMax());
        for(int i = k; i < numbers.size(); i++) {
            if(numbers.get(i) > maxHeap.peekMax())
                maxHeap.replaceMin(numbers.get(i));
//            maxHeap.add(numbers.get(i));
            arrayList.add(maxHeap.peekMax());
        }
        return arrayList;
    }

    private static ArrayList<Integer> getKthLargestNum(ArrayList<Integer> arrayList, int k) {
        ArrayList<Integer> tempArrayList = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k-1 ; i++) {
            ans.add(-1);
            tempArrayList.add(i);
        }
        tempArrayList.add(k-1);
        for(int j = k ; j < arrayList.size(); j++) {
            while(tempArrayList.get(0) < j) tempArrayList.remove(0);
            tempArrayList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                   return arrayList.get(o1).compareTo(arrayList.get(o2));
                }
            });
            ans.add(arrayList.get(tempArrayList.get(0)));
            tempArrayList.remove(0);
            tempArrayList.add(j);
        }
        return  ans;
    }
}
