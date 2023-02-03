package com.example.ileite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ileite.controller.RegisterController;
import com.example.ileite.model.Cow;

import java.util.ArrayList;

public class CowActivity extends AppCompatActivity {

    private TextView name;
    private TextView isHeifer;
    private TextView age;
    private TextView amountMilk;
    private TextView weight;
    private Button back;

    private ArrayList<Cow> dataModels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow);

        long positionSelected = getIntent().getIntExtra("POSITION", 0);

        name = findViewById(R.id.cowNameView);
        isHeifer = findViewById(R.id.isHeiferView);
        age = findViewById(R.id.ageView);
        amountMilk = findViewById(R.id.amountMilkView);
        weight = findViewById(R.id.weightView);
        back = findViewById(R.id.backBtn);

        dataModels = new ArrayList<>();

        registerEvents();
        cowUpdate(positionSelected);

    }

    private void cowUpdate(long positionSelected) {
        RegisterController controller = new RegisterController(CowActivity.this);

        try {
            dataModels.addAll(controller.searchCows());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String name = dataModels.get((int) positionSelected).getName();
        Double amountMilk = dataModels.get((int) positionSelected).getAmountMilk();

        if (dataModels.get((int) positionSelected).getIsHeifer() == 1) {
            isHeifer.setText("Yes");
            this.amountMilk.setText("Does not produce");

        } else {
            isHeifer.setText("Not");
            this.amountMilk.setText(amountMilk.toString());
        }

        Double age = Double.valueOf(dataModels.get((int) positionSelected).getAge());
        Double weight = dataModels.get((int) positionSelected).getWeight();


        this.name.setText(name);
        this.age.setText(age.toString());
        this.weight.setText(weight.toString());
    }

    private void registerEvents() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
