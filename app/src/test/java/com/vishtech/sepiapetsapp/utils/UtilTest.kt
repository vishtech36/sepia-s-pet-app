package com.vishtech.sepiapetsapp.utils

import org.junit.Test


internal class UtilTest {
    private val TAG = "UtilTest"

    @Test
    fun testWorkingHours() {
        val pair = WorkUtil.isValidWorkingTime("M-F 9:00 - 18:00")
        print(pair)
    }
}