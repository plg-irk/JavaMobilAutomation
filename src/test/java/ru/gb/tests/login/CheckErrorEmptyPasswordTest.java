package ru.gb.tests.login;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListener;

@Listeners(AllureListener.class)
public class CheckErrorEmptyPasswordTest extends BaseTest {

    public static final String VALID_PASSWORD = "Please enter at least 8 characters";

    @Test
    @Description("Проверяем сообщение об ошибке при введении пустого пароля")
    public void CheckEmptyPassword() {
        openApp()
                .clickLoginMenuButton()
                .sendInputEmail()
                .clickLoginButton()
                .checkPasswordErrorText(VALID_PASSWORD);
    }
}
