package com.dementev.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PressureActivity extends AppCompatActivity {

    Map<Date, Pressure> datePressureMap = new HashMap<>();
    Date measureDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        init();
    }

    private void init(){
        Button pressureSaveBtn = findViewById(R.id.pressureSaveBtn);
        Button pressureMainBtn = findViewById(R.id.pressureMainBtn);



        pressureSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText pUp = findViewById(R.id.inputUpperPressure);
                EditText pDown = findViewById(R.id.inputLowPressure);
                EditText pulse = findViewById(R.id.inputPulse);
                CheckBox tachycardia = findViewById(R.id.checkBox);
                EditText date = findViewById(R.id.inputDate);



                int pUpValue = Integer.parseInt(pUp.getText().toString());
                int pDownValue = Integer.parseInt(pDown.getText().toString());
                int pulseValue = Integer.parseInt(pulse.getText().toString());

                boolean tachycardiaValue = tachycardia.isChecked();


                SimpleDateFormat sdf = new SimpleDateFormat(getString(R.string.dateFormat));
                try {
                    measureDate = sdf.parse(date.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Pressure pressure = new Pressure(pUpValue, pDownValue, pulseValue, tachycardiaValue);
                datePressureMap.put(measureDate, pressure);
            }
        });

        pressureMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}