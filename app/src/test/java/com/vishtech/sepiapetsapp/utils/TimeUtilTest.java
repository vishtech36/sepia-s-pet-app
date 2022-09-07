package com.vishtech.sepiapetsapp.utils;

import static org.hamcrest.MatcherAssert.assertThat;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class TimeUtilTest {

    @Test
    void checkCurrentToFloat() {
        Assert.assertEquals(TimeUtil.currentToFloat("11:00"), new Float(11.00f));
    }

}