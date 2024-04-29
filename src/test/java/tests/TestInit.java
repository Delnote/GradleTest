package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public interface TestInit {

    @BeforeTest(alwaysRun = true)
    default void setup() {
        closeWebDriver();
        SelenideLogger.addListener("allure", new AllureSelenide());
        setWebDriver(WebDriverManager.chromedriver().create());
        getWebDriver().manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    default void tearDown() {
        closeWindow();
        closeWebDriver();
        SelenideLogger.removeListener("allure");
    }

}
