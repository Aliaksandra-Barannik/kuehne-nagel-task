package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {

    @FindBy(xpath = "//div[@id='books-wrapper']//button")
    protected WebElement logoutButton;

    protected WebDriver driver;

    public Page() {
        driver = Driver.getWebDriverInstance();
        PageFactory.initElements(driver, this);
    }

    public boolean isLogoutButtonVisible(){
       return Driver.waitForElementVisibility(logoutButton);
    }

    public void clickLogoutButton() {
        click(logoutButton);
    }

    protected void setText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    protected void click(WebElement element){
        Driver.scrollToElement(element);
        element.click();
    }
}
