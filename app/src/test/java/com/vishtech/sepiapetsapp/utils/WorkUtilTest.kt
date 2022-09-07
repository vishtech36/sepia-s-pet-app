package com.vishtech.sepiapetsapp.utils

import org.junit.Assert
import org.junit.Test


internal class WorkUtilTest {

    @Test
    fun isValidWorkingTime_true_16_00_time() {
        val validWorkTime = WorkUtil.isValidWorkingTime("M-F 9:00 - 18:00",1662546600000) // 16:00 hr
        Assert.assertTrue(validWorkTime)
    }

    @Test
    fun isValidWorkingTime_false_19_00_time() {
        val validWorkTime = WorkUtil.isValidWorkingTime("M-F 9:00 - 18:00",1662557400000) // 19:00 hr
        Assert.assertFalse(validWorkTime)
    }

    @Test
    fun isValidWorkingTime_true_21_00_time() {
        val validWorkTime = WorkUtil.isValidWorkingTime("M-F 10:00 - 22:00",1662564600000) // 21:00 hr
        Assert.assertTrue(validWorkTime)
    }

    @Test
    fun isValidWorkingTime_false_09_00_time() {
        val validWorkTime = WorkUtil.isValidWorkingTime("M-F 10:00 - 22:00",1662521400000) // 9:00 hr
        Assert.assertFalse(validWorkTime)
    }
}