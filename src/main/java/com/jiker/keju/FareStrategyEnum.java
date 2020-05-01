package com.jiker.keju;

public enum FareStrategyEnum {
    FARE_STARTING(6),
    MILES_STARTING(2),
    FARE_LARGER_THAN_TWO_KILOMETER(0.8),
    MILES_TOO_LONG(8),
    FARE_PER_MINUTES(0.25),
    FARE_TOO_LONG(0.5);
    private double ratio;

    FareStrategyEnum(double ratio) {
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }
}
