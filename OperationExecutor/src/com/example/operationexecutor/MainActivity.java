package com.example.operationexecutor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.robotoworks.mechanoid.ops.OperationExecutor;
import com.robotoworks.mechanoid.ops.OperationExecutorCallbacks;
import com.robotoworks.mechanoid.ops.OperationResult;

public class MainActivity extends Activity {

	private OperationExecutorCallbacks mCallbacks = new OperationExecutorCallbacks() {
		
		@Override
		public void onOperationPending(String key) {
			if (!mOperationExecutor.isPending())
				throw new IllegalStateException("onOperationPending() called but operation not pending");
		}
		
		@Override
		public boolean onOperationComplete(String key, OperationResult result) {
			if (mOperationExecutor.isPending())
				throw new IllegalStateException("onOperationComplete() called but operation still pending");
			return true;
		}
	};
	
	private OperationExecutor mOperationExecutor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mOperationExecutor = new OperationExecutor("Setup", savedInstanceState, mCallbacks);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mOperationExecutor.saveState(outState);
	}
	
	public void onClick(View view) {
		mOperationExecutor.execute(SetupOperation.newIntent(), OperationExecutor.MODE_ALWAYS);
	}
}
