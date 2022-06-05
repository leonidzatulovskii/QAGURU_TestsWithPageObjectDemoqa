package com.demoqa.tests;

import com.codeborne.selenide.Selenide;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @AfterEach
    void close() {
        Selenide.closeWindow();
    }

    @Test
    void checkRegistration() {
        registrationFormPage
                .openPage()
                .fillForm("Male", "2000", "January", "25", "English",
                "Sports", "Haryana", "Panipat")
                .checkForm("Male", "2000", "January", "25", "English",
                "Sports", "Haryana", "Panipat");
    }
}

