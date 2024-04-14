package com.lucas;

import java.util.List;

public class ImpComputeEngine implements ComputeEngine {
    public String compute(List<Integer> values) {
        return "The result is: " + values.toString();
    }

    @Override
    public String getData(String key) {
        return null;
    }

    @Override
    public void putData(String key, String value) {
    }

    @Override
    public void shutdown() {
    }
}
