package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends Page {

    @FindBy(id = "searchBox")
    private WebElement searchInput;

    public void searchBookByText(String text){
        Driver.waitForElementVisibility(searchInput);
        setText(searchInput, text);
    }
}
