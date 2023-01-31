package services;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.BookPage;

public class BookService extends BaseService {

    private BookPage bookPage;

    public BookService(WebDriver webDriver) {
        super(webDriver);
        bookPage = new BookPage(driver);
    }

    @Step("Add the book to the collection")
    public void addBookToCollection(){
        Driver.scrollToBottom();
        bookPage.clickAddToCollectionButton();
        Driver.acceptAlert();
    }
}
