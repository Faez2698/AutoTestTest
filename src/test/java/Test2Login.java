import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class Test2Login {
    @Test
    void test01() {
        open("https://www.saucedemo.com/");
        sleep(2000);
        $("#user-name").should(exist);
        $("#user-name").setValue("visual_user");
        sleep(2000);
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        sleep(10000);


    }
    @Test

    void test02() {
        open("https://www.saucedemo.com/");
        sleep(2000);
        $("#user-name").should(exist);
        $("#user-name").setValue("visual_user");
        sleep(2000);
        $("#password").setValue("secret_sauce1");
        $("#login-button").click();
        sleep(10000);

    }
    @Test
    void test03() {
        open("https://www.saucedemo.com/");
        sleep(2000);
        $("#login-button").click();
        sleep(10000);
    }
    @Test
    void test04() {
        open("https://www.saucedemo.com/");
        sleep(2000);
        $("user-name").should(exist);
        $("user-name").setValue("locked_out_user");
        sleep(2000);
        $("#login-button").click();
        sleep(10000);
    }
    @Test
    void test05() {
        open("https://www.saucedemo.com/");
        sleep(2000);
        $("#user-name").should(exist);
        $("#user-name").setValue("problem_user");
        sleep(2000);
        $("#login-button").click();
        sleep(10000);
    }
}
