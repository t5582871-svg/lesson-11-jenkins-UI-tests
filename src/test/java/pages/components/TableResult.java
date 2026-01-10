package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResult {
    public void checkTable(String value) {
        $(".table-responsive").shouldHave(text(value));
    }
}
