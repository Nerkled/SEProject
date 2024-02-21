package com.lucas;

public class LucasComputeEngine implements ComputeEngine {

    @Override
    public String compute(int value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value; i++) {
            result.append(lucas(i)).append(" ");
        }
        return result.toString().trim();
    }

    // Recursive method to compute the nth Lucas number
    private int lucas(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;
        return lucas(n - 1) + lucas(n - 2);
    }
}
