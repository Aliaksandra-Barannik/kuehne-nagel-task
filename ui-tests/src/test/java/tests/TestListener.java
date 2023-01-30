package tests;

import static org.openqa.selenium.OutputType.BYTES;

import driver.Driver;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestListener implements TestWatcher {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(BYTES);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        saveScreenshot(Driver.getWebDriverInstance());
    }
}
