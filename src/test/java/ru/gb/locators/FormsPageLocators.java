package ru.gb.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FormsPageLocators {

    public By formsButtonSwitch() {
        return MobileBy.AccessibilityId("switch");
    }

    public By formsTextSwitchON() {
        return MobileBy.xpath(
                "//android.widget.TextView[@content-desc=\"switch-text\"]");
    }


}

