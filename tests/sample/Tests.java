package sample;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class Tests {
    @Test
    public void addTest() throws Exception {

        Add add = new Add();
        assertEquals(add.eval(new BigDecimal(4),new BigDecimal(5)), new BigDecimal(9));
    }

    @Test
    public void subtractTest() throws Exception {

        Subtract subtract = new Subtract();
        assertEquals(subtract.eval(new BigDecimal(4), new BigDecimal(5)), new BigDecimal(-1));
    }

    @Test
    public void divideTest() throws Exception {

        Divide divide = new Divide();
        assertEquals(divide.eval(new BigDecimal(10), new BigDecimal(5)), new BigDecimal(2));
    }

    @Test
    public void multiplyTest() throws Exception {

        Multiply multiply = new Multiply();
        assertEquals(multiply.eval(new BigDecimal(4), new BigDecimal(5)), new BigDecimal(20));
    }

    @Test
    public void exponentiateTest() throws Exception {

        Exponentiate exponentiate = new Exponentiate();
        assertEquals(exponentiate.eval(new BigDecimal(4)), new BigDecimal(16));
    }

    @Test
    public void rootExtractionTest() throws Exception {

        RootExtraction rootExtraction = new RootExtraction();
        assertEquals(rootExtraction.eval(new BigDecimal(4)), new BigDecimal(2));
    }

}