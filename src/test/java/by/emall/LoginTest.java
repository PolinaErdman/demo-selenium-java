package by.emall;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://emall.by/login/password");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testEmptyPhoneAndPassword() {
        loginPage.clickButtonCookieAccept();
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.THE_PHONE_NUMBER_FIELD_IS_REQUIRED_THE_PASSWORD_FIELD_IS_REQUIRED, loginPage.getErrorMessageText());
    }

    @Test
    public void testEmptyPassword() {
        loginPage.clickButtonCookieAccept();
        loginPage.sendKeysInputPhone("331000000");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.THE_PASSWORD_FIELD_IS_REQUIRED, loginPage.getErrorMessageText());
    }

    @Test
    public void testEmptyPhone() {
        loginPage.clickButtonCookieAccept();
        loginPage.sendKeysInputPassword("testtest");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.THE_PHONE_NUMBER_FIELD_IS_REQUIRED, loginPage.getErrorMessageText());
    }

    @Test
    public void testInvalidCredentials() {
        loginPage.clickButtonCookieAccept();
        loginPage.sendKeysInputPhone("331000000");
        loginPage.sendKeysInputPassword("testtest");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.INVALID_LOGIN_OR_PASSWORD, loginPage.getErrorMessageText());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
