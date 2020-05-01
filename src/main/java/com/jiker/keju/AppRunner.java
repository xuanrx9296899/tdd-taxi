package com.jiker.keju;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AppRunner {
    static TaxiFare taxiFare = new TaxiFare();
    static CommonUtil commonUtil = new CommonUtil();
    public static void main(String[] args) throws Exception {
        String testDataFile = args[0];
        String fileName = "src/main/resources/" + testDataFile;
        String receipt = getFareByTxt(fileName);
        System.out.println(receipt);
    }

    public static String getFareByTxt(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
        String inputLine;
        String receipt = "";
        while (null != (inputLine = br.readLine())) {
            String fare = setReceipt(taxiFare.calculationFare(commonUtil.getMiles(inputLine), commonUtil.getWaitingMinutes(inputLine)));
            receipt = receipt + fare;
        }
        br.close();
        return receipt;
    }


    public static String setReceipt(int fare) {
        return "收费" + fare + "元\n";
    }

}
