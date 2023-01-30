package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends Page {

    @FindBy(xpath = "//div[@class='text-right fullButton']//button")
    private WebElement addToCollectionButton;

    public void clickAddToCollectionButton(){
        click(addToCollectionButton);
    }
}
