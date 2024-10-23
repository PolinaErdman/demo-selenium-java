package gov.login.secure;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://secure.login.gov/");

        String buttonSignInXpath = "/html/body/main/div/form/lg-submit-button/button";
        By buttonSignInBy = By.xpath(buttonSignInXpath);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();
    }

    @Test
    public void test2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://secure.login.gov/");

        String inputEmailXpath = "/html/body/main/div/form/lg-validated-field/div/input";
        By inputEmailBy = By.xpath(inputEmailXpath);
        WebElement inputEmailWebElement = driver.findElement(inputEmailBy);
        inputEmailWebElement.sendKeys("testA@test.com");

        String buttonSignInXpath = "/html/body/main/div/form/lg-submit-button/button";
        By buttonSignInBy = By.xpath(buttonSignInXpath);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();
    }

    @Test
    public void test3() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://secure.login.gov/");

        String inputPasswordXpath = "/html/body/main/div/form/lg-password-toggle/lg-validated-field/div/input";
        By inputPasswordBy = By.xpath(inputPasswordXpath);
        WebElement inputPasswordWebElement = driver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys("1q2w#E4r");

        String buttonSignInXpath = "/html/body/main/div/form/lg-submit-button/button";
        By buttonSignInBy = By.xpath(buttonSignInXpath);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();
    }
}
