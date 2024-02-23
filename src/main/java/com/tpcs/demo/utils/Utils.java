package com.tpcs.demo.utils;

import java.text.DecimalFormat;

public class Utils {

    private static final DecimalFormat DF = new DecimalFormat("0.00");

    public static String formatDecimal(String number) {
        return DF.format(Double.parseDouble(number));
    }
}
