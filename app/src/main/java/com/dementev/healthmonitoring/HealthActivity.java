package com.dementev.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class HealthActivity extends AppCompatActivity {

    List<Health> healthList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        init();
    }

    private void init(){
        Button healthSaveBtn = findViewById(R.id.healthSaveBtn);
        Button healthPressureBtn = findViewById(R.id.healthPressureBtn);
        Button healthMainBtn = findViewById(R.id.healthMainBtn);

        healthSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputLayout weighLayout = findViewById(R.id.weighLayout);
                TextInputLayout stepsLayout = findViewById(R.id.stepsLayout);

                EditText inputWeighField = findViewById(R.id.inputWeighField);
                EditText inputStepField = findViewById(R.id.inputStepField);

                float weight = Float.parseFloat(inputWeighField.getText().toString());
                int steps = Integer.parseInt(inputStepField.getText().toString());

                Health health = new Health(weight, steps);
                healthList.add(health);
            }
        });
        healthPressureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthActivity.this, PressureActivity.class));
            }
        });

        healthMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthActivity.this, MainActivity.class));
            }
        });
    }
}