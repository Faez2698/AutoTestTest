package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BookingPage {

    // элементы формы бронирования
    SelenideElement bookingForm         = $("#registrationForm");
    SelenideElement nameField           = $("#passengerName");
    SelenideElement passportField       = $("#passportNumber");
    SelenideElement emailField          = $("#email");
    SelenideElement phoneField          = $("#phone");
    SelenideElement submitButton        = $("button[onclick='completeRegistration()']");
    SelenideElement backButton          = $(".back-to-flights-btn");
    SelenideElement registrationMessage = $("#registrationMessage");

    public void checkBookingFormVisible() {
        bookingForm.shouldBe(visible);
    }

    public void checkFieldsPrefilled(String name, String passport,
                                      String email, String phone) {
        nameField.shouldHave(value(name));
        passportField.shouldHave(value(passport));
        emailField.shouldHave(value(email));
        phoneField.shouldHave(value(phone));
    }

    public void setNameAndSubmit(String name) {
        nameField.clear();
        nameField.setValue(name);
        submitButton.click();
        sleep(500);
    }

    public void checkValidationError() {
        registrationMessage.should(exist);
        registrationMessage.shouldNotHave(text("успешно"));
    }

    public void clickBackToFlights() {
        backButton.click();
        sleep(500);
    }
}
