package com.vishtech.sepiapetsapp.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

object Util {
    fun getStartEndTimeHours(input: String): Pair<String?, String?> {
        val p: Pattern =
            Pattern.compile("^[A-Z]-[A-Z]\\s{1}(\\d{1,2}:\\d{2})\\s{1}-\\s{1}(\\d{1,2}:\\d{2})$")
        val m: Matcher = p.matcher(input)
        val items = ArrayList<String>();
        while (m.find()) {
            items.add(m.group(1)!!)
            items.add(m.group(2)!!)
        }
        return Pair(items[0], items[1])
    }

    fun isValidWorkingTime(input: String, time: Long = System.currentTimeMillis()): Boolean {
        val workingHours = getStartEndTimeHours(input)
        val currentDay = TimeUtil.dayStringFormat(time);
        // if current day is saturday or sunday it will return false;
        if (currentDay !in 0..4) return false;
        if (TimeUtil.currentTimeInHHmm(time) < TimeUtil.currentToFloat(workingHours.first) || TimeUtil.currentTimeInHHmm(
                time
            ) > TimeUtil.currentToFloat(workingHours.second)
        )
            return false;
        return true;
    }
}