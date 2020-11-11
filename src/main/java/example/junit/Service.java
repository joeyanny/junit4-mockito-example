package example.junit;

import java.sql.SQLException;
import java.util.Date;

import example.junit.exceptions.InvalidScoreException;
import example.junit.exceptions.TestNotFoundException;
import example.junit.models.Result;
import example.junit.models.ResultType;

public class Service {

    private Validator validator;
    private ResultCalculator calculator;
    private DAO dao;

    /**
     * Initialise resources for computing and storing results
     * 
     * @param validator
     * @param calculator
     * @param dao
     */
    public Service(Validator validator, ResultCalculator calculator, DAO dao) {
        this.validator = validator;
        this.calculator = calculator;
        this.dao = dao;
    }

    /**
     * Compute the result from the score and store the result
     * 
     * @throws SQLException 
     * @throws MissingMappingsException 
     */
    public void computeAndStoreResult(String code, int score) throws InvalidScoreException, TestNotFoundException, SQLException {

        if(!validator.isValidScore(code, score)) {
            throw new InvalidScoreException("Score is invalid: " + score + " for test " + code);
        }

        ResultType resultType = calculator.computeResult(code, score);

        Result result = new Result();
        result.setTimestamp(new Date());
        result.setCode(code);
        result.setResult(resultType);

        dao.storeResult(result);
    }
}
