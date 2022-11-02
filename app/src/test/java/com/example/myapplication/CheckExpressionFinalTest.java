package com.example.myapplication;

import org.junit.Assert;
import org.junit.Test;

public class CheckExpressionFinalTest {

    @Test
    public void whenExpression() {
        String expression = "1 + 2 + 3 * 5";
        CheckExpressionFinal cef = new CheckExpressionFinal();
        Assert.assertEquals(cef.checkExpressionFinal(expression), 18, 0.1);
    }
}
