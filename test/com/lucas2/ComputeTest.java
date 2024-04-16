package com.lucas2;

import org.junit.jupiter.api.Test;
import com.lucas.ComputeEngine;
import com.lucas.LucasComputeEngine;
import java.util.ArrayList;
import java.util.List;
// Import Mockito methods
import org.junit.Assert;

public class ComputeTest {

    @Test
    public void smokeTestCompute() {
        // The computation component has very simple inputs/outputs and no dependencies, so we can
        // write a smoke test with no mocks at all
        List<Integer> values = new ArrayList<>();
        values.add(1);
        ComputeEngine engine = new LucasComputeEngine("localhost", 0);

        Assert.assertEquals( "2 1", engine.compute(values));

    }
}
