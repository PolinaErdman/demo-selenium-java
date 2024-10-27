package by.emall;

public class LoginMessage {
    public static final String EMPTY_PHONE = "Значение поля \"Номер телефона\" должно начинаться с +375 затем код (25|29|33|44) и далее 7 цифр (первая из которых не 0)";
    public static final String EMPTY_PASSWORD = "Поле \"Пароль\" обязательно для заполнения.";
    public static final String EMPTY_PHONE_AND_PASSWORD = "Значение поля \"Номер телефона\" должно начинаться с +375 затем код (25|29|33|44) и далее 7 цифр (первая из которых не 0)\n" +
            "Поле \"Пароль\" обязательно для заполнения.";
    public static final String INVALID_CREDENTIALS = "Неверный логин или пароль";
}
