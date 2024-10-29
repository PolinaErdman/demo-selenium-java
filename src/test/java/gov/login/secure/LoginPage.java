package gov.login.secure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysInputEmail(String name) {
        By inputEmailBy = By.xpath(LoginXpath.INPUT_EMAIL_LOCATOR);
        WebElement inputEmailWebElement = driver.findElement(inputEmailBy);
        inputEmailWebElement.sendKeys(name);
    }

    public void sendKeysInputPassword(String password) {
        By inputPasswordBy = By.xpath(LoginXpath.INPUT_PASSWORD_LOCATOR);
        WebElement inputPasswordWebElement = driver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys(password);
    }

    public void clickButtonSignIn() {
        By buttonSignInBy = By.xpath(LoginXpath.SIGN_IN_BUTTON_LOCATOR);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();
    }

    public String getEmptyFieldMessageText() {
        By emptyFieldErrorMessageBy = By.xpath(LoginXpath.EMPTY_FIELD_MESSAGE_LOCATOR);
        WebElement emptyFieldErrorMessageWebElement = driver.findElement(emptyFieldErrorMessageBy);
        return emptyFieldErrorMessageWebElement.getText();
    }

    public String getInvalidCredentialsMessageText() {
        By invalidCredentialsErrorMessageBy = By.xpath(LoginXpath.INVALID_CREDENTIALS_MESSAGE_LOCATOR);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsErrorMessageBy));
        WebElement invalidCredentialsErrorMessageWebElement = driver.findElement(invalidCredentialsErrorMessageBy);
        return invalidCredentialsErrorMessageWebElement.getText();
    }
}
