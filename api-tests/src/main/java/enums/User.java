package enums;

import org.apache.commons.lang3.StringUtils;
import utils.Configuration;

public enum User {
    USER("Aliaksandra", "");

    private String name;
    private String password;

    User(String name, String password) {
        this.name = name;
        this.password = StringUtils.isEmpty(password) ? Configuration.getDefaultPassword() : password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
