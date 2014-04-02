package com.senseos.listens;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SStartMenu extends ListActivity{
	public String menu[] = {"Over", "Contact"};
	public String classes[] = {"SOver", "SContact" };
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String local = "com.senseos.listens." + classes[position];
		Class geplandClass;
		try {
			geplandClass = Class.forName(local);
		
			Intent geplandIntent = new Intent(SStartMenu.this, geplandClass);
			startActivity(geplandIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent intent  = new Intent();
		
		setListAdapter(new ArrayAdapter<String>(SStartMenu.this, android.R.layout.simple_list_item_1, menu));
	}

}
