package entity;

public class SysConfig {
    private int id;
    private String configType;
    private String configKey;
    private String configPageValue;
    private String createTime;

    public SysConfig() {
        super();
    }

    public SysConfig(int id, String configType, String configKey, String configPageValue, String createTime) {
        this.id = id;
        this.configType = configType;
        this.configKey = configKey;
        this.configPageValue = configPageValue;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigPageValue() {
        return configPageValue;
    }

    public void setConfigPageValue(String configPageValue) {
        this.configPageValue = configPageValue;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysConfig{" +
                "id=" + id +
                ", configType='" + configType + '\'' +
                ", configKey='" + configKey + '\'' +
                ", configPageValue='" + configPageValue + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
