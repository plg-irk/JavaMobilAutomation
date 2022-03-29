package ru.gb.tests.login;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.listeners.AllureListener;
import ru.gb.base.BaseTest;

@Listeners(AllureListener.class)
public class CheckErrorTextTest extends BaseTest {

    public static final String VALID_EMAIL_ADDRESS = "Please enter a valid email address";

    @Test
    @Description("Проверяем сообщение об ошибке при невалидной email  для Pixel3")
    public void CheckEmptyEmailPixel3() {
        openApp("Pixel3")
                .clickLoginMenuButton()
                .clickLoginButton()
                .checkLoginErrorText(VALID_EMAIL_ADDRESS);
    }
}


