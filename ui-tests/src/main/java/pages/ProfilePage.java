package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends Page {

    @FindBy(xpath = "//div[@class='text-right button di']")
    private WebElement deleteAllBooks;

    @FindBy(id = "searchBox")
    private WebElement searchInput;

    public void searchBookByText(String text){
        Driver.waitForElementVisibility(searchInput);
        setText(searchInput, text);
    }

    public void clickDeleteAllBooksButton(){
        click(deleteAllBooks);
    }
}
