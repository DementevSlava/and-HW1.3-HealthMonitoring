package com.dementev.healthmonitoring;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PressureActivity extends AppCompatActivity {
    private static final String TAG = "Лог PressureActivity";
    Map<Date, Pressure> datePressureMap = new HashMap<>();
    Date measureDate;
    Date measureTime;
    int pUpValue;
    int pDownValue;
    int pulseValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);

        init();
    }

    private void init() {
        Button pressureSaveBtn = findViewById(R.id.pressureSaveBtn);
        Button pressureMainBtn = findViewById(R.id.pressureMainBtn);


        pressureSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextInputLayout upperLayout = findViewById(R.id.upperLayout);
                TextInputLayout lowLayout = findViewById(R.id.lowLayout);
                TextInputLayout pulseLayout = findViewById(R.id.pulseLayout);

                EditText pUp = findViewById(R.id.inputUpperPressure);
                EditText pDown = findViewById(R.id.inputLowPressure);
                EditText pulse = findViewById(R.id.inputPulse);
                CheckBox tachycardia = findViewById(R.id.checkBox);
                EditText date = findViewById(R.id.inputDate);
                EditText time = findViewById(R.id.inputTime);

                Log.i(TAG, "Ввод данных давления");
                try {
                    pUpValue = Integer.parseInt(pUp.getText().toString());
                } catch (NumberFormatException ex) {
                    upperLayout.setError(getString(R.string.high_pressure_input));
                    Log.e(TAG, "Неверный формат Верхнее давление", ex);
                }

                try {
                    pDownValue = Integer.parseInt(pDown.getText().toString());
                } catch (NumberFormatException ex) {
                    lowLayout.setError(getString(R.string.low_pressure_input));
                    Log.e(TAG, "Неверный формат Нижнее давление", ex);
                }

                try {
                    pulseValue = Integer.parseInt(pulse.getText().toString());
                } catch (NumberFormatException ex) {
                    pulseLayout.setError(getString(R.string.pulse_input));
                    Log.e(TAG, "Неверный формат пульс", ex);
                }


                boolean tachycardiaValue = tachycardia.isChecked();


                SimpleDateFormat sdf = new SimpleDateFormat(PressureActivity.this.getString(R.string.dateFormat));
                SimpleDateFormat stf = new SimpleDateFormat(PressureActivity.this.getString(R.string.timeFormat));
                try {
                    measureDate = sdf.parse(date.getText().toString());
                    measureTime = stf.parse(time.getText().toString());

                } catch (ParseException ex) {
                    ex.printStackTrace();
                    Log.e(TAG, "Неверный формат даты и время", ex);
                }

                Pressure pressure = new Pressure(pUpValue, pDownValue, pulseValue, tachycardiaValue, measureDate, measureTime);
                datePressureMap.put(measureDate, pressure);
                Log.i(TAG, "Добавление данных");

                Toast.makeText(PressureActivity.this, R.string.data_saved, Toast.LENGTH_SHORT).show();
            }
        });

        pressureMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PressureActivity.this.finish();
                Log.i(TAG, "Возврат на главную страницу");
            }
        });

    }

}