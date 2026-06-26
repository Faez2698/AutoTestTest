import org.junit.jupiter.api.Test;
import pages.BookingPage;
import pages.FlightsPage;
import pages.LoginPage;
import pages.SearchPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.sleep;

public class TestExams {

    // завтрашняя дата в нужном формате
    String tomorrow() {
        return LocalDate.now().plusDays(1)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // TC-01: Успешный вход с правильными данными
    @Test
    void test01UspeshniyVhod() {
        LoginPage loginPage = new LoginPage();
        SearchPage searchPage = new SearchPage();

        loginPage.openPage();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.checkLoginFormHidden();
        searchPage.checkSearchFormVisible();
        searchPage.checkWelcomeMessage("Иванов Иван Иванович");
    }

    // TC-02: Вход с неверным паролем
    @Test
    void test02NeverniyParol() {
        LoginPage loginPage = new LoginPage();

        loginPage.openPage();
        loginPage.login("standard_user", "wrongpassword");
        loginPage.checkErrorMessage("Неверное имя пользователя или пароль");
    }

    // TC-03: Вход с пустыми полями
    @Test
    void test03PustiyePolya() {
        LoginPage loginPage = new LoginPage();

        loginPage.openPage();
        loginPage.login("", "");
        loginPage.checkErrorVisible();
    }

    // TC-04: Вход заблокированного пользователя
    @Test
    void test04ZablokirovanniyPolzovatel() {
        LoginPage loginPage = new LoginPage();

        loginPage.openPage();
        loginPage.login("locked_out_user", "lock_pass2");
        loginPage.checkErrorMessage("Пользователь заблокирован");
    }

    // TC-05: Выход из системы (Logout)
    @Test
    void test05Logout() {
        LoginPage loginPage = new LoginPage();
        SearchPage searchPage = new SearchPage();

        loginPage.openPage();
        loginPage.login("standard_user", "stand_pass1");
        searchPage.checkSearchFormVisible();
        loginPage.clickLogout();
        loginPage.checkLoginFormVisible();
        loginPage.checkFieldsCleared();
    }

    // TC-06: Поиск рейса с валидными данными
    @Test
    void test06PoiskSValidnumiDannimi() {
        LoginPage loginPage = new LoginPage();
        SearchPage searchPage = new SearchPage();
        FlightsPage flightsPage = new FlightsPage();

        loginPage.openPage();
        loginPage.login("standard_user", "stand_pass1");
        searchPage.searchFlight("moscow", "london", tomorrow());
        flightsPage.checkFlightsListVisible();
    }

    // TC-07: Рейсов не найдено
    @Test
    void test07ReysovNeNaydeno() {
        LoginPage loginPage = new LoginPage();
        SearchPage searchPage = new SearchPage();
        FlightsPage flightsPage = new FlightsPage();

        loginPage.openPage();
        loginPage.login("standard_user", "stand_pass1");
        searchPage.searchFlight("kazan", "newyork", tomorrow());
        flightsPage.checkFlightsListVisible();
        flightsPage.checkNoFlightsMessage();
    }

    // TC-08: Предзаполнение формы бронирования данными пользователя
    @Test
    void test08PredZapolnenieFormiBronirovaniya() {
        LoginPage loginPage = new LoginPage();
        SearchPage searchPage = new SearchPage();
        FlightsPage flightsPage = new FlightsPage();
        BookingPage bookingPage = new BookingPage();

        loginPage.openPage();
        loginPage.login("standard_user", "stand_pass1");
        searchPage.searchFlight("moscow", "london", tomorrow());
        flightsPage.selectFirstFlight();
        bookingPage.checkBookingFormVisible();
        bookingPage.checkFieldsPrefilled(
                "Иванов Иван Иванович",
                "1234 567890",
                "ivanov@example.com",
                "+7 (123) 456-7890"
        );
    }

    // TC-09: Валидация ФИО - латиница недопустима
    @Test
    void test09ValidatsiyaFIOLatinitsaNedopustima() {
        LoginPage loginPage = new LoginPage();
        SearchPage searchPage = new SearchPage();
        FlightsPage flightsPage = new FlightsPage();
        BookingPage bookingPage = new BookingPage();

        loginPage.openPage();
        loginPage.login("standard_user", "stand_pass1");
        searchPage.searchFlight("moscow", "london", tomorrow());
        flightsPage.selectFirstFlight();
        bookingPage.setNameAndSubmit("Ivan Ivanov");
        bookingPage.checkValidationError();
    }

    // TC-10: Кнопка "Вернуться к найденным рейсам"
    @Test
    void test10VernutsyaKNaydennimReysam() {
        LoginPage loginPage = new LoginPage();
        SearchPage searchPage = new SearchPage();
        FlightsPage flightsPage = new FlightsPage();
        BookingPage bookingPage = new BookingPage();

        loginPage.openPage();
        loginPage.login("standard_user", "stand_pass1");
        searchPage.searchFlight("moscow", "london", tomorrow());
        flightsPage.selectFirstFlight();
        bookingPage.clickBackToFlights();
        flightsPage.checkFlightsListVisible();
    }
}
