package com.netflix;

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
        driver.get("https://www.netflix.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testEmptyCredentials() {
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.PROVIDE_VALID_EMAIL_ADDRESS_OR_PHONE_NUMBER, loginPage.getEmailOrPhoneErrorMessageText());
        Assertions.assertEquals(LoginMessage.PASSWORD_MUST_CONTAIN_FROM_4_TO_60_CHARACTERS, loginPage.getPasswordErrorMessageText());
    }

    @Test
    public void testEmptyPassword() {
        loginPage.sendKeysInputEmailOrPhone("test@test.com");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.PASSWORD_MUST_CONTAIN_FROM_4_TO_60_CHARACTERS, loginPage.getPasswordErrorMessageText());
    }

    @Test
    public void testEmptyEmailOrPhone() {
        loginPage.sendKeysInputPassword("testpassword");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.PROVIDE_VALID_EMAIL_ADDRESS_OR_PHONE_NUMBER, loginPage.getEmailOrPhoneErrorMessageText());
    }

    @Test
    public void testInvalidCredentials() {
        String email = "test@test.com";
        loginPage.sendKeysInputEmailOrPhone(email);
        loginPage.sendKeysInputPassword("testpassword");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(String.format(LoginMessage.INVALID_PASSWORD_FOR_EMAIL_OR_PHONE, email), loginPage.getCredentialsErrorMessageText());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
