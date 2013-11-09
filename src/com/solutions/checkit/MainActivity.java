package com.solutions.checkit;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ArrayList<String> items;
	ArrayAdapter<String> itemsAdapter;
	
	ListView List;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		List = (ListView) findViewById(R.id.List);
		items= new ArrayList<String>();
		itemsAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
		List.setAdapter(itemsAdapter);
		List.setLongClickable(true);
		items.add("Do chores");
		items.add("Watch TV");
		setupListViewListener();
	}

	private void setupListViewListener() {
		List.setOnItemLongClickListener(new OnItemLongClickListener(){
			@Override
			public boolean onItemLongClick(AdapterView<?> a,
					View view, int position, long l)
			{
				items.remove(position);
				itemsAdapter.notifyDataSetChanged();
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void addListItem(View view)
	{
		EditText TextAdd = (EditText)
				findViewById(R.id.TextAdd);
		itemsAdapter.add(TextAdd.getText().toString());
		TextAdd.setText("");
	}

}
