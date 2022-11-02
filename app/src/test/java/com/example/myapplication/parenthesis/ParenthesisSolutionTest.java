package com.example.myapplication.parenthesis;

import org.junit.Assert;
import org.junit.Test;

public class ParenthesisSolutionTest {

    @Test
    public void whenParentTwo() {
        ParenthesisSolution ch = new ParenthesisSolution();
        String str = "5/(1+7-3)";
        String result = ch.parentCalc(str, "(");
        String expected = "5/5.0";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void whenParentFour() {
        ParenthesisSolution ch = new ParenthesisSolution();
        String str = "5/(8+2*(12*3+4))";
        String res = ch.parentCalc(str, "(");
        String ex = "5/(8+2*40.0)";
        Assert.assertEquals(ex, res);
    }

    @Test
    public void whenParentFourNotIn() {
        ParenthesisSolution ch = new ParenthesisSolution();
        String str = "5/(3+2)*(1+2)";
        String res = ch.parentCalc(str, "(");
        String ex = "5/5.0*(1+2)";
        Assert.assertEquals(ex, res);
    }

    @Test
    public void whenTripleParent() {
        ParenthesisSolution ch = new ParenthesisSolution();
        String str = "5-(1+(10-8+(12-10)))";
        String res = ch.parentCalc(str, "(");
        String ex = "5-(1+(10-8+2.0))";
        Assert.assertEquals(ex, res);
    }
    @Test
    public void whenQuadParent() {
        ParenthesisSolution ch = new ParenthesisSolution();
        String str = "5-(1+(10-8+(12-10*(2+1))))";
        String res = ch.parentCalc(str, "(");
        String ex = "5-(1+(10-8+(12-10*3.0)))";
        Assert.assertEquals(ex, res);
    }
}
