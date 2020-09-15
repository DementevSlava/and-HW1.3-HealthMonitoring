package com.dementev.healthmonitoring;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Лог MainActivity";
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

                Log.i(TAG, "Ввод персональных данных пациента.");
                if (personName.getText().length() == 0) {
                    nameLayout.setError(MainActivity.this.getString(R.string.name_input));
                    Log.i(TAG, "Не ввели имя");
                } else {
                    nameValue = personName.getText().toString();
                }

                try {
                    if (personAge.getText().length() == 0) {
                        ageLayout.setError(MainActivity.this.getString(R.string.age_input));
                        Log.i(TAG, "Не ввели возраст");
                    } else {
                        ageValue = Integer.parseInt(personAge.getText().toString());
                    }
                } catch (NumberFormatException ex) {
                    Toast.makeText(MainActivity.this, R.string.wrong_format, Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Неверный формат возраста", ex);
                }

                Person person = new Person(nameValue, ageValue);
                users.add(person);
                Log.i(TAG, "Добавление пользователя");
                Toast.makeText(MainActivity.this, R.string.data_saved, Toast.LENGTH_SHORT).show();
            }
        });

        mainPressureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                MainActivity.this.startActivity(intent);
                Log.i(TAG, "Переход к показателям давления");
            }
        });

        mainHealthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HealthActivity.class);
                MainActivity.this.startActivity(intent);
                Log.i(TAG, "Переход к жизненым показателям");
            }
        });
    }
}