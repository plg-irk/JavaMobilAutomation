package ru.gb;

import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class ScreenshotHelperLoginPage extends BaseTest {

    @Test
    public void createScreen() {
        openApp()
                .clickLoginMenuButton();
        File actualScreenshot = $(MobileBy.xpath(
                "//android.widget.ScrollView[@content-desc=\"Login-screen\"]" +
                        "/android.view.ViewGroup/android.view.ViewGroup" +
                        "/android.view.ViewGroup[4]")).screenshot();
    }
}
