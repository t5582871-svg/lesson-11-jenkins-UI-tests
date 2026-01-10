package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public static void setDate(String month, String year, String day) {
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__year-select").$(byText("1997")).click();
        $(".react-datepicker__month").$(byText("8")).click();
    }
}
