package com.dementev.healthmonitoring;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Начало лога";
    List<Person> users = new ArrayList<>();
    int ageValue;
    String nameValue;


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
                EditText personName = MainActivity.this.findViewById(R.id.inputNameField);
                EditText personAge = MainActivity.this.findViewById(R.id.inputAgeField);

                TextInputLayout nameLayout = findViewById(R.id.nameLayout);
                TextInputLayout ageLayout = findViewById(R.id.ageLayout);

                if (personName.getText().length() == 0) {
                    nameLayout.setError(MainActivity.this.getString(R.string.name_input));
                } else {
                    nameValue = personName.getText().toString();
                }

                try {
                    if (personAge.getText().length() == 0) {
                        ageLayout.setError(MainActivity.this.getString(R.string.age_input));
                    } else {
                        ageValue = Integer.parseInt(personAge.getText().toString());
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Неверный формат", Toast.LENGTH_SHORT).show();
                }

                Person person = new Person(nameValue, ageValue);
                users.add(person);
                Toast.makeText(MainActivity.this, "Данные сохранены", Toast.LENGTH_SHORT).show();
            }
        });

        mainPressureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                MainActivity.this.startActivity(intent);

            }
        });

        mainHealthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HealthActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}