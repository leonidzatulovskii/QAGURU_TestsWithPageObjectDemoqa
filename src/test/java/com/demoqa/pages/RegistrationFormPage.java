package com.demoqa.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.Calendar;
import com.demoqa.pages.testData.Student;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    //variables
    Calendar calendar = new Calendar();

    //locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderRadioButton = $("#genterWrapper");
    SelenideElement phoneNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobbiesCheckBox = $("#hobbiesWrapper");
    SelenideElement uploadPictureButton = $("#uploadPicture");
    SelenideElement addressInput = $("#currentAddress");
    SelenideElement stateField = $("#state");
    SelenideElement cityField = $("#city");
    SelenideElement submitButton = $("#submit");
    SelenideElement finalSheet = $(".table-responsive");

    //actions
    public RegistrationFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.executeJavaScript(
                "document.querySelector(\"footer\").hidden = 'true';" +
                        "document.querySelector(\"#fixedban\").hidden = 'true'");
        return this;
    }

    public RegistrationFormPage fillForm(Student student) {
        firstNameInput.setValue(student.getFirstName());
        lastNameInput.setValue(student.getLastName());
        emailInput.setValue(student.getEmail());
        setGender(student.getGender());
        phoneNumberInput.setValue(student.getPhoneNumber());
        dateOfBirthInput.click();
        calendar.calendarDateSelect(student.getYear(), student.getMonth(), student.getDay());
        subjectsInput.setValue(student.getSubject()).pressEnter();
        setHobby(student.getHobby());
        uploadPictureButton.uploadFromClasspath(student.getFilePath());
        addressInput.setValue(student.getCurrentAddress());
        stateField.click();
        setState(student.getState());
        cityField.click();
        setCity(student.getCity());
        submitButton.click();

        return this;
    }

    public RegistrationFormPage checkForm(Student student) {
        checkField("Student Name", student.getFirstName() + " " + student.getLastName());
        checkField("Student Email", student.getEmail());
        checkField("Gender", student.getGender());
        checkField("Mobile", student.getPhoneNumber());
        checkField("Date of Birth", student.getDay() + " " + student.getMonth() + "," + student.getYear());
        checkField("Subjects", student.getSubject());
        checkField("Hobbies", student.getHobby());
        checkField("Picture", student.getFilePath());
        checkField("Address", student.getCurrentAddress());
        checkField("State and City", student.getState() + " " + student.getCity());

        return this;
    }

    public void setGender(String gender) {
        genderRadioButton.$(byText(gender)).click();
    }

    public void setHobby(String hobby) {
        hobbiesCheckBox.$(byText(hobby)).click();
    }

    public void setState(String state) {
        $(byText(state)).click();
    }

    public void setCity(String city) {
        $(byText(city)).click();
    }

    public void checkField(String key, String value) {
        finalSheet.$(byText(key)).sibling(0).shouldHave(text(value));
    }
}
