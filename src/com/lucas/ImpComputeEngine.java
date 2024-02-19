//Henry Becker
package com.lucas;

public class ImpComputeEngine implements ComputeEngine{
    @Override
    public String compute(int value) {
        return "The result is: " + value;
    }
}