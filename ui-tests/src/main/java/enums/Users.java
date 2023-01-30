package enums;

import org.apache.commons.lang3.StringUtils;
import utils.Configuration;

public enum Users {
    USER("Aliaksandra", "", "3d1ea11d-ca69-47c3-b4be-d80fff6c35ff");

    private String name;
    private String password;
    private String userId;

    Users(String name, String password, String userId) {
        this.name = name;
        this.password = StringUtils.isEmpty(password) ? Configuration.getDefaultPassword() : password;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }
}
