package com.jiker.keju;

import org.junit.Assert;
import org.junit.Test;

public class CommonUtilTest {
    @Test
    public void given_String_return_int() {
        String input = "1公里";
        CommonUtil commonUtil = new CommonUtil();
        int number = commonUtil.getNumber(input);
        Assert.assertEquals(1, number);
    }

    @Test
    public void given_trip_return_miles() {
        String trip = "1公里,等待0分钟";
        CommonUtil commonUtil = new CommonUtil();
        int miles = commonUtil.getMiles(trip);
        Assert.assertEquals(1, miles);
    }

    @Test
    public void given_trip_return_waitingMinutes() {
        String trip = "1公里,等待0分钟";
        CommonUtil commonUtil = new CommonUtil();
        int waitingMinutes = commonUtil.getWaitingMinutes(trip);
        Assert.assertEquals(0, waitingMinutes);
    }
}
