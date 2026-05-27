import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

public class NavigationTestcopy {
    @Test
    void test01() throws InterruptedException {
        Configuration.browser = "firefox";
        Configuration.browserSize = "800x400";
        Configuration.browserPosition = "100x500";
        open("https://www.booking.com/");
        sleep(10_000);
        $("data-testid='header-sign-up-button").click();
        $("xDmQVL2rAys4H_iG_NdQ").setValue("azat.faezow@yandex.ru");


    }



}



