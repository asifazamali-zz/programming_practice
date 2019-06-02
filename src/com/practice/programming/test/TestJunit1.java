package com.practice.programming.test;

import com.practice.programming.MinStepsInInfiniteGrid;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJunit1 {

    @Test
    public void testMinStepsInInfiniteGrid(){
        List<Integer> X = new ArrayList<>(Arrays.asList(new Integer[] {0, 1, 2, 5}));
        List<Integer> Y = new ArrayList<>(Arrays.asList(new Integer[] {0, 1, 3, 1}));
        System.out.println(MinStepsInInfiniteGrid.minCost(X, Y));
        assertEquals(10, MinStepsInInfiniteGrid.minCost(X, Y));
    }

}
