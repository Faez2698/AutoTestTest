import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SimpleWikiTest {
    @Test
    void test01() {
        open("https://ya.ru/");
        sleep(3_000);
        open("https://ria.ru/");
        sleep(3_000);
        open("https://ria.ru/incidents/");
        sleep(3_000);
        back();
        sleep(3_000);
        back();
        sleep(3_000);
        open("https://kazan.hh.ru/");
        sleep(10_000);
        open("https://kazan.hh.ru/search/resume");
        sleep(10_000);
        back();
        sleep(3_000);
        forward();
        sleep(3_000);
    }

}