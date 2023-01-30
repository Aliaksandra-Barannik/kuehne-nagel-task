package services.components;

import io.qameta.allure.Step;
import java.util.List;
import objects.Book;
import pages.components.Table;
import services.BaseService;
import services.BookService;

public class TableService extends BaseService {

    protected Table table;

    public TableService() {
        super();
        table = new Table();
    }

    @Step("Open a book '{title}'")
    public BookService openItem(String title) {
        table.clickTitleLink(title);
        return new BookService();
    }

    @Step("Find books which contain title: {title}")
    public List<Book> getBooksByTitle(String title){
        return table.getBooksByTitle(title);
    }

    public boolean isTableEmpty(){
        return table.isTableEmpty();
    }
}
