package mvc;

import java.util.HashMap;
import java.util.Map;

public class ActionConfig {
    private String name;
    private String className;
    private String method;
    Map<String,ResultConfig> resultConfigMap = new HashMap<>();

    public Map<String, ResultConfig> getResultConfigMap() {
        return resultConfigMap;
    }

    public void setResultConfigMap(Map<String, ResultConfig> resultConfigMap) {
        this.resultConfigMap = resultConfigMap;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
