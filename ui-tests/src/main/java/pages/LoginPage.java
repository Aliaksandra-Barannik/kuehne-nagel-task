package pages;

import driver.Driver;
import enums.Users;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement loginButton;

    public void login(Users user) {
        setText(userName, user.getName());
        setText(password, user.getPassword());

        for (int i = 0; i < 2; i++) {
            loginButton.click();

            if (Driver.waitForElementVisibility(logoutButton)) {
                break;
            }
        }
    }
}
