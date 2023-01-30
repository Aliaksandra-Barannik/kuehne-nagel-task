package enums;

import utils.Configuration;

public enum BookEndpoint {
    USER_BOOKS("/BookStore/v1/Books");

    private String url;

    BookEndpoint(String url) {
        this.url = url;
    }

    public String getFullUrl() {
        return Configuration.getUrl() + url;
    }
}
