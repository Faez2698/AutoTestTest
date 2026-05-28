import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Test2Login {
    @Test
    void test01UspeshniyloginUspeshniyParol() {
        open("https://www.saucedemo.com/");
        $("#user-name").should(exist);
        $("#user-name").setValue("visual_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $(".title").should(exist);
        $(".title").should(text("Products"));


    }
    @Test

    void test02UspeshniyloginNeuspeshniyParol() {
        open("https://www.saucedemo.com/");
        $("#user-name").should(exist);
        $("#user-name").setValue("visual_user");
        $("#password").setValue("secret_sauce1");
        $("#login-button").click();
        $(".error-message-container").should(exist);
        $(".error-message-container").should(text("Epic sadface: Username and password do not match any user in this service"));


    }
    @Test
    void test03PustiyePolya() {
        open("https://www.saucedemo.com/");
        $("#login-button").click();
        $(".error-message-container").should(exist);
        $(".error-message-container").should(text("Epic sadface: Username is required"));

    }
    @Test
    void test04UspeshniyloginPustoyParol() {
        open("https://www.saucedemo.com/");
        $("#user-name").should(exist);
        $("#user-name").setValue("standard_user");
        $("#login-button").click();
        $(".error-message-container").should(exist);
        $(".error-message-container").should(text("Epic sadface: Password is required"));

    }
    @Test
    void test05ZablokirovanniyLogin() {
        open("https://www.saucedemo.com/");
        $("#user-name").should(exist);
        $("#user-name").setValue("locked_out_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $(".error-message-container").should(exist);
        $(".error-message-container").should(text("Epic sadface: Sorry, this user has been locked out."));

    }
}
