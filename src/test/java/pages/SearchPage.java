package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    // элементы формы поиска
    SelenideElement searchForm      = $("#flightForm");
    SelenideElement header          = $(".header");
    SelenideElement fromCity        = $("#departureCity");
    SelenideElement toCity          = $("#arrivalCity");
    SelenideElement departureDate   = $("#departureDate");
    SelenideElement searchButton    = $("button[onclick='findFlights()']");

    public void checkSearchFormVisible() {
        searchForm.shouldBe(visible);
    }

    public void checkWelcomeMessage(String fullName) {
        header.should(text(fullName));
    }

    public void searchFlight(String fromValue, String toValue, String date) {
        fromCity.selectOptionByValue(fromValue);
        toCity.selectOptionByValue(toValue);
        departureDate.setValue(date);
        searchButton.click();
        sleep(1000);
    }
}
