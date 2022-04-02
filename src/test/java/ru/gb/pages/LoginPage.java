package ru.gb.pages;

import com.codeborne.selenide.Condition;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import io.qameta.allure.Step;
import ru.gb.interfaces.LoginPageLocators;
import ru.gb.locators.LocatorService;

import java.awt.image.BufferedImage;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class LoginPage {

    public static String VALUE_EMAIL = "qwer@gb.ru";

    // Метод позволяет работать с локаторами для нужной нам страницы.
    private LoginPageLocators locator() {
        return LocatorService.LOGIN_PAGE_LOCATORS;
    }

    @Step("Кликаем по кнопке 'логин' в форме")
    public LoginPage clickLoginButton() {
        $(locator().loginButton()).click();
        return new LoginPage();
    }

    @Step("Проверяем текст ошибки")
    public LoginPage checkLoginErrorText(String text) {
        $(locator().loginErrorText()).shouldHave(Condition.text(text));
        return new LoginPage();
    }

    @Step("Передаем валидный адрес в поле email")
    public LoginPage sendInputEmail() {
        $($(locator().inputEmail())).sendKeys(VALUE_EMAIL);
        return new LoginPage();
    }

    @Step("Проверяем текст ошибки пароля")
    public LoginPage checkPasswordErrorText(String text) {
        $(locator().passwordErrorText()).shouldHave(Condition.text(text));
        return new LoginPage();
    }

    @Step("Делаем скриншот логин вкладки и сравниваем с требованием.")
    public LoginPage checkScreenshotLoginPage() {
        // Загружаем ожидаемое изображения для сравнения.
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources(
                "src/main/resources/expectedScreenshots/loginPage.png");
        // Делаем актуальный скриншот, используя элемент и игнорируя другие части экрана.
        File actualScreenshot = $(locator().fieldLogin()).screenshot();
        // Загружаем актуальный скриншот.
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources(
                "screenshots/actual/" + actualScreenshot.getName());

        // Где будем хранить скриншот с различиями в случае падения теста.
        File resultDestination = new File("diff/diff_CheckLoginPageScreenshot.png");

        // Сравниваем.
        ImageComparisonResult imageComparisonResult =
                new ImageComparison(expectedImage, actualImage, resultDestination)
                        .compareImages();
        assertEquals(ImageComparisonState.MATCH, imageComparisonResult.getImageComparisonState());
        return this;
    }

}


