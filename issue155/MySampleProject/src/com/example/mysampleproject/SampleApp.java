package com.example.mysampleproject;

import com.robotoworks.mechanoid.Mechanoid;

import android.app.Application;

public class SampleApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Mechanoid.init(this);
	}
}
