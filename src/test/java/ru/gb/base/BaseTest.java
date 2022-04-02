package ru.gb.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import ru.gb.pages.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.close;

// базовый класс для всех будущих тестов
public class BaseTest {

    // метод, который будет открывать наше приложение на телефоне
    public MainPage openApp() {
        WebDriver driver = null;
        try {
            driver = getAppiumDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Opps, we have problems with URL for driver!");
        }
        // устанавливаем драйвер для selenide
        WebDriverRunner.setWebDriver(driver);
        // возвращаем главную страницу для будущей работы с ней в тесте
        return new MainPage();
    }

    public static WebDriver getAppiumDriver() throws MalformedURLException {
        // устанавливаем capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (System.getProperty("platform")) {
            case "Android":
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "Pixel_2_API_30");
                capabilities.setCapability("platformVersion", "11");
                capabilities.setCapability("udid", "emulator-5554");
                capabilities.setCapability("automationName", "UiAutomator2");
                capabilities.setCapability(
                        "app", "/Users/Leonid/Downloads/Android-NativeDemoApp-0.2.1.apk");
                break;
            case "iOS":
                // устанавливаем capabilities.
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("deviceName", "iPhone");
                capabilities.setCapability("platformVersion", "15");
                capabilities.setCapability("udid", "2E20F3A4-ACC1-4799-A4F5-83358E56AB2E");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability(
                        "app", "/Users/Leonid/Downloads/Android-NativeDemoApp-0.2.1.apk");
                break;
        }

        // папка для сохранения скриншотов selenide
        Configuration.reportsFolder = "screenshots/actual";
        // устанавливаем и открываем приложение
        return new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public void setDown() {
        close();
    }
}
