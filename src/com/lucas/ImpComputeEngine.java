//Henry Becker
package com.lucas;
import java.util.List;
public class ImpComputeEngine implements ComputeEngine{
    public String compute(List<Integer> values) {
        return "The result is: " + values.toString();
    }
}