package cucumber;

public class BaseClass {

    private String featureName;
    private String scenarioName;
    public String getFeatureName(){
        return featureName;
    }
    public String getScenarioName(){
        return scenarioName;
    }

    public BaseClass(){
        featureName = "BDD";
        scenarioName = "DI";
    }

}
