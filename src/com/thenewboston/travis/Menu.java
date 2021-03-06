package com.thenewboston.travis;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{

	String classes[] = { "StartingPoint", "TextPlay", "Email", "Camera",
			"Data", "GFX", "GFXSurface", "SQLiteExample", "SoundStuff", 
			"Slider", "Tabs", "SimpleBrowser", "Flipper", "SharedPrefs",
			"InternalData", "Accelerate", "HttpExample" , "WeatherXMLParsing" };
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String itemClicked = classes[position];
		try{
			Class ourClass = Class.forName("com.thenewboston.travis." + itemClicked);
			Intent outIntent = new Intent(Menu.this, ourClass);
			startActivity(outIntent);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.aboutUs:
			Intent i = new Intent("com.thenewboston.travis.ABOUT");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent i2 = new Intent("com.thenewboston.travis.PREFS");
			startActivity(i2);
			break;
		case R.id.exit:
			finish();
			break;
		}
		return false;
	}
}
