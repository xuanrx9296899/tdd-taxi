package com.jiker.keju;

import org.junit.Assert;
import org.junit.Test;

public class TaxiFareTest {

    /**
     * 只有起步费
     * 6
     */
    @Test
    public void should_given_starting_fare() {
        TaxiFare taxiFare = new TaxiFare();
        int fare = taxiFare.calculationFare(2, 0);
        Assert.assertEquals(6, fare);
    }

    /**
     * 起步费,和3分钟等待费，6+（3*0.25）
     * 7
     */
    @Test
    public void should_given_starting_fare_and_waiting_fare() {
        TaxiFare taxiFare = new TaxiFare();
        int fare = taxiFare.calculationFare(2, 3);
        Assert.assertEquals(7, fare);
    }

    /**
     * 5公里 6+（5-2）*0.8
     * 8
     */
    @Test
    public void should_given_starting_fare_and_over_fare() {
        TaxiFare taxiFare = new TaxiFare();
        int fare = taxiFare.calculationFare(5, 0);
        Assert.assertEquals(8, fare);
    }

    /**
     * 6公里 和10分钟等待 6+（6-2）*0.8+10*0.25
     * 12
     */
    @Test
    public void should_given_starting_fare_and_over_fare_and_waiting_fare() {
        TaxiFare taxiFare = new TaxiFare();
        int fare = taxiFare.calculationFare(6, 10);
        Assert.assertEquals(12, fare);
    }

    /**
     * 100公里 和10分钟等待 6+（100-2）*0.8+(100-8)*0.8*0.5+10*0.25
     * 119
     */
    @Test
    public void should_given_starting_fare_and_too_long_fare_and_waiting_fare() {
        TaxiFare taxiFare = new TaxiFare();
        int fare = taxiFare.calculationFare(100, 10);
        Assert.assertEquals(124, fare);
    }
}