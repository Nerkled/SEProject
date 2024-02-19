package com.lucas;

public class UserToComputeEngineImp implements UserToComputeEngineAPI {
	
	private final StorageToComputeEngineAPI datastore;
	private final ComputeEngine computeengine;
	
	public UserToComputeEngineImp(StorageToComputeEngineAPI datastore, ComputeEngine computeengine) {
		this.datastore = datastore;
		this.computeengine = computeengine;
	}

	//@Override
	public ComputeResult compute(ComputeRequest request) {
		return ComputeResult.FAILURE;
	}

}
