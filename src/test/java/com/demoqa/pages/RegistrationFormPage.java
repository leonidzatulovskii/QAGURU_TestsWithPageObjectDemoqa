package com.demoqa.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.Calendar;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.demoqa.pages.components.RandomUtils.getRandomString;

public class RegistrationFormPage {

    //variables
    Calendar calendar = new Calendar();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = getRandomString(10);
    String currentAddress = faker.witcher().quote();
    String filePath = "qa_guru_icon.jpg";


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

    public RegistrationFormPage fillForm(String gender, String year, String month,
                         String day,String subject, String hobby, String state, String city) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        emailInput.setValue(email);
        setGender(gender);
        phoneNumberInput.setValue(phoneNumber);
        dateOfBirthInput.click();
        calendar.calendarDateSelect(year, month, day);
        subjectsInput.setValue(subject).pressEnter();
        setHobby(hobby);
        uploadPictureButton.uploadFromClasspath(filePath);
        addressInput.setValue(currentAddress);
        stateField.click();
        setState(state);
        cityField.click();
        setCity(city);
        submitButton.click();

        return this;
    }

    public RegistrationFormPage checkForm(String gender, String year, String month,
                               String day,String subject, String hobby, String state, String city) {
        checkField("Student Name", firstName + " " + lastName);
        checkField("Student Email", email);
        checkField("Gender", gender);
        checkField("Mobile", phoneNumber);
        checkField("Date of Birth", day + " " + month + "," + year);
        checkField("Subjects", subject);
        checkField("Hobbies", hobby);
        checkField("Picture", filePath);
        checkField("Address", currentAddress);
        checkField("State and City", state + " " + city);

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
