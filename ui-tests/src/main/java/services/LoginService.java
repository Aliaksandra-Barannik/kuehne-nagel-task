package services;

import enums.Users;
import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginService extends BaseService {

    private LoginPage loginPage;

    public LoginService() {
        super();
        loginPage = new LoginPage();
    }

    @Step("Login as an user")
    public void login(Users user) {
        loginPage.login(user);
    }
}