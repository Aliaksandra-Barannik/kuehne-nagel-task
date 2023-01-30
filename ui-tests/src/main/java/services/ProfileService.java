package services;


import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Step;
import pages.ProfilePage;
import services.components.ProfileTableService;

public class ProfileService extends BaseService {

    private ProfilePage profilePage;

    public ProfileService() {
        super();
        profilePage = new ProfilePage();
    }

    public ProfileTableService table() {
        return new ProfileTableService();
    }

    @Step("Verify if a book '{title}' is in a collection.")
    public void verifyIfBookInCollection(String title, boolean shouldBe) {
        profilePage.searchBookByText(title);
        boolean isPresent = !table().isTableEmpty();
        Assert.isTrue(isPresent == shouldBe,
                "Verify if book is in collection. Actual: " + shouldBe + ", expected: " + isPresent);
    }

}
