package com.example.mysampleproject;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;

import com.example.mysampleproject.db.ArtistsRecord;
import com.example.mysampleproject.db.ArtistsViewRecord;
import com.example.mysampleproject.db.SampleDBContract.ArtistsView;
import com.robotoworks.mechanoid.db.SQuery;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		ArtistsRecord artist = new ArtistsRecord();
		artist.setName("Imhoff");
		artist.save();
		return true;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Intent intent = new Intent(this, SecondActivity.class);
		List<ArtistsViewRecord> artists = SQuery.newQuery().select(ArtistsView.CONTENT_URI);
		ArrayList<ArtistsViewRecord> artistsArray = new ArrayList<ArtistsViewRecord>();
		artistsArray.addAll(artists);
		intent.putParcelableArrayListExtra("Test", artistsArray);
		startActivity(intent);
		return true;
	}
}
