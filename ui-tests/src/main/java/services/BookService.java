package services;

import driver.Driver;
import io.qameta.allure.Step;
import pages.BookPage;

public class BookService extends BaseService {

    private BookPage bookPage;

    public BookService() {
        super();
        bookPage = new BookPage();
    }

    @Step("Add the book to the collection")
    public void addBookToCollection(){
        Driver.scrollToBottom();
        bookPage.clickAddToCollectionButton();
        Driver.acceptAlert();
    }
}
