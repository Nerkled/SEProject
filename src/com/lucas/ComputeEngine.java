//Henry Becker
package com.lucas;
import java.util.List;
public interface ComputeEngine{
    String compute(List<Integer> values);

    int getData(int key);

    void putData(int key, String value);

    void shutdown() throws InterruptedException;
}
