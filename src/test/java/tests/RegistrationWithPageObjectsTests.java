package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
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
                .checkResult("Timur Dasaev")
                .checkResult("email@example.ru")
                .checkResult("Other")
                .checkResult("8800555353")
                .checkResult("8 January,1997")
                .checkResult("English")
                .checkResult("Reading")
                .checkResult("artworks.jpg")
                .checkResult("New York")
                .checkResult("NCR Delhi");

    }

    @Test
    void minFillFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName("Timur")
                .setLastName("Dasaev")
                .setEmail("email@example.ru")
                .setGender("Other")
                .setUserNumber("8800555353")
                .setSubmit()
                .checkResult("Timur Dasaev")
                .checkResult("email@example.ru")
                .checkResult("Other")
                .checkResult("8800555353");
    }
    @Test
    void negativeFillFormTest() {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstName("Timur")
                .setLastName("Dasaev")
                .setEmail("emailfhzfdhzdfh")
                .setGender("Other")
                .setUserNumber("8800555353")
                .setSubmit()
                .getModalDialog();
    }
}