package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
	ArrayList<Note> alNotes;
	ListView lv;
	ArrayAdapter aaRevision;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView
		setContentView(R.layout.activity_second);

		lv = (ListView) this.findViewById(R.id.lv);

		// Create the DBHelper object, passing n the activity's content
		DBHelper db = new DBHelper(SecondActivity.this);
		alNotes = db.getAllNotes();
		db.close();

		aaRevision = new RevisionNotesArrayAdapter(this, R.layout.row, alNotes);
		// Sets the adapter that provides the data and the views to represent the data.
		lv.setAdapter(aaRevision);
	}


}
