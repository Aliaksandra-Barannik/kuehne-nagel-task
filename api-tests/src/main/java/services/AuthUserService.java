package services;

import dto.TokenDto;
import dto.requests.LoginRequest;
import enums.AccountEndpoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class AuthUserService {

    public TokenDto getToken(LoginRequest loginRequest) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(loginRequest)
                .post(AccountEndpoint.GENERATE_TOKEN.getFullUrl());
        return response
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .as(TokenDto.class);
    }
}
