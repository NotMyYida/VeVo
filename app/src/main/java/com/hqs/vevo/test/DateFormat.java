package com.hqs.vevo.test;

/**
 * Created by Hqs on 2017/11/17
 */
public class DateFormat {

    public static String toHexString(int i) {
        String value = Integer.toHexString(i);
        if (value.length() == 1) {
            value = "0" + value;
        }
        return value;
    }
}
