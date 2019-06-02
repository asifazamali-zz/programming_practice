package com.practice.programming;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class ZizagMatrix {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            ArrayList<String> nk = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            int N = Integer.parseInt(nk.get(0));
            int M = Integer.parseInt(nk.get(1));
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            ArrayList<Integer> numbers = new ArrayList<>();
            arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
            printMatrix(numbers, N, M);

        }
    }

    private static void printMatrix(ArrayList<Integer> input, int N, int M) {
        boolean leftToRight = true;
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < N; i++) {
          int j = 0;
          if(leftToRight) {
              while (j < M){
                  stringBuffer.append(input.get(i * N + j) + " ");
                  j++;
              }
              leftToRight = false;
          }
          else {
              j = M-1;
             while(j >=0) {
                 stringBuffer.append(input.get(i*N + j)+ " ");
                 j--;
             }
             leftToRight = true;
          }

        }
        System.out.println(stringBuffer);
    }
}

