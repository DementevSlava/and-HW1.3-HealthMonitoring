package com.dementev.healthmonitoring;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Person> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Button mainSaveBtn = findViewById(R.id.mainSaveBtn);
        Button mainPressureBtn = findViewById(R.id.mainPressureBtn);
        Button mainHealthBtn = findViewById(R.id.mainHelthBtn);

        mainSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText personName = findViewById(R.id.inputNameField);
                EditText personAge = findViewById(R.id.inputAgeField);

                String nameValue = personName.getText().toString();
                int ageValue = Integer.parseInt(personAge.getText().toString());

                Person person = new Person(nameValue, ageValue);
                users.add(person);
            }
        });

        mainPressureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

        mainHealthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });
    }
}