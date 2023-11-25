package com.rodavid20.testingdemo;

import org.junit.Test;

import static org.junit.Assert.*;

import com.rodavid20.testingdemo.helper.MyMath;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MyMathUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(30, MyMath.Add(10, 20));
        assertEquals(40, MyMath.Add(20, 20));
    }

    @Test
    public void subtraction_isCorrect() {
        assertEquals(10, MyMath.Subtract(20, 10));
        assertEquals(-10, MyMath.Subtract(10, 20));
    }
}