package ru.gb.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
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
    public MainPage openApp(String device) {
        WebDriver driver = null;
        try {
            driver = getAndroidDriver(device);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Opps, we have problems with URL for driver!");
        }
        // устанавливаем драйвер для selenide
        WebDriverRunner.setWebDriver(driver);
        // возвращаем главную страницу для будущей работы с ней в тесте
        return new MainPage();
    }

    @AfterClass
    public void setDown() {
        close();
    }

    public AndroidDriver getAndroidDriver(String device) throws MalformedURLException {
        // устанавливаем capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");

        switch (device) {
            case "Pixel2":
                capabilities.setCapability("udid", "emulator-5554");
                break;
            case "Pixel3":
                capabilities.setCapability("udid", "emulator-5556");
                break;
        }

        capabilities.setCapability("app",
                "/Users/Leonid/Downloads/Android-NativeDemoApp-0.2.1.apk");

        // папка для сохранения скриншотов selenide
        Configuration.reportsFolder = "screenshots/actual";

        // устанавливаем и открываем приложение
        return new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
    }


}
