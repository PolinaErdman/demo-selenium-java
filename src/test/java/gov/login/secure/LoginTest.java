package gov.login.secure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://secure.login.gov/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testEmptyField() {
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.EMPTY_FIELD, loginPage.getEmptyFieldMessageText());
    }

    @Test
    public void testEmptyPassword() {
        loginPage.sendKeysInputEmail("testA@test.com");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.EMPTY_FIELD, loginPage.getEmptyFieldMessageText());
    }

    @Test
    public void testEmptyEmail() {
        loginPage.sendKeysInputPassword("testPassword");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.EMPTY_FIELD, loginPage.getEmptyFieldMessageText());
    }

    @Test
    public void testInvalidCredentials() {
        loginPage.sendKeysInputEmail("testA@test.com");
        loginPage.sendKeysInputPassword("testPassword");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.INVALID_CREDENTIALS, loginPage.getInvalidCredentialsMessageText());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
