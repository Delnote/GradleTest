package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertEquals;

public class MainPageTest extends BaseTest {

    @Test
    @Description("testOne Description")
    public void testOne() {
        mainPage.open().login();
        assertEquals(1, 2);
        sleep(1500);
    }

    @Test
    @Description("testTwo Description")
    public void testTwo() {
        mainPage.open().login();
        assertEquals(1, 1);
        sleep(1500);
    }

}
