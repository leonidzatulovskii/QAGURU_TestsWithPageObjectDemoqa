package com.demoqa.tests;

import com.codeborne.selenide.Selenide;
import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.testData.TestStudents;
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
                .fillForm(TestStudents.defaultStudent())
                .checkForm(TestStudents.defaultStudent());
    }
}

