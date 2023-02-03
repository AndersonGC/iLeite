package com.example.ileite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ileite.controller.RegisterController;

import java.time.LocalDate;

public class RegistrationActivity extends AppCompatActivity {


    private Button back;
    private Button addCow;
    private TextView cowName;
    private Switch isHeifer;
    private TextView age;
    private TextView amountMilk;
    private TextView weight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        back = findViewById(R.id.backBtn);
        addCow = findViewById(R.id.addCowBtn);
        cowName = findViewById(R.id.cowNameView);
        isHeifer = findViewById(R.id.isHeiferView);
        age = findViewById(R.id.ageView);
        amountMilk = findViewById(R.id.amountMilkView);
        weight = findViewById(R.id.weightView);

        registerEvents();
    }

    private void registerEvents() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addCow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerCow();
            }
        });
    }

    private void registerCow() {
        try {
            String cowName = this.cowName.getText().toString();
            int isHeifer = this.isHeifer.isChecked() ? 1 : 0;
            int age = Integer.parseInt(this.age.getText().toString());
            double amountMilk = Double.parseDouble(this.amountMilk.getText().toString());
            double weight = Double.parseDouble(this.weight.getText().toString());
            LocalDate registerDate = LocalDate.now();

            RegisterController controller = new RegisterController(RegistrationActivity.this);

            if (!controller.cowInsert(cowName, isHeifer, age, amountMilk, weight, registerDate)) {
                Toast.makeText(RegistrationActivity.this, "Error!",
                        Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(RegistrationActivity.this, "Cadastro efetuado!",
                    Toast.LENGTH_SHORT).show();

            setResult(RESULT_OK);
            Intent listActivity = new Intent(RegistrationActivity.this, ListActivity.class);

            startActivity(listActivity);

        } catch (Exception exception) {
            Toast.makeText(RegistrationActivity.this, "Verifique se os campos foram preenchidos!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
