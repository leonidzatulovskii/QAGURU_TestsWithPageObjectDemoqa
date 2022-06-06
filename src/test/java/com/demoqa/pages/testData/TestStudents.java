package com.demoqa.pages.testData;

import com.github.javafaker.Faker;

import static com.demoqa.pages.components.RandomUtils.getRandomString;

public class TestStudents {

    private static final Faker FAKER = new Faker();

    public static Student defaultStudent() {
        return Student.builder()
                .gender("Male")
                .year("2000")
                .month("January")
                .day("25")
                .subject("English")
                .hobby("Sports")
                .state("Haryana")
                .city("Panipat")
                .firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .email(FAKER.internet().emailAddress())
                .phoneNumber(getRandomString(10))
                .currentAddress(FAKER.witcher().quote())
                .filePath("qa_guru_icon.jpg").build();
    }
}
