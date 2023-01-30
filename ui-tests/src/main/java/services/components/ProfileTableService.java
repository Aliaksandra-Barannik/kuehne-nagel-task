package services.components;

import driver.Driver;
import io.qameta.allure.Step;
import pages.components.DeleteItemModalWindow;
import pages.components.ProfileTable;

public class ProfileTableService extends TableService {

    private ProfileTable profileTable;

    public ProfileTableService() {
        super();
        profileTable = new ProfileTable();
    }

    @Step("Delete a book with title '{title}' from a collection")
    public void deleteItem(String title) {
        profileTable.removeBook(title);
        DeleteItemModalWindow modalWindow = new DeleteItemModalWindow();
        modalWindow.clickOkButton();
        Driver.acceptAlert();
    }
}
