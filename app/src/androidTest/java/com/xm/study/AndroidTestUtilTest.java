package com.xm.study;

import android.test.InstrumentationTestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * 作者：xm on 2017/1/12 10:38
 * 描述：
 */
public class AndroidTestUtilTest extends InstrumentationTestCase {
    private AndroidTestUtil mAndroidTestUtil;
    @Before
    public void setUp() throws Exception {
        mAndroidTestUtil=new AndroidTestUtil();
    }
    @Test
    public void testSum() throws Exception {
        assertEquals(6d, mAndroidTestUtil.sum(1d, 5d), 0);
    }
    @Test
    public void testSubstract() throws Exception {
        assertEquals(1d, mAndroidTestUtil.substract(5d, 4d), 0);
    }
    @Test
    public void testDivide() throws Exception {
        assertEquals(4d, mAndroidTestUtil.divide(20d, 5d), 0);
    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(10d, mAndroidTestUtil.multiply(2d, 5d), 0);
    }
}