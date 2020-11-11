package example.junit;

import example.junit.exceptions.TestNotFoundException;
import example.junit.models.Test;
import example.junit.models.Tests;

/**
 * Validates scoring is valid
 */
public class Validator 
{
    /** Reference to the available tests */
    private Tests tests;

    /**
     * Initialise reference to the available tests
     * 
     * @param tests
     */
    public Validator(Tests tests) {
        this.tests = tests;
    }

    /**
     * Verify test score is valid
     * 
     * @param code
     * @param score
     * @return valid
     * @throws TestNotFoundException 
     */
    public boolean isValidScore(String code, int score) throws TestNotFoundException {
        Test test = tests.getTest(code);
        if(test == null) {
            throw new TestNotFoundException("Failed to validate score: invalid test code: " + code);
        }

        return score >= 0 && score <= test.getMaxScore();
    }
}
