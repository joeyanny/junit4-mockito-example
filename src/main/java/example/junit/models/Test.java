package example.junit.models;

public class Test {

    private String code;
    private String name;
    private int maxScore;

    public Test(String code, String name, int maxScore) {
        this.code = code;
        this.name = name;
        this.maxScore = maxScore;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getMaxScore() {
        return maxScore;
    }
}
