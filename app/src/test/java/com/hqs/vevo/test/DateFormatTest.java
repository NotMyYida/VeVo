package com.hqs.vevo.test;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Hqs on 2017/11/17
 */
public class DateFormatTest {



    @Test
    public void testToHexString() throws Exception {
        assertEquals("0a",DateFormat.toHexString(10));
    }
}