package example.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import example.junit.exceptions.InvalidScoreException;
import example.junit.exceptions.TestNotFoundException;
import example.junit.models.ResultType;
import example.junit.models.Tests;

public class ResultCalculatorTest {

    private static final String CODE = "test0001";
    private static final String NAME = "Practise test 1";
    private static final int MAX_SCORE = 10;

    private ResultCalculator calculator;

    @Before
    public void setUp() {
        Tests tests = new Tests();
        tests.addTest(CODE, NAME, MAX_SCORE);
        calculator = new ResultCalculator(tests);
    }

    @Test
    public void testPass() throws Exception {
        assertEquals(ResultType.PASS, calculator.computeResult(CODE, 8));
    }

    @Test
    public void testFail() throws Exception {
        assertEquals(ResultType.FAIL, calculator.computeResult(CODE, 1));
    }

    @Test(expected=InvalidScoreException.class)
    public void testBelowMinInvalid() throws Exception {
        calculator.computeResult(CODE, -1);
    }

    @Test(expected=InvalidScoreException.class)
    public void testAboveMaxInvalid() throws Exception {
        calculator.computeResult(CODE, 11);
    }

    @Test(expected=TestNotFoundException.class)
    public void testErrorTestNotFound() throws Exception {
        calculator.computeResult("invalid", -1);
    }
}
