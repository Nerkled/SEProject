package com.lucas2;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.lucas.LucasComputeEngine;
import com.lucas.ComputeEngine;
public class BenchmarkTest {

    @Test
    public void testBenchmarkSlow() {
        long start = System.currentTimeMillis();
        ComputeEngine computeComponent = new LucasComputeEngine("localhost", 5000);
        List<Integer> values = new ArrayList<>();
        values.add(30);
        String val = computeComponent.slowCompute(values);
        Assert.assertEquals("2 1 3 4 7 11 18 29 47 76 123 199 322 521 843 1364 2207 3571 5778 9349 15127 24476 39603 64079 103682 167761 271443 439204 710647 1149851 1860498", val);
        long end = System.currentTimeMillis();
        System.out.println("Time taken for slow benchmark: " + (end - start) + "ms");
    }
    @Test
    public void testBenchmarkFast() {
        long start = System.currentTimeMillis();
        ComputeEngine computeComponent = new LucasComputeEngine("localhost", 5000);
        List<Integer> values = new ArrayList<>();
        values.add(30);
        String val = computeComponent.compute(values);
        Assert.assertEquals("2 1 3 4 7 11 18 29 47 76 123 199 322 521 843 1364 2207 3571 5778 9349 15127 24476 39603 64079 103682 167761 271443 439204 710647 1149851 1860498", val);
        long end = System.currentTimeMillis();
        System.out.println("Time taken for slow benchmark: " + (end - start) + "ms");
    }
}