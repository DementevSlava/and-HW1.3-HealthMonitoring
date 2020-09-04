package com.dementev.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Person> userDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        Button mainBtnSave = findViewById(R.id.mainBtnSave);
        Button pressureBtn = findViewById(R.id.pressureBtn);
        Button healthBtn = findViewById(R.id.healthBtn);

        mainBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.personName);
                EditText age = findViewById(R.id.age);

                String personName = name.getText().toString();
                int personAge = Integer.parseInt(age.getText().toString());
                Person person = new Person(personName, personAge);
                userDataList.add(person);
            }
        });

        pressureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

        healthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HealthActivity.class));
            }
        });
    }
}