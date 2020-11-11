package example.junit;

import java.sql.SQLException;

import example.junit.models.Result;

/**
 * Handles persistence of results
 */
public class DAO {

    /**
     * Store the result in the data store
     * 
     * @param result
     * @throws SQLException
     */
    public void storeResult(Result result) throws SQLException {
        // Store result in DB
    }
}
