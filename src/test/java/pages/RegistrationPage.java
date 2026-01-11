package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.components.CalendarComponent;
import pages.components.TableResult;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {


    private final SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            userEmailinput = $("#userEmail"),
                            userNumberInput = $("#userNumber"),
                            genderWrapper = $("#genterWrapper"),
                            calendarInput = $("#dateOfBirthInput"),
                            subjects = $("#subjectsContainer input"),
                            Hobbies = $("#hobbiesWrapper"),
                            uploadPicture = $("#uploadPicture"),
                            currentAddress = $("#currentAddress"),
                            state = $("#state"),
                            stateCity = $("#stateCity-wrapper"),
                            cityDropdown = $("#city"),
                            submit = $("#submit"),
                            modalDialog = $(".modal-dialog");

    CalendarComponent calendarComponent =  new CalendarComponent();
    TableResult tableResult =  new TableResult();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailinput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setBithDay(String month, String year, String day) {
        calendarInput.click();
        calendarComponent.setDate(month, year, day);
        return this;
    }
    public RegistrationPage setSubjects(String value) {
        subjects.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        Hobbies.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationPage setState(){
        state.click();
        return this;
    }
    public RegistrationPage setStateCity(String value){
        stateCity.$(byText(value)).click();
        return this;
    }
    public  RegistrationPage setCityDropdown() {
        cityDropdown.click();
        return this;
    }
    public RegistrationPage setSubmit() {
        submit.click();
        return this;
    }
    public RegistrationPage checkResult(String value) {
        tableResult.checkTable(value);
        return this;
    }
    public RegistrationPage getModalDialog() {
        modalDialog.shouldNotBe(visible);
        return this;
    }
}






