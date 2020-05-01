package com.jiker.keju;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class AppRunner {

    public static void main(String[] args) throws Exception {
        /*TODO
          1. args[0]为resources下的测试数据文件名，例如传入的args[0]值为"testData.txt"，注意并不包含文件路径。
          2. 你写的程序将把testDataFile作为参数加载此文件并读取文件内的测试数据，并对每条测试数据计算结果。
          3. 将所有计费结果拼接并使用\n分割，然后保存到receipt变量中。
         */
        String testDataFile = args[0];
        String fileName = "src/main/resources/" + testDataFile;
        String receipt = getFareByTxt(fileName);
        System.out.println(receipt);
    }

    public static String getFareByTxt(String fileName) throws Exception {
        TaxiFare taxiFare = new TaxiFare();
        CommonUtil commonUtil = new CommonUtil();
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
