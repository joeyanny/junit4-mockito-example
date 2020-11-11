package example.junit;

import example.junit.exceptions.InvalidScoreException;
import example.junit.exceptions.TestNotFoundException;
import example.junit.models.ResultType;
import example.junit.models.Test;
import example.junit.models.Tests;

public class ResultCalculator {

    /** Percentage needed to pass */
    private static final int PASS = 70;

    /** Reference to the available tests */
    private Tests tests;

    /**
     * Initialise reference to the available tests
     * 
     * @param tests
     */
    public ResultCalculator(Tests tests) {
        this.tests = tests;
    }

    /**
     * Get the result associated with the score
     * 
     * @throws InvalidScoreException 
     * @throws TestNotFoundException 
     */
    public ResultType computeResult(String code, int score) throws InvalidScoreException, TestNotFoundException {

        Test test = tests.getTest(code);
        if(test == null) {
            throw new TestNotFoundException("Failed to compute result: invalid test code: " + code);
        }

        int percentage = (score * 100) / test.getMaxScore();
        if(percentage < 0 || percentage > 100) {
            throw new InvalidScoreException("Failed to compute result: Percentage achieved is invalid");
        }

        return percentage > PASS ? ResultType.PASS : ResultType.FAIL;
    }
}
