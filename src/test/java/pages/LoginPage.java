package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    // элементы страницы входа
    SelenideElement usernameField = $("#username");
    SelenideElement passwordField = $("#password");
    SelenideElement loginButton   = $("#loginButton");
    SelenideElement errorMessage  = $("#message");
    SelenideElement loginForm     = $("#loginContainer");

    public void openPage() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        sleep(1000);
    }

    public void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
        sleep(1000);
    }

    public void clickLogout() {
        $("button[onclick='logout()']").click();
        sleep(500);
    }

    public void checkLoginFormHidden() {
        loginForm.shouldBe(hidden);
    }

    public void checkLoginFormVisible() {
        loginForm.shouldNotBe(hidden);
    }

    public void checkFieldsCleared() {
        usernameField.shouldHave(value(""));
        passwordField.shouldHave(value(""));
    }

    public void checkErrorMessage(String expectedText) {
        errorMessage.should(exist);
        errorMessage.should(text(expectedText));
    }

    public void checkErrorVisible() {
        errorMessage.shouldBe(visible);
    }
}
