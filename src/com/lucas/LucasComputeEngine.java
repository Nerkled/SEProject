package com.lucas;
import java.util.List;

public class LucasComputeEngine implements ComputeEngine {

    @Override
    public String compute(List<Integer> values) {
        StringBuilder result = new StringBuilder();
        for (int value : values) {
            result.append(computeLucasSequence(value)).append("\n");
        }
        return result.toString().trim();
    }
    //overriding the compute method to take in an integer instead of a list of integers
    public String compute(int value) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i<value; i++) {
            result.append(computeLucasSequence(value)).append("\n");
        }
        return result.toString().trim();
    }

    // Recursive method to compute the nth Lucas number
    private String computeLucasSequence(int n) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sequence.append(lucas(i)).append(" ");
        }
        return sequence.toString().trim();
    }

    // Recursive method to compute the nth Lucas number
    private int lucas(int n) {
        if (n == 0) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        return lucas(n - 1) + lucas(n - 2);
    }
}
