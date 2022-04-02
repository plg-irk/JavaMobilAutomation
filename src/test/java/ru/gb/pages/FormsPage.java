package ru.gb.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

import ru.gb.locators.FormsPageLocators;

public class FormsPage {

    private FormsPageLocators locator() {
        return new FormsPageLocators();
    }

    @Step("Переключаем Switch")
    public FormsPage clickSwitchButton() {
        $(locator().formsButtonSwitch()).click();
        return new FormsPage();
    }

    @Step("Проверяем что Switch переключился")
    public FormsPage checkTextSwitchON(String text) {
        $(locator().formsTextSwitchON()).shouldHave(Condition.text(text));
        return new FormsPage();
    }


}
