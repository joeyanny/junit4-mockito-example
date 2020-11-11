package example.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import example.junit.exceptions.TestNotFoundException;
import example.junit.models.Tests;

public class ValidatorTest {

    private static final String CODE = "test0001";
    private static final String NAME = "Practise test 1";
    private static final int MAX_SCORE = 10;

    private Validator validator;

    @Before
    public void setUp() {
        Tests tests = new Tests();
        tests.addTest(CODE, NAME, MAX_SCORE);
        validator = new Validator(tests);
    }

    @Test
    public void testValid() throws Exception {
        assertTrue(validator.isValidScore(CODE, 5));
    }

    @Test
    public void testBelowMinInvalid() throws Exception {
        assertFalse(validator.isValidScore(CODE, -1));
    }

    @Test
    public void testAboveMaxInvalid() throws Exception {
        assertFalse(validator.isValidScore(CODE, 11));
    }

    @Test(expected=TestNotFoundException.class)
    public void testErrorTestNotFound() throws Exception {
        validator.isValidScore("invalid", 5);
    }
}
