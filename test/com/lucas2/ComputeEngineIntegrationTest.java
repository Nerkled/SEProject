package com.lucas2;
import com.lucas.Input;
import com.lucas.LucasComputerAPI;
import com.lucas.LucasNumberCalculator;
import com.lucas.StorageToComputeEngineAPI;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@SuppressWarnings("unused")
public class ComputeEngineIntegrationTest {

    @Test
    public void testComputeEngineIntegration() {
        // Set up input values for the test
        InputConfig inputConfig = new InputConfig(Arrays.asList(1, 10, 25));

        // Create in-memory storage implementation
        InMemoryImpStorageToComputeEngine storage = new InMemoryImpStorageToComputeEngine();

        // Create LucasNumberCalculator instance
        LucasComputerAPI lucasCalculator = new LucasNumberCalculator(storage);

        // Execute computation using the LucasNumberCalculator
        lucasCalculator.initialize();
        lucasCalculator.read(inputConfig);
        lucasCalculator.computeLucas(inputConfig);
        lucasCalculator.getResult();
        lucasCalculator.enumResult();
        lucasCalculator.sendResult();

        // Validate the output against the expected result
        OutputConfig expectedOutput = new OutputConfig(Arrays.asList("the expected output should be here"));
        assertEquals(expectedOutput.getStrings(), storage.getInMemoryOutput());
    }
}
