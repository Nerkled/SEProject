package com.lucas2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.lucas.InputConfig;

public class InMemoryInputConfig implements InputConfig{
    //final so it is immutable
    private final List<Integer> inputs = new ArrayList<>();
    public InMemoryInputConfig(int... inputs) {
        for(int i =0; i < inputs.length; i++) {
            this.inputs.add(inputs[i]);
        }
    }
    public InMemoryInputConfig(Collection<Integer> inputs) {
        this.inputs.addAll(inputs);
    }
    public List<Integer> getIntegers() {
        return new ArrayList<>(inputs);
    }
}
