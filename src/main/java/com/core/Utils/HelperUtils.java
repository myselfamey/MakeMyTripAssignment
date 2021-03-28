package com.core.Utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperUtils {

    public static void doWait(Thread thread, long milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    public static String getPlusDateFromNow(int days, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(new Date(new Date().getTime() + (days * 86400000)));
    }
}
