package enums;

import utils.Configuration;

public enum AccountEndpoint {
    GENERATE_TOKEN("/Account/v1/GenerateToken"),
    GET_USER_BY_USER_ID("/Account/v1/User/%s");

    private String url;

    AccountEndpoint(String url) {
        this.url = url;
    }

    public String getFullUrl() {
        return Configuration.getUrl() + url;
    }
}
