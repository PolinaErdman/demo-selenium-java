package com.netflix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonSignIn() {
        By buttonSignInBy = By.xpath(LoginXpath.BUTTON_SIGN_IN_LOCATOR);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();
    }

    public String getEmailOrPhoneErrorMessageText() {
        By textEmailOrPhoneErrorMessageBy = By.xpath(LoginXpath.INVALID_EMAIL_OR_PHONE_MESSAGE_LOCATOR);
        WebElement textEmailOrPhoneErrorMessageWebElement = driver.findElement(textEmailOrPhoneErrorMessageBy);
        return textEmailOrPhoneErrorMessageWebElement.getText();
    }

    public String getPasswordErrorMessageText() {
        By textPasswordErrorMessageBy = By.xpath(LoginXpath.INVALID_PASSWORD_MESSAGE_LOCATOR);
        WebElement textPasswordErrorMessageWebElement = driver.findElement(textPasswordErrorMessageBy);
        return textPasswordErrorMessageWebElement.getText();
    }

    public void sendKeysInputEmailOrPhone(String emailOrPhone) {
        By inputEmailOrPhoneBy = By.xpath(LoginXpath.INPUT_EMAIL_OR_PHONE_LOCATOR);
        WebElement inputEmailOrPhoneWebElement = driver.findElement(inputEmailOrPhoneBy);
        inputEmailOrPhoneWebElement.sendKeys(emailOrPhone);
    }

    public void sendKeysInputPassword(String password) {
        By inputPasswordBy = By.xpath(LoginXpath.INPUT_PASSWORD_LOCATOR);
        WebElement inputPasswordWebElement = driver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys(password);
    }

    public String getCredentialsErrorMessageText() {
        By textCredentialsErrorMessageBy = By.xpath(LoginXpath.INVALID_CREDENTIALS_MESSAGE_LOCATOR);
        WebElement textCredentialsErrorMessageWebElement = driver.findElement(textCredentialsErrorMessageBy);
        return textCredentialsErrorMessageWebElement.getText();
    }
}
