package com.dementev.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class HealthActivity extends AppCompatActivity {
    private static final String TAG = "Лог HealthActivity";
    List<Health> healthList = new ArrayList<>();
    float weight;
    int steps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        init();
    }

    private void init(){
        Button healthSaveBtn = findViewById(R.id.healthSaveBtn);

        Button healthMainBtn = findViewById(R.id.healthMainBtn);

        healthSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputLayout weighLayout = HealthActivity.this.findViewById(R.id.weighLayout);
                TextInputLayout stepsLayout = HealthActivity.this.findViewById(R.id.stepsLayout);

                EditText inputWeighField = HealthActivity.this.findViewById(R.id.inputWeighField);
                EditText inputStepField = HealthActivity.this.findViewById(R.id.inputStepField);
                Log.i(TAG, "Ввод данных давления");

                try {
                    weight = Float.parseFloat(inputWeighField.getText().toString());
                } catch (NumberFormatException ex) {
                    weighLayout.setError(getString(R.string.weight_input));
                    Log.e(TAG, "Неверный формат Веса", ex);
                }

                try {
                    steps = Integer.parseInt(inputStepField.getText().toString());
                } catch (NumberFormatException ex){
                    stepsLayout.setError(getString(R.string.steps_input));
                    Log.e(TAG, "Неверный формат шаги", ex);
                }

                Health health = new Health(weight, steps);
                healthList.add(health);

                Log.i(TAG, "Добавление данных");

                Toast.makeText(HealthActivity.this, R.string.data_saved, Toast.LENGTH_SHORT).show();
            }
        });


        healthMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HealthActivity.this.finish();
                Log.i(TAG, "Возврат на главную страницу");
            }
        });
    }
}