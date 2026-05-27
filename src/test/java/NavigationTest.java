import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class NavigationTest {
    @Test
    void test01() throws InterruptedException {
        open("http://92.51.36.108:7777/sl.qa/exam_tickets/");
        $("#quantity_of_tickets").setValue("10");
        sleep(5_000);

    }
    @Test
    void test02()throws InterruptedException {
        open("https://slqa.ru/cases/ChatGPTLogin/");
        $("#username").setValue("standard_user");
        sleep(5_000);
    }
    @Test
    void test01_find_element() throws InterruptedException {
        open("http://92.51.36.108:7777/sl.qa/fc/v01/");
        $("[name=sum]").sendKeys("100");
        sleep(5_000);
    }
    @Test
    void test03() throws InterruptedException {
        open("https://ru.wikipedia.org/");
       // sleep(10_000);
        $(".main-header").shouldHave(text("Radiohead"));
        sleep(5_000);
    }
    @Test
    void test04(){
        open("https://ru.wikipedia.org/wiki/Selenium");
        $("body").shouldHave(text("инструмент"));
    }



}



