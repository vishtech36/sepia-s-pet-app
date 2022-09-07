package com.vishtech.sepiapetsapp.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class TimeUtil {

    // convert milliseconds to hours:minutes float format
    public static Float currentTimeInHHmm(long milliseconds) {
        @SuppressLint("SimpleDateFormat") int minutes = Integer.parseInt((new SimpleDateFormat("mm")).format(new Date(milliseconds)));
        @SuppressLint("SimpleDateFormat") int hours   = Integer.parseInt((new SimpleDateFormat("HH")).format(new Date(milliseconds)));
        return Float.parseFloat(hours+"."+minutes);
    }

    // convert string time to float
    public static Float currentToFloat(String time) {
        String[] currentTime = time.split(":");
        return Float.parseFloat(currentTime[0]+"."+currentTime[1]);
    }


    // convert milliseconds into the day of the week string
    public static Integer dayStringFormat(long msecs) {
        GregorianCalendar cal = new GregorianCalendar();

        cal.setTime(new Date(msecs));

        int dow = cal.get(Calendar.DAY_OF_WEEK);

        switch (dow) {
            case Calendar.MONDAY:
                return 0;
            case Calendar.TUESDAY:
                return 1;
            case Calendar.WEDNESDAY:
                return 2;
            case Calendar.THURSDAY:
                return 3;
            case Calendar.FRIDAY:
                return 4;
            case Calendar.SATURDAY:
                return 5;
            case Calendar.SUNDAY:
                return 6;
        }
        return -1;
    }
}