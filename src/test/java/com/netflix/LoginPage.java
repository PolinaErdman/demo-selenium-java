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
        By buttonSignInBy = By.xpath(LoginXpath.BUTTON_SIGN_IN_XPATH);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();
    }

    public String getEmailOrPhoneErrorMessageText() {
        By textEmailOrPhoneErrorMessageBy = By.xpath(LoginXpath.INVALID_EMAIL_OR_PHONE_MESSAGE_XPATH);
        WebElement textEmailOrPhoneErrorMessageWebElement = driver.findElement(textEmailOrPhoneErrorMessageBy);
        return textEmailOrPhoneErrorMessageWebElement.getText();
    }

    public String getPasswordErrorMessageText() {
        By textPasswordErrorMessageBy = By.xpath(LoginXpath.INVALID_PASSWORD_MESSAGE_XPATH);
        WebElement textPasswordErrorMessageWebElement = driver.findElement(textPasswordErrorMessageBy);
        return textPasswordErrorMessageWebElement.getText();
    }
}
