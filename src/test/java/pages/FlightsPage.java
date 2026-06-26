package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FlightsPage {

    // элементы страницы с результатами
    SelenideElement flightsList      = $("#flightsList");
    SelenideElement flightsContainer = $("#flightsContainer");

    public void checkFlightsListVisible() {
        flightsList.shouldBe(visible);
    }

    public void checkNoFlightsMessage() {
        flightsContainer.should(text("Рейсов по вашему запросу не найдено."));
    }

    public void selectFirstFlight() {
        $$("table button").first().click();
        sleep(500);
    }
}
