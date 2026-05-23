package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName ("Полное заполнение анкеты")
    void fillFormTest() {
        step("Открытие страницы", () ->
        registrationPage
                .openPage()
                .removeBanner()
    );
        step("Ввод данных", () ->
        registrationPage
                .setFirstName("Timur")
                .setLastName("Dasaev")
                .setEmail("email@example.ru")
                .setGender("Other")
                .setUserNumber("8800555353")
                .setBithDay("January", "1997", "8")
                .setSubjects("English")
                .setHobbies("Reading")
                .setUploadPicture("artworks.jpg")
                .setCurrentAddress("New York")
                .setState()
                .setStateCity("NCR")
                .setCityDropdown()
                .setStateCity("Delhi")
                .setSubmit()
        );
        step("Проверка результатов", () ->
                registrationPage
                .checkResult("Timur Dasaev")
                .checkResult("email@example.ru")
                .checkResult("Other")
                .checkResult("8800555353")
                .checkResult("8 January,1997")
                .checkResult("English")
                .checkResult("Reading")
                .checkResult("artworks.jpg")
                .checkResult("New York")
                .checkResult("NCR Delhi")
        );

    }

    @Test
    @DisplayName ("Мин. допустимое заполнение анкеты")
    void minFillFormTest() {
        step("Открытие страницы", () ->
                registrationPage
                        .openPage()
                        .removeBanner()
        );
        step("Ввод данных", () ->
                registrationPage
                .setFirstName("Timur")
                .setLastName("Dasaev")
                .setEmail("email@example.ru")
                .setGender("Other")
                .setUserNumber("8800555353")
                .setSubmit()
        );
        step("Проверка результатов", () ->
                registrationPage
                .checkResult("Timur Dasaev")
                .checkResult("email@example.ru")
                .checkResult("Other")
                .checkResult("8800555353")
        );
    }
    @Test
    @DisplayName ("Негативная проверка анкеты")
    void negativeFillFormTest() {
        step("Открытие страницы", () ->
                registrationPage
                        .openPage()
                        .removeBanner()
        );
        step("Ввод данных", () ->
                registrationPage
                .setFirstName("Timur")
                .setLastName("Dasaev")
                .setEmail("emailfhzfdhzdfh")
                .setGender("Other")
                .setUserNumber("8800555353")
        );
        step("Проверка результатов", () ->
                registrationPage
                .setSubmit()
                .getModalDialog()
                );
    }
}