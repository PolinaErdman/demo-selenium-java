package by.emall;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://emall.by/login/password");
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Empty phone and password error")
    public void testEmptyPhoneAndPassword() {
        loginPage.clickButtonCookieAccept();
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.THE_PHONE_NUMBER_FIELD_IS_REQUIRED_THE_PASSWORD_FIELD_IS_REQUIRED, loginPage.getErrorMessageText());
    }

    @Test
    @DisplayName("Empty password error")
    public void testEmptyPassword() {
        loginPage.clickButtonCookieAccept();
        loginPage.sendKeysInputPhone("331000000");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.THE_PASSWORD_FIELD_IS_REQUIRED, loginPage.getErrorMessageText());
    }

    @Test
    @DisplayName("Empty phone error")
    public void testEmptyPhone() {
        loginPage.clickButtonCookieAccept();
        loginPage.sendKeysInputPassword("testtest");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.THE_PHONE_NUMBER_FIELD_IS_REQUIRED, loginPage.getErrorMessageText());
    }

    @Test
    @DisplayName("Invalid phone and password error")
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
