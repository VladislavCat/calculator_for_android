package com.example.myapplication;


import com.example.myapplication.parenthesis.CheckCorrectParenthesis;

import org.junit.Assert;
import org.junit.Test;


public class CheckCorrectParenthesisTest {

    @Test
    public void whenCheckCheckEqualParenthesis() {
        String text = "(())";
        int res = CheckCorrectParenthesis.check(text);
        Assert.assertEquals(res, 0);
    }

    @Test
    public void whenCheckCheckNotEqualParenthesis() {
        String text = "(((())";
        int res = CheckCorrectParenthesis.check(text);
        Assert.assertEquals(res, 2);
    }

    @Test
    public void whenCheckResultExpression() {
        String text = "12*11-(23-1 / 15 * (12 + (21 / 1)";
        String rsl = CheckCorrectParenthesis.resultChecker(text);
        Assert.assertEquals(rsl, "12*11-(23-1 / 15 * (12 + (21 / 1)))");
    }
}


