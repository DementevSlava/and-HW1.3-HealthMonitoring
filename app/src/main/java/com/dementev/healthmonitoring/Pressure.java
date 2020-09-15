package com.dementev.healthmonitoring;

import java.util.Date;

public class Pressure {
    int highPressure;
    int lowPressure;
    int pulse;
    boolean tachycardia;
    Date date;
    Date time;

    public Pressure(int highPressure, int lowPressure, int pulse, boolean tachycardia, Date date, Date time) {
        this.highPressure = highPressure;
        this.lowPressure = lowPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.date = date;
        this.time = time;
    }
}
