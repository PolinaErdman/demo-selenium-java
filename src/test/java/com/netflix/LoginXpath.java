package com.netflix;

public class LoginXpath {
    public static final String INPUT_EMAIL_OR_PHONE_LOCATOR = "//input[@name='userLoginId']";
    public static final String INPUT_PASSWORD_LOCATOR = "//input[@name='password']";
    public static final String BUTTON_SIGN_IN_LOCATOR = "//button[@type='submit']";
    public static final String INVALID_EMAIL_OR_PHONE_MESSAGE_LOCATOR = "//div[@data-uia='login-field+validationMessage']";
    public static final String INVALID_PASSWORD_MESSAGE_LOCATOR = "//div[@data-uia='password-field+validationMessage']";
    public static final String INVALID_CREDENTIALS_MESSAGE_LOCATOR = "//div[@data-uia='error-message-container+header']";
}
