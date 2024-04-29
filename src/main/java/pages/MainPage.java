package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.stereotype.Service;

import static com.codeborne.selenide.Selenide.$;

@Service
public class MainPage {

    private final SelenideElement loginLink = $(".FPdoLc .RNmpXc").as("loginLink");

    @Step("Step for login")
    public void login() {
        loginLink.doubleClick();
    }

    @Step("Step for open google")
    public MainPage open() {
        Selenide.open("http://google.com");
        return this;
    }

}
