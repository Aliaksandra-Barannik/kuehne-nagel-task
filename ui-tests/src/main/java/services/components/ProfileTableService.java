package services.components;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.components.DeleteItemModalWindow;
import pages.components.ProfileTable;

public class ProfileTableService extends TableService {

    private ProfileTable profileTable;

    public ProfileTableService(WebDriver webDriver) {
        super(webDriver);
        profileTable = new ProfileTable(driver);
    }

    @Step("Delete a book with title '{title}' from a collection")
    public void deleteItem(String title) {
        profileTable.removeBook(title);
        DeleteItemModalWindow modalWindow = new DeleteItemModalWindow(driver);
        modalWindow.clickOkButton();
        Driver.acceptAlert();
    }
}
