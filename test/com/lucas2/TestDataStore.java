package com.lucas2;
import java.util.Map;
import java.util.HashMap;

public class TestDataStore {
    
    private final Map<String, String> dataStore = new HashMap<>();

    public String getData(String key){
        return dataStore.get(key);
    }

    public void putData(String key, String value){
        dataStore.put(key, value);
    }
    
}
