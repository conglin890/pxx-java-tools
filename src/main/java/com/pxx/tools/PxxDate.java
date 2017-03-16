package com.pxx.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PxxDate {

    public static String getCurrentDate(String dateVar) {
        DateFormat dateFormat = new SimpleDateFormat(dateVar);
        return dateFormat.format(new Date());
    }
}
