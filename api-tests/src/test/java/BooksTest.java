import dto.TokenDto;
import dto.UserDto;
import dto.requests.AddBooksRequest;
import dto.requests.LoginRequest;
import enums.User;
import io.qameta.allure.Description;
import mappers.LoginRequestMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.BookApiService;
import services.AccountApiService;
import utils.FileReader;

public class BooksTest extends BaseTest {

    private BookApiService bookService;
    private String userId;

    @Test
    @Description("Add a book to a user's collection")
    void addBookToUserTest() {
        //Do preconditions
        UserDto expectedUser = FileReader.serializeJsonFromResource(UserDto.class,
                "json/users/userWithOneBook.json");
        AddBooksRequest addBooksRequest = FileReader.serializeJsonFromResource(AddBooksRequest.class,
                "json/users/addBooksToUserCollection.json");
        LoginRequest loginRequest = LoginRequestMapper.toLoginRequest(User.USER);
        userId = expectedUser.getUserId();

        //Get a token
        token = authUserService.getToken(loginRequest);

        //Verify if the user doesn't have books in the collection
        AccountApiService accountApiService = getAuthorizedService(AccountApiService.class, token);
        UserDto actualUser = accountApiService.getUser(userId);
        Assertions.assertEquals(0, actualUser.getBooks().size(), "User has books in the collection");

        //Add a book to a user
        bookService = getAuthorizedService(BookApiService.class, token);
        bookService.addBooksToUser(addBooksRequest);

        //Verify if the user's collection contains the book
        actualUser = accountApiService.getUser(userId);
        Assertions.assertEquals(1, actualUser.getBooks().size(), "User has books in the collection");
        Assertions.assertEquals(expectedUser, actualUser, "Objects are different. Actual: " + actualUser.toString()
                + " , expected: " + expectedUser.toString());
    }

    @AfterEach
    void cleanUp() {
        bookService.deleteAllBooksByUserId(userId);
    }
}
