package services;

import dto.TokenDto;
import dto.UserDto;
import enums.AccountEndpoint;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

public class AccountApiService extends BaseApiService {

    private RequestSpecification requestSpecification;

    public AccountApiService(TokenDto token) {
        super(token);
        requestSpecification = getRequestSpecification();
    }

    @Step("Get a user")
    public UserDto getUser(String userId) {
        String fullUrl = String.format(AccountEndpoint.GET_USER_BY_USER_ID.getFullUrl(), userId);

        return requestSpecification
                .when()
                .get(fullUrl)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .as(UserDto.class);
    }
}
