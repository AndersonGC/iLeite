package com.example.ileite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private Button addCow;
    private Button listCow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        addCow = findViewById(R.id.addCowBtn);
        listCow = findViewById(R.id.listCowBtn);


        requestPermissions();
        registerEvents();
    }

    private void registerEvents() {

        addCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrationActivity = new Intent(MainActivity.this, RegistrationActivity.class);

                startActivity(registrationActivity);
            }
        });

        listCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listActivity = new Intent(MainActivity.this, ListActivity.class);

                startActivity(listActivity);
            }
        });

    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,}, 0);
    }
}