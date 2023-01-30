package services;

import dto.TokenDto;
import dto.requests.AddBooksRequest;
import enums.BookEndpoint;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

public class BookApiService extends BaseApiService {

    private RequestSpecification requestSpecification;

    public BookApiService(TokenDto token) {
        super(token);
        requestSpecification = getRequestSpecification();
    }

    @Step("Delete all books by user id")
    public void deleteAllBooksByUserId(String userId) {
        String fullUrl = BookEndpoint.USER_BOOKS.getFullUrl();

        requestSpecification
                .queryParam("UserId", userId)
                .when()
                .delete(fullUrl)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Step("Add books to user's collection")
    public void addBooksToUser(AddBooksRequest addBooksRequest) {
        String fullUrl = BookEndpoint.USER_BOOKS.getFullUrl();

        requestSpecification
                .when()
                .body(addBooksRequest)
                .post(fullUrl)
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }
}
