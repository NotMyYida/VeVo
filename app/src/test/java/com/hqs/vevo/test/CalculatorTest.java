package com.hqs.vevo.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hqs on 2017/11/16
 */
public class CalculatorTest {

    Calculator mCalculator ;

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(6,mCalculator.sum(1,5),2);
    }

    @Test
    public void testSubstract() throws Exception {
        assertEquals(6,mCalculator.substract(1,5),0);
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(6,mCalculator.divide(1,5),0);
    }

    @Test
    public void testMultiply() throws Exception {

    }
}