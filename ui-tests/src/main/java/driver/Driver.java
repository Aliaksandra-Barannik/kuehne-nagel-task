package driver;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Driver {

    private static final int IMPLICIT_WAIT = 5;
    private static final int EXPLICIT_WAIT = 10;
    private static WebDriver webDriver;

    public static WebDriver getWebDriverInstance() {
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }

    public static void tearDown() {
        try {
            webDriver.quit();
        } catch (Exception e) {
            throw new RuntimeException("Cannot close browser", e);
        }
    }

    public static boolean waitForElementVisibility(WebElement elt) {
        boolean isVisible;
        try {
            getWaiter().until(ExpectedConditions.visibilityOf(elt));
            isVisible = true;
        } catch (StaleElementReferenceException | TimeoutException | NoSuchElementException e) {
            isVisible = false;
        }
        return isVisible;
    }

    public static void waitForAlertAppear() {
        getWaiter().until(ExpectedConditions.alertIsPresent());
    }

    public static void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToElement(WebElement elt) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", elt);
    }

    public static void acceptAlert() {
        waitForAlertAppear();
        webDriver.switchTo().alert().accept();
    }

    public static Wait<WebDriver> getWaiter() {
        return new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(EXPLICIT_WAIT))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .ignoring(NullPointerException.class);
    }
}
