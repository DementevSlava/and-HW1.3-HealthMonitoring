package com.dementev.healthmonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PressureActivity extends AppCompatActivity {

    Map<Date, Pressure> datePressureMap = new HashMap<>();
    Date measureDate;

    int pUpValue;

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

                TextInputLayout upperLayout = findViewById(R.id.upperLayout);
                TextInputLayout lowLayout = findViewById(R.id.lowLayout);
                TextInputLayout pulseLayout = findViewById(R.id.pulseLayout);

                EditText pUp = PressureActivity.this.findViewById(R.id.inputUpperPressure);
                EditText pDown = PressureActivity.this.findViewById(R.id.inputLowPressure);
                EditText pulse = PressureActivity.this.findViewById(R.id.inputPulse);
                CheckBox tachycardia = PressureActivity.this.findViewById(R.id.checkBox);
                EditText date = PressureActivity.this.findViewById(R.id.inputDate);

                try {
                    pUpValue = Integer.parseInt(pUp.getText().toString());
                } catch (Exception e) {
                    upperLayout.setError(PressureActivity.this.getString(R.string.high_pressure_input));
                }


                int pDownValue = Integer.parseInt(pDown.getText().toString());
                int pulseValue = Integer.parseInt(pulse.getText().toString());

                boolean tachycardiaValue = tachycardia.isChecked();


                SimpleDateFormat sdf = new SimpleDateFormat(PressureActivity.this.getString(R.string.dateFormat));
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
                PressureActivity.this.finish();
            }
        });

    }

}