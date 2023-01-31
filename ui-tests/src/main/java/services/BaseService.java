package services;

import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Step;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import pages.Page;
import pages.components.NavigationMenu;

public class BaseService {

    protected NavigationMenu navigationMenu;
    protected Page basePage;

    public BaseService() {
        basePage = new Page();
        navigationMenu = new NavigationMenu();
    }

    @Step("Navigate to {groupTab} / {subGroupTab}")
    public <T extends BaseService> T goToPage(String groupTab, String subGroupTab, Class<T> clazz) {
        navigationMenu.openTab(groupTab, subGroupTab);
        T service;
        try {
            service = ConstructorUtils.invokeConstructor(clazz);
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
        return new LoginService();
    }
}
