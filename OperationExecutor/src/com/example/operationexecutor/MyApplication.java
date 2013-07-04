package com.example.operationexecutor;

import android.app.Application;

import com.robotoworks.mechanoid.Mechanoid;

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		Mechanoid.init(getApplicationContext());
		super.onCreate();
	}
}
