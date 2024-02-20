package com.lucas2;
import org.junit.Test;
import com.lucas.ComputeEngine;
import com.lucas.ImpComputeEngine;

// Import  Mockito methods 
import org.junit.Assert;



public class ComputeTest {

	@Test
	public void smokeTestCompute() {
		// The computation component has very simple inputs/outputs and no dependencies, so we can
		// write a smoke test with no mocks at all
		
		ComputeEngine engine = new ImpComputeEngine();
		Assert.assertEquals("1", engine.compute(1));
	}
}