package com.dementev.healthmonitoring;

public class Pressure {
    int highPressure;
    int lowPressure;
    int pulse;
    boolean tachycardia;

    public Pressure(int highPressure, int lowPressure, int pulse, boolean tachycardia) {
        this.highPressure = highPressure;
        this.lowPressure = lowPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
    }
}
