package com.practice.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SpirallyTraversingMatrix {
    public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
        ArrayList<String> nk = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
        int M = Integer.parseInt(nk.get(0));
        int N = Integer.parseInt(nk.get(1));
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
        ArrayList<Integer> numbers = new ArrayList<>();
        arrayList.forEach(x -> numbers.add(Integer.parseInt(x)));
        printMatrixSpiral(numbers, N, M);

        }
    }

    private static void printMatrixSpiral(ArrayList<Integer> input, int N, int M) {
        boolean leftToRight = true;
        StringBuffer stringBuffer = new StringBuffer();
        int T = 0, L = 0, R = N-1, B = M - 1;
        while(T <= B && L <= R) {
            int j = L;
            //L --> R
            while(j <= R) {
                stringBuffer.append(input.get( T * N +j)+" ");
                j++;
            }
            T++;
            j = T;
            //T --> B
            if(T > B) break;
            while(j <= B) {
                stringBuffer.append(input.get(j * N + R)+" ");
                j++;
            }
            R--;
            j = R;
            //R-->L
            if(R< L) break;
            while(j >= L) {
                stringBuffer.append(input.get(B * N + j)+ " ");
                j--;
            }
            B--;
            j = B;
            if(B < T) break;
            //B-->T
            while(j >= T) {
                stringBuffer.append(input.get(j * N + L)+" ");
                j--;
            }
            L++;

        }
        // for(int i = 0; i < N; i++) {
        //   int j = 0;
        //   if(leftToRight) {
        //       while (j < M){
        //           stringBuffer.append(input.get(i * M + j) + " ");
        //           j++;
        //       }
        //       leftToRight = false;
        //   }
        //   else {
        //       j = M-1;
        //       while(j >=0) {
        //          stringBuffer.append(input.get(i * M + j)+ " ");
        //          j--;
        //      }
        //      leftToRight = true;
        //   }

        // }
        // if(T==B && L== R)
        //     stringBuffer.append(input.get(T * N + R));
        System.out.println(stringBuffer);
    }
}
