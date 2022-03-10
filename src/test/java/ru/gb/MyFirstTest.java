package ru.gb;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;


public class MyFirstTest {

    @Test
    public void CheckEmptyEmail() throws Exception {

        // Устанавливаем capabilities.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel_2_API_30");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app",
                "/Users/Leonid/Downloads/Android-NativeDemoApp-0.2.1.apk");

//      Устанавливаем и открываем приложение.
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(5000);

//      Нажимаем Login в меню
        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();
        Thread.sleep(2000);
//      Нажимаем Login на странице логин/пароль.
        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();
        Thread.sleep(2000);
//      Проверяем текст ошибки.
        MobileElement errorText = (MobileElement) driver.findElementByXPath(
                "//android.widget.ScrollView[@content-desc=\"Login-screen\"]" +
                        "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]" +
                        "/android.widget.TextView[1]");
        Assert.assertEquals(errorText.getText(), "Please enter a valid email address");

    }
}



