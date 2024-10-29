package gov.login.secure;

public class LoginXpath {
    public static final String INPUT_EMAIL_LOCATOR = "//input[@id='user_email']";
    public static final String INPUT_PASSWORD_LOCATOR = "//input[@name='user[password]']";
    public static final String SIGN_IN_BUTTON_LOCATOR = "//button[@name='button']";
    public static final String EMPTY_FIELD_MESSAGE_LOCATOR = "//div[@class='usa-error-message']";
    public static final String INVALID_CREDENTIALS_MESSAGE_LOCATOR = "//div[@class='usa-alert__body']";
}
