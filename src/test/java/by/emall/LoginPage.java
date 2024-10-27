package by.emall;

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

    public String getErrorMessageText() {
        By textErrorMessageBy = By.xpath(LoginXpath.ERROR_MESSAGE_XPATH);
        WebElement textErrorMessageWebElement = driver.findElement(textErrorMessageBy);
        return textErrorMessageWebElement.getText();
    }

    public void sendKeysInputPhone(String phone) {
        By inputPhoneBy = By.xpath(LoginXpath.INPUT_PHONE_XPATH);
        WebElement inputPhoneWebElement = driver.findElement(inputPhoneBy);
        inputPhoneWebElement.sendKeys(phone);
    }

    public void sendKeysInputPassword(String password) {
        By inputPasswordBy = By.xpath(LoginXpath.INPUT_PASSWORD_XPATH);
        WebElement inputPasswordWebElement = driver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys(password);
    }

    public void clickButtonCookieAccept() {
        By buttonCookieAcceptBy = By.xpath(LoginXpath.COOKIE_ACCEPT_XPATH);
        WebElement buttonCookieAcceptWebElement = driver.findElement(buttonCookieAcceptBy);
        buttonCookieAcceptWebElement.click();
    }
}
