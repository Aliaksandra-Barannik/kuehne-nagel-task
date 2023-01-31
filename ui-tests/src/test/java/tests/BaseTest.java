package tests;

import driver.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import services.BaseService;
import services.LoginService;
import utils.Configuration;

public class BaseTest {

    private static WebDriver driver;
    protected LoginService loginService;
    protected BaseService baseService;

    @BeforeAll
    public static void setUp() {
        driver = Driver.getWebDriverInstance();
        driver.get(Configuration.getUrl() + "/login");
    }

    @BeforeEach
    public void init() {
        baseService = new BaseService(driver);
        loginService = new LoginService(driver);
    }

    @AfterAll
    public static void tearDown() {
        Driver.tearDown();
    }
}
