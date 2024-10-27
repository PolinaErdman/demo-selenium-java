package com.netflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.INVALID_EMAIL_OR_PHONE, loginPage.getEmailOrPhoneErrorMessageText());
        Assertions.assertEquals(LoginMessage.INVALID_PASSWORD, loginPage.getPasswordErrorMessageText());
    }

    @Test
    public void test2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeysInputEmailOrPhone("test@test.com");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.INVALID_PASSWORD, loginPage.getPasswordErrorMessageText());
    }

    @Test
    public void test3() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeysPassword("testpassword");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.INVALID_EMAIL_OR_PHONE, loginPage.getEmailOrPhoneErrorMessageText());
    }

    @Test
    public void test4() throws InterruptedException {
        String email = "test@test.com";
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendKeysInputEmailOrPhone(email);
        loginPage.sendKeysPassword("testpassword");
        loginPage.clickButtonSignIn();
        Thread.sleep(500);
        Assertions.assertEquals(String.format(LoginMessage.INVALID_CREDENTIALS, email), loginPage.getCredentialsErrorMessageText());
    }
}
