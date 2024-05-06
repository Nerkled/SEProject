package com.lucas2;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.lucas.LucasComputeEngine;
import com.lucas.ComputeEngine;
public class BenchmarkTest {

    @Test
    public void testSlowCompute() {
        ComputeEngine computeEngine = new LucasComputeEngine("localhost", 5000);
        List<Integer> values = new ArrayList<>();
        values.add(10); // Example input size
        String result = computeEngine.slowCompute(values);
        // Assert correctness of the result
        Assert.assertEquals("2 1 3 4 7 11 18 29 47 76 123", result);
    }

    @Test
    public void testCompute() {
        ComputeEngine computeEngine = new LucasComputeEngine("localhost", 5000);
        List<Integer> values = new ArrayList<>();
        values.add(10); // Example input size
        String result = computeEngine.compute(values);
        // Assert correctness of the result
        Assert.assertEquals("2 1 3 4 7 11 18 29 47 76 123", result);
    }

    @Test
    public void testPerformance() {
        ComputeEngine computeEngine = new LucasComputeEngine("localhost", 5000);
        List<Integer> values = new ArrayList<>();
        values.add(25); 
        long start = System.currentTimeMillis();
        computeEngine.compute(values); // fast compute
        long end = System.currentTimeMillis();
        long fastTime = end - start;
        System.out.println("fast time: " + fastTime);
        start = System.currentTimeMillis();
        computeEngine.slowCompute(values); //  fast compute
        end = System.currentTimeMillis();
        long slowTime = end - start;
        System.out.println("slow time: " + slowTime);
        // Assert that the fast version is significantly faster than the slow version
        
        Assert.assertTrue("Fast version should be faster", fastTime < slowTime);
    }
}