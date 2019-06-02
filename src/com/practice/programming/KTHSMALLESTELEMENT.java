package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Heap{
    ArrayList<Integer> arrayList;
    int heapSize;

    Heap(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
        this.heapSize = arrayList.size();
        System.out.println(arrayList);
    }

    public int getParent(int i) {
        return ((i - 1) / 2);
    }

    public int getLeft(int i) {
        return (i * 2 + 1);
    }

    public int getRight(int i) {
        return (i * 2 + 2);
    }

    public void heapify(int i) {
//        System.out.println(i);
       int smallest = i;
       int left = getLeft(i);
       int right = getRight(i);
       if (left < heapSize && arrayList.get(left) < arrayList.get(smallest))
           smallest = left;
       if(right < heapSize && arrayList.get(right) < arrayList.get(smallest))
           smallest = right;

       if(smallest != i) {
           swap(i, smallest);
           heapify(smallest);
       }

    }
    public void swap(int i, int j) {
        int temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }

    public int getMin() {
        int temp = arrayList.get(0);
        swap(0, heapSize -1 );
        heapSize--;
        heapify(0);
        return  temp;
    }

    public void minHeap() {
        int i = (heapSize /2) -1;
        while( i >= 0) {
            heapify(i);
            i--;
        }
    }

}

public class KTHSMALLESTELEMENT {
    public static void main(String[] args) throws IOException {
//        ArrayList<Integer> list  = new ArrayList<>(Arrays.asList(8, 10, 4, 3, 20, 15));
//        int k = 3;
//        System.out.println(kthSmallestElt(list,k));

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(reader.readLine());
//        while(T-- > 0) {
//            int n = Integer.parseInt(reader.readLine());
//            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
//            arrayList.forEach(x -> list.add(Integer.parseInt(x)));
//            int k = Integer.parseInt(reader.readLine());
//            System.out.println(kthSmallestElt(list,k));
//        }
    }

    private static int kthSmallestElt(ArrayList<Integer> arrayList, int k) {
       Heap heap = new Heap(arrayList);
       heap.minHeap();
       int kminn = -1;
       for(int i = 0; i <k; i++) {
           kminn = heap.getMin();
           System.out.println(kminn);
       }
       return kminn;
    }
}
