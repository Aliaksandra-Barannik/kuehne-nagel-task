package pages.components;

import static enums.Columns.AUTHOR;
import static enums.Columns.PUBLISHER;
import static enums.Columns.TITLE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import objects.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class Table extends Page {

    @FindBy(xpath = "//div[@class='rt-tr-group']")
    private List<WebElement> rows;

    @FindBy(xpath = "//div[contains(@class,'-padRow')]")
    private List<WebElement> emptyRows;

    @FindBy(xpath = "//div[@role='columnheader']")
    private List<WebElement> headers;

    public Table(WebDriver driver) {
        super(driver);
    }

    public List<String> getColumnNames() {
        return headers.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByTitle(String title) {
        return getBooks().stream().filter(book -> book.getTitle().equals(title)).collect(Collectors.toList());
    }

    public List<Book> getBooks() {
        List<Book> actualBookList = new ArrayList<>();
        List<String> columnNames = getColumnNames();

        for (WebElement row : rows) {
            List<WebElement> columns = getColumnElements(row);
            Book actualBook = new Book.Builder().withTitle(columns.get(columnNames.indexOf(TITLE.getValue())).getText())
                    .withAuthor(columns.get(columnNames.indexOf(AUTHOR.getValue())).getText())
                    .withPublisher(columns.get(columnNames.indexOf(PUBLISHER.getValue())).getText())
                    .build();
            actualBookList.add(actualBook);
        }

        return actualBookList;
    }

    public void clickTitleLink(String title) {
        List<String> columnNames = getColumnNames();
        List<WebElement> columns = getColumnElements(getRow(title));
        WebElement column = columns.get(columnNames.indexOf(TITLE.getValue()));
        column.findElement(By.xpath(".//a")).click();
    }

    public boolean isTableEmpty() {
        return rows.size() == emptyRows.size();
    }

    protected WebElement getRow(String title) {
        int columnIndex = getColumnNames().indexOf(TITLE.getValue());
        int rowIndex = 0;
        for (int i = 0; i < rows.size(); i++) {
            String actualTitle = getColumnElements(rows.get(i)).get(columnIndex).getText();
            if (actualTitle.equals(title)) {
                rowIndex = i;
                break;
            }
        }
        return rows.get(rowIndex);
    }

    private List<WebElement> getColumnElements(WebElement row) {
        return row.findElements(By.xpath(".//div[@class='rt-td']"));
    }
}
