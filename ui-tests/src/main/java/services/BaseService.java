package services;

import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.Page;
import pages.components.NavigationMenu;

public class BaseService {

    protected NavigationMenu navigationMenu;
    protected Page basePage;
    protected WebDriver driver;

    public BaseService(WebDriver webDriver) {
        this.driver = webDriver;
        basePage = new Page(driver);
        navigationMenu = new NavigationMenu(driver);
    }

    @Step("Navigate to {groupTab} / {subGroupTab}")
    public <T extends BaseService> T goToPage(String groupTab, String subGroupTab, Class<T> clazz) {
        navigationMenu.openTab(groupTab, subGroupTab);
        T service;
        try {
            service = clazz.getConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("Could not create '%s' service!", clazz.getSimpleName()));
        }
        return service;
    }

    @Step("Verify an object")
    public <T> void verifyObject(T actualObject, T expectedObject) {
        Assert.isTrue(actualObject.equals(expectedObject),
                "Objects are different. Actual: " + actualObject.toString()
                        + ", expected: " + expectedObject.toString());
    }

    @Step("Log out")
    public LoginService logout() {
        basePage.clickLogoutButton();
        return new LoginService(driver);
    }
}
