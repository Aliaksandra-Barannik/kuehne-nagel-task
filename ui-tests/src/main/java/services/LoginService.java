package services;

import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginService extends BaseService {

    private LoginPage loginPage;

    public LoginService(WebDriver webDriver) {
        super(webDriver);
        loginPage = new LoginPage(driver);
    }

    @Step("Login as an user")
    public void login(Users user) {
        loginPage.setUserName(user.getName());
        loginPage.setPassword(user.getPassword());

        for (int i = 0; i < 2; i++) {
            loginPage.clickLoginButton();

            if (basePage.isLogoutButtonVisible()) {
                break;
            }
        }
    }
}
