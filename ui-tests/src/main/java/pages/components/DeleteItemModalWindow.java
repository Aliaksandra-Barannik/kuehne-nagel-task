package pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class DeleteItemModalWindow extends Page {
    @FindBy(id="closeSmallModal-ok")
    private WebElement okButton;

    public void clickOkButton(){
        okButton.click();
    }
}
