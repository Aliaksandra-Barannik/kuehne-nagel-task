package services.components;

import io.qameta.allure.Step;
import java.util.List;
import objects.Book;
import org.openqa.selenium.WebDriver;
import pages.components.Table;
import services.BaseService;
import services.BookService;

public class TableService extends BaseService {

    protected Table table;

    public TableService(WebDriver webDriver) {
        super(webDriver);
        table = new Table(driver);
    }

    @Step("Open a book '{title}'")
    public BookService openItem(String title) {
        table.clickTitleLink(title);
        return new BookService(driver);
    }

    @Step("Find books which contain title: {title}")
    public List<Book> getBooksByTitle(String title){
        return table.getBooksByTitle(title);
    }

    public boolean isTableEmpty(){
        return table.isTableEmpty();
    }
}
