package ru.gb.tests.forms;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ru.gb.base.BaseTest;

public class CheckSwitchONTest  extends BaseTest {

    public static final String VALUE_SWITCH_OFF = "Click to turn the switch OFF";

    @Test
    @Description("Проверяем переключение кнопки Switch")
    public void checkSwitchButtonON() {

        openApp()
                .clickFormsMenuButton()
                .clickSwitchButton()
                .checkTextSwitchON(VALUE_SWITCH_OFF);

    }
}
