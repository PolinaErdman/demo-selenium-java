package by.emall;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    @Test
    public void testEmptyPhoneAndPassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://emall.by/login/password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickButtonCookieAccept();
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.THE_PHONE_NUMBER_FIELD_IS_REQUIRED_THE_PASSWORD_FIELD_IS_REQUIRED, loginPage.getErrorMessageText());
    }

    @Test
    public void testEmptyPassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://emall.by/login/password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickButtonCookieAccept();
        loginPage.sendKeysInputPhone("331000000");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.THE_PASSWORD_FIELD_IS_REQUIRED, loginPage.getErrorMessageText());
    }

    @Test
    public void testEmptyPhone() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://emall.by/login/password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickButtonCookieAccept();
        loginPage.sendKeysInputPassword("testtest");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.THE_PHONE_NUMBER_FIELD_IS_REQUIRED, loginPage.getErrorMessageText());
    }

    @Test
    public void testInvalidCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://emall.by/login/password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickButtonCookieAccept();
        loginPage.sendKeysInputPhone("331000000");
        loginPage.sendKeysInputPassword("testtest");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.INVALID_LOGIN_OR_PASSWORD, loginPage.getErrorMessageText());
    }
}