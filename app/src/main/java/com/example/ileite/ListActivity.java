package com.example.ileite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ileite.controller.RegisterController;
import com.example.ileite.model.Cow;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private Button addCow;
    private Button back;
    private ListView cowList;
    private TextView avaregeMilk;
    private TextView totalMilk;

    private ArrayList<Cow> dataModels;
    private static ItemAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        addCow = findViewById(R.id.addCowBtn);
        back = findViewById(R.id.backBtn);
        avaregeMilk = findViewById(R.id.avarageMilkView);
        totalMilk = findViewById(R.id.totalMilkView);
        cowList = findViewById(R.id.cowListView);

        dataModels = new ArrayList<>();
        adapter = new ItemAdapter(dataModels, getApplicationContext());
        cowList.setAdapter(adapter);


        setTotalMilk();
        setAvaregeMilk();
        registerEvents();
        queryEvents();

    }

    private void registerEvents() {
        addCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrationActivity = new Intent(ListActivity.this, RegistrationActivity.class);

                startActivity(registrationActivity);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        cowList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent cowActivity = new Intent(ListActivity.this, CowActivity.class);

                cowActivity.putExtra("POSITION", position);
                startActivity(cowActivity);
            }
        });
    }

    private void queryEvents() {
        dataModels.clear();
        RegisterController controller = new RegisterController(ListActivity.this);

        try {
            dataModels.addAll(controller.searchCows());
        } catch (Exception exception) {
            Toast.makeText(ListActivity.this, "não foi possível recuperar eventos para este intervalo",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void setAvaregeMilk() {
        RegisterController controller = new RegisterController(ListActivity.this);
        avaregeMilk.setText(controller.milkAvarege().toString() + " Liters");
    }

    private void setTotalMilk() {
        RegisterController controller = new RegisterController(ListActivity.this);
        totalMilk.setText(controller.totalMilk().toString() + " Liters");
    }
}
