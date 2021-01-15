package com.blogspot.riteshcodejava.savethenote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.blogspot.riteshcodejava.savethenote.MyDbHandler.DBHandler;
import com.blogspot.riteshcodejava.savethenote.ShowDataActivity.ShowDataActivity;
import com.blogspot.riteshcodejava.savethenote.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler handler = new DBHandler(getApplicationContext());
             boolean hasInserted =   handler
                     .insertData(mainBinding.TitleEditText.getText().toString(),
                             mainBinding.noteEditText.getText().toString());
            if(hasInserted = true){
                Toast.makeText(MainActivity.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(MainActivity.this, "Failed To Inserted", Toast.LENGTH_SHORT).show();

            }
        });
        mainBinding.viewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,ShowDataActivity.class);
               startActivity(intent);
            }
        });


    }
}