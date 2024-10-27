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
        String actual = loginPage.getErrorMessageText();
        String expected = LoginMessage.EMPTY_PHONE_AND_PASSWORD;
        Assertions.assertEquals(expected, actual);
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
        String actual = loginPage.getErrorMessageText();
        String expected = LoginMessage.EMPTY_PASSWORD;
        Assertions.assertEquals(expected, actual);
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
        String actual = loginPage.getErrorMessageText();
        String expected = LoginMessage.EMPTY_PHONE;
        Assertions.assertEquals(expected, actual);
    }
}
