package com.jiker.keju;


public class TaxiFare {
    /**
     * 计算总价
     *
     * @param miles
     * @param waitingMinutes
     * @return
     */
    public int calculationFare(int miles, int waitingMinutes) {
        double fareOfStarting = calculationFareStarting();
        double fareOfWaiting = calculationFareOfWaiting(waitingMinutes);
        double fareOfOverTwo = calculationFareOverTwo(miles);
        double fareOfTooLong = calculationFareTooLong(miles);
        double fare = fareOfStarting + fareOfWaiting + fareOfOverTwo + fareOfTooLong;
        int actualFare = (int) Math.round(fare);
        return actualFare;
    }

    /**
     * 等待费
     *
     * @param waitingMinutes
     * @return
     */
    private double calculationFareOfWaiting(int waitingMinutes) {
        return FareStrategyEnum.FARE_PER_MINUTES.getRatio() * waitingMinutes;
    }

    /**
     * 超过2公里的费用
     *
     * @param miles
     * @return
     */
    private double calculationFareOverTwo(int miles) {
        double milesOverTwo = miles - FareStrategyEnum.MILES_STARTING.getRatio() > 0 ? miles - FareStrategyEnum.MILES_STARTING.getRatio() : 0;
        return milesOverTwo * FareStrategyEnum.FARE_LARGER_THAN_TWO_KILOMETER.getRatio();
    }

    /**
     * 计算长途费
     *
     * @param miles
     * @return
     */
    private double calculationFareTooLong(int miles) {
        double milesOverEight = miles - FareStrategyEnum.MILES_TOO_LONG.getRatio() > 0 ? miles - FareStrategyEnum.MILES_TOO_LONG.getRatio() : 0;
        return milesOverEight * FareStrategyEnum.FARE_TOO_LONG.getRatio() * FareStrategyEnum.FARE_LARGER_THAN_TWO_KILOMETER.getRatio();
    }

    /**
     * 获取起步费
     *
     * @return
     */
    private double calculationFareStarting() {
        return FareStrategyEnum.FARE_STARTING.getRatio();
    }

}
