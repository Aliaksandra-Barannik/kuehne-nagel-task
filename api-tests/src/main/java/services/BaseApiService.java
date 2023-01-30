package services;

import dto.TokenDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseApiService {

    private TokenDto token;

    public BaseApiService(TokenDto token) {
        this.token = token;
    }

    public RequestSpecification getRequestSpecification() {
        return RestAssured.with()
                .given()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + token.getToken());
    }

}
