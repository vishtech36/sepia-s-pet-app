package com.vishtech.sepiapetsapp.utils;

import junit.framework.TestCase;

import org.junit.Assert;

public class TimeUtilTest extends TestCase {

    public void testCurrentTimeInHHmm() {
        Assert.assertEquals(TimeUtil.currentTimeInHHmm(1662348600000L), new Float(9.0));
        Assert.assertEquals(TimeUtil.currentTimeInHHmm(1662382020000L), new Float(18.17));
        Assert.assertEquals(TimeUtil.currentTimeInHHmm(1662374100000L), new Float(16.5));
    }

    public void testCurrentToFloat() {
        Assert.assertEquals(TimeUtil.currentToFloat("11:00"), new Float(11.0));
        Assert.assertEquals(TimeUtil.currentToFloat("09:05"), new Float(09.05));
        Assert.assertEquals(TimeUtil.currentToFloat("18:05"), new Float(18.05));
    }

    public void testDayStringFormat() {
        Assert.assertEquals(TimeUtil.dayStringFormat(1662521400000L), new Integer(2));
        Assert.assertEquals(TimeUtil.dayStringFormat(1662435000000L), new Integer(1));
        Assert.assertEquals(TimeUtil.dayStringFormat(1662348600000L), new Integer(0));
    }
}