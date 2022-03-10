package ru.gb;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class MySecondTest {

    @Test
    public void CheckEmptyEmail() throws Exception {

        // Устанавливаем capabilities.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel_2_API_30");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("udid", "emulator-5554");
//        capabilities.setCapability("automationName", "UiAutomator3");
//        Пример для предустановленного приложения.
        capabilities.setCapability("appPackage", "com.google.android.apps.maps");
        capabilities.setCapability("appActivity", "com.google.android.maps.MapsActivity");
        capabilities.setCapability("noReset", true);

//      Устанавливаем и открываем приложение.
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(5000);

        MobileElement el3 = (MobileElement) driver.findElementById(
                "com.google.android.apps.maps:id/search_omnibox_text_box");
        el3.click();
        Thread.sleep(2000);

        MobileElement el5 = (MobileElement) driver.findElementById("com.google.android.apps.maps:id/search_omnibox_edit_text");
        el5.sendKeys("Irkutsk");
        Thread.sleep(5000);

        MobileElement el6 = (MobileElement) driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
                        "/android.widget.FrameLayout/android.widget.LinearLayout" +
                        "/android.widget.FrameLayout/android.widget.FrameLayout" +
                        "/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout" +
                        "/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout" +
                        "/android.widget.LinearLayout/android.widget.FrameLayout" +
                        "/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]" +
                        "/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.View");
        el6.click();
        Thread.sleep(10000);

        MobileElement el7 = (MobileElement) driver.findElementById("com.google.android.apps.maps:id/title");
        Assert.assertEquals(el7.getText(), "Irkutsk");

    }
}



