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
    @Description("Проверяем сообщение об ошибке при введении пустого пароля для Pixel2")
    public void CheckEmptyPasswordPixel2() {
        openApp("Pixel2")
                .clickLoginMenuButton()
                .sendInputEmail()
                .clickLoginButton()
                .checkPasswordErrorText(VALID_PASSWORD);
    }

    @Test
    @Description("Проверяем сообщение об ошибке при введении пустого пароля для Pixel3")
    public void CheckEmptyPasswordPixel3() {
        openApp("Pixel3")
                .clickLoginMenuButton()
                .sendInputEmail()
                .clickLoginButton()
                .checkPasswordErrorText(VALID_PASSWORD);
    }
}
