package ru.gb.locators.Android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import ru.gb.interfaces.FormsPageLocators;

public class AndroidFormsPageLocators implements FormsPageLocators {

    public By formsButtonSwitch() {
        return MobileBy.AccessibilityId("switch");
    }

    public By formsTextSwitchON() {
        return MobileBy.xpath(
                "//android.widget.TextView[@content-desc=\"switch-text\"]");
    }


}

