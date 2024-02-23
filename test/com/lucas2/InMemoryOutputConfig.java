package com.lucas2;
import java.util.ArrayList;
import java.util.List;
import com.lucas.OutputConfig;

public class InMemoryOutputConfig implements OutputConfig {
    private final List<String> output = new ArrayList<>();

    public List<String> getStrings() {
        return output;
    }
    
}
