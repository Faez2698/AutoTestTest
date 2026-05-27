import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class WorkAutotes1part2 {
    @Test
    void test01() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "800x400";
        Configuration.browserPosition = "100x500";


    }

}
