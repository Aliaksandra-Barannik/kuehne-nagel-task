package services;


import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProfilePage;
import services.components.ProfileTableService;

public class ProfileService extends BaseService {

    private ProfilePage profilePage;

    public ProfileService(WebDriver webDriver) {
        super(webDriver);
        profilePage = new ProfilePage(driver);
    }

    public ProfileTableService table() {
        return new ProfileTableService(driver);
    }

    @Step("Verify if a book '{title}' is in a collection.")
    public void verifyIfBookInCollection(String title, boolean shouldBe) {
        profilePage.searchBookByText(title);
        boolean isPresent = !table().isTableEmpty();
        Assert.isTrue(isPresent == shouldBe,
                "Verify if book is in collection. Actual: " + shouldBe + ", expected: " + isPresent);
    }

}
