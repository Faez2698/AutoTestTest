import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestLogin {
    @Test
    void test01(){
        open("https://slqa.ru/cases/ChatGPTLogin/");
        sleep(2000);
        $("#username").should(exist);
        $("#username").setValue("standard_user");
        sleep(2000);
        $("#password").setValue("secret_sauce");
        $("#loginButton").click();
        sleep(10000);



    }

}
