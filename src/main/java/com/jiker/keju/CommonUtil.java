package com.jiker.keju;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
    public static final String REGEX = "[^0-9]";

    public int getNumber(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        int number = Integer.parseInt(matcher.replaceAll("").trim());
        return number;
    }

    public int getMiles(String input) {
        String milesString = input.split(",")[0];
        return getNumber(milesString);
    }

    public int getWaitingMinutes(String input) {
        String waitingMinutes = input.split(",")[1];
        return getNumber(waitingMinutes);
    }
}
