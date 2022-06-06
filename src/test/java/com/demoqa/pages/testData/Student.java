package com.demoqa.pages.testData;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Student {
    private String gender;
    private String year;
    private String month;
    private String day;
    private String subject;
    private String hobby;
    private String state;
    private String city;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String currentAddress;
    private String filePath;
}
