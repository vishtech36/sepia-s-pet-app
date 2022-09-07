package com.vishtech.sepiapetsapp.utils;
//package com.monad.homerun.util;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.Pair;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * TimeUtil is a utility class with static methods to convert times in various
 * formats into other formats
 */


public class TimeUtil {
    private static final String TAG = "TimeUtil";
    private static final int MINS_PER_DAY = 60 * 24;
    private static final long MS_PER_DAY = 1000 * 60 * MINS_PER_DAY;
    private static final int SEC = 1000;
    private static final int MIN = SEC * 60;
    private static final int HOUR = MIN * 60;
    private static final int DAY = HOUR * 24;
    private static final long WEEK = DAY * 7;
    private static final long YEAR = WEEK * 52;

    private static final long[] buckets = { YEAR, WEEK, DAY, HOUR, MIN, SEC };
    private static final String[] bucketNames = { "year", "week", "day",
            "hour", "minute", "second" };

    private static GregorianCalendar statFmtCal = new GregorianCalendar();

    private static final String ts24Pat = "H:mm:ss yy-MM-dd";

    public static Float currentTimeInHHmm(long milliseconds) {
        @SuppressLint("SimpleDateFormat") int minutes = Integer.parseInt((new SimpleDateFormat("mm")).format(new Date(milliseconds)));
        @SuppressLint("SimpleDateFormat") int hours   = Integer.parseInt((new SimpleDateFormat("HH")).format(new Date(milliseconds)));
        return Float.parseFloat(hours+"."+minutes);
    }

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