package ru.gb.locators.Android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import ru.gb.interfaces.MainPageLocators;

public class AndroidMainPageLocators implements MainPageLocators {

    public By loginButton() {
        return By.xpath("//android.view.ViewGroup[@content-desc=\"Login\"]" +
                "/android.widget.TextView");
    }

    public By formsButton() {
        return MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Forms\"]" +
                "/android.widget.TextView");
    }

    public By homeScreen() {
        return MobileBy.AccessibilityId("Home-screen");
    }

}
