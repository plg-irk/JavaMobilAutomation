package ru.gb.tests.login;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;
import ru.gb.listeners.AllureListener;

@Listeners(AllureListener.class)
public class CheckScreenshotLoginPageTest extends BaseTest {

    @Test
    @Description("Проверяем UI страницы логин с помощью скриншота.")
    public void CheckLoginPageScreenshot() {
        openApp()
                .clickLoginMenuButton()
                .checkScreenshotLoginPage();
    }
}
