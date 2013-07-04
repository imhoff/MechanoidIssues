/*
 * Generated by Robotoworks Mechanoid
 */
package com.example.operationexecutor;

import com.robotoworks.mechanoid.ops.OperationProcessor;
import com.robotoworks.mechanoid.ops.OperationService;
import com.robotoworks.mechanoid.ops.OperationServiceConfiguration;

import com.example.operationexecutor.MovieProcessor;

public abstract class AbstractMovieService extends OperationService {
	
	public static final OperationServiceConfiguration CONFIG = new MovieServiceConfiguration();
	
	@Override
	protected OperationProcessor createProcessor() {
		return new MovieProcessor(this);
	}
	
	public AbstractMovieService(boolean enableLogging) {
		super(enableLogging);
	}
}