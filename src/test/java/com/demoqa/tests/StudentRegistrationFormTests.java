package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTests {

    String firstName = "Leonid";
    String lastName = "Zatulovskii";
    String email = "leonid@zatulovskii.com";
    String phoneNumber = "1234567890";
    String birthDate = "1 January 1900";
    String subject1 = "English";
    String subject2 = "Maths";
    String filePath = "qa_guru_icon.jpg";
    String currentAddress = "Current Address 1";
    String state = "Haryana";
    String city = "Panipat";

    @BeforeAll
    static void setUp() {
        open("https://demoqa.com/automation-practice-form");
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    void createScrollablePage() {
        Selenide.executeJavaScript(
                "document.querySelector(\"footer\").hidden = 'true';" +
                        "document.querySelector(\"#fixedban\").hidden = 'true'");
    }

    @Test
    void fillRegistrationForm() {
        //заполнение формы
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").sendKeys(Keys.chord(Keys.CONTROL,"a"), birthDate,
                Keys.chord(Keys.ENTER));
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath(filePath);
        $("#currentAddress").setValue(currentAddress);
        $("#state").scrollTo().click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        //проверка формы
        checkForm("Student Name", firstName + " " + lastName);
        checkForm("Student Email", email);
        checkForm("Gender", "Male");
        checkForm("Mobile", phoneNumber);
        checkForm("Date of Birth", "01 January,1900");
        checkForm("Subjects", subject1 + ", " + subject2);
        checkForm("Hobbies", "Sports, Reading");
        checkForm("Picture", filePath);
        checkForm("Address", currentAddress);
        checkForm("State and City", state + " " + city);
    }

    public void checkForm(String key, String value) {
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));

    }
}
