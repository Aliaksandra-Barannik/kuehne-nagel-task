package tests;

import static enums.BookStoreAppSubGroups.BOOK_STORE;
import static enums.BookStoreAppSubGroups.PROFILE;
import static enums.NavigationGroups.BOOK_STORE_APP;

import dto.TokenDto;
import dto.requests.LoginRequest;
import enums.User;
import enums.Users;
import io.qameta.allure.Description;
import java.util.List;
import mappers.LoginRequestMapper;
import objects.Book;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import services.AuthUserService;
import services.BookApiService;
import services.BookService;
import services.BookStoreService;
import services.ProfileService;
import utils.FileReader;

@ExtendWith(TestListener.class)
public class UserBookCollectionTest extends BaseTest {

    private BookStoreService bookStoreService;
    private BookService bookService;
    private ProfileService profileService;
    private static final String BOOKS_CSV = "Books.csv";

    @Test
    @Description("A book can be added to a book collection")
    public void addBookToCollectionTest() {
        Book book = FileReader.getObjectFromCsvFile("Book1", BOOKS_CSV, Book.class);
        String title = book.getTitle();

        addBookToUsersCollection(title, Users.USER);

        //Verify if the book is in the user's collection
        List<Book> actualBookList = profileService.table().getBooksByTitle(title);
        profileService.verifyObject(actualBookList.get(0), book);
    }

    @Test
    @Description("A book can be deleted from a book collection")
    public void removeBookFromCollectionTest() {
        Book book = FileReader.getObjectFromCsvFile("Book2", BOOKS_CSV, Book.class);
        String title = book.getTitle();

        addBookToUsersCollection(title, Users.USER);

        //Delete the book
        profileService.table().deleteItem(title);

        //Verify if the book is absent in the user's collection
        profileService.verifyIfBookInCollection(title, false);
    }

    @AfterEach
    public void deleteAllBooks() {
        profileService.logout();
        cleanUserBookCollectionViaApi();
    }

    private void addBookToUsersCollection(String title, Users user) {
        //Login as a user
        loginService.login(user);

        //Add a book to user's collection
        bookStoreService = baseService.goToPage(BOOK_STORE_APP.getName(), BOOK_STORE.getName(), BookStoreService.class);
        bookStoreService.searchBook(title);
        bookService = bookStoreService.table().openItem(title);
        bookService.addBookToCollection();
        profileService = baseService.goToPage(BOOK_STORE_APP.getName(), PROFILE.getName(), ProfileService.class);
    }

    private void cleanUserBookCollectionViaApi() {
        AuthUserService authUserService = new AuthUserService();
        LoginRequest loginRequest = LoginRequestMapper.toLoginRequest(User.USER);

        TokenDto token = authUserService.getToken(loginRequest);
        BookApiService bookService = new BookApiService(token);
        bookService.deleteAllBooksByUserId(Users.USER.getUserId());
    }
}
