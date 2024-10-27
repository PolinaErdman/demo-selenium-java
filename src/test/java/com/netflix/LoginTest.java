package com.netflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    }
}
