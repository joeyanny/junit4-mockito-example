package example.junit.models;

import java.util.HashMap;
import java.util.Map;

public class Tests {

    private Map<String, Test> tests = new HashMap<>();

    public void addTest(String code, String name, int maxScore) {
        Test test = new Test(code, name, maxScore);
        tests.put(code, test);
    }

    public Test getTest(String code) {
        return tests.get(code);
    }
}
