package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShow;
    EditText editTextNote;
    RadioButton rbtn1, rbtn2, rbtn3, rbtn4, rbtn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShow = findViewById(R.id.buttonShowList);


        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);
                editTextNote = findViewById(R.id.editTextNote);
                String note = editTextNote.getText().toString();

                // Insert a task
                rbtn1 = findViewById(R.id.radio1);
                if (rbtn1.isChecked()){
                    db.insertNote(""+note, 1);
                }
                rbtn2 = findViewById(R.id.radio2);
                if (rbtn2.isChecked()){
                    db.insertNote(""+note, 2);
                }
                rbtn3 = findViewById(R.id.radio3);
                if (rbtn3.isChecked()){
                    db.insertNote(""+note, 3);
                }
                rbtn4 = findViewById(R.id.radio4);
                if (rbtn4.isChecked()){
                    db.insertNote(""+note, 4);
                }
                rbtn5 = findViewById(R.id.radio5);
                if (rbtn5.isChecked()){
                    db.insertNote(""+note, 5);
                }
                db.close();
                Toast.makeText(MainActivity.this,"Inserted", Toast.LENGTH_LONG).show();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
