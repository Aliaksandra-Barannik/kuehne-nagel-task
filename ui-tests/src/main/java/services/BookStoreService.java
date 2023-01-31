package services;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.BookStorePage;
import services.components.TableService;

public class BookStoreService extends BaseService {

    private BookStorePage bookStorePage;

    public BookStoreService(WebDriver webDriver) {
        super(webDriver);
        bookStorePage = new BookStorePage(driver);
    }

    @Step("Search a book by title '{text}'")
    public void searchBook(String text) {
        bookStorePage.searchBookByText(text);
    }

    public TableService table() {
        return new TableService(driver);
    }
}
