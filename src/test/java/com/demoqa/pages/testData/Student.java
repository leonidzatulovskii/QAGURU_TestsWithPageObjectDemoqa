package com.demoqa.pages.testData;

public class Student {
    private final String gender;
    private final String year;
    private final String month;
    private final String day;
    private final String subject;
    private final String hobby;
    private final String state;
    private final String city;

    private Student (String gender, String year, String month,
                     String day,String subject, String hobby, String state, String city) {
        this.gender = gender;
        this.year = year;
        this.month = month;
        this.day = day;
        this.subject = subject;
        this.hobby = hobby;
        this.state = state;
        this.city = city;
    }

    public static Student by(String gender, String year, String month,
                             String day,String subject, String hobby, String state, String city) {
        return new Student(gender, year, month, day, subject, hobby, state, city);
    }

    public String gender() { return gender; }
    public String year() { return year; }
    public String month() { return month; }
    public String day() { return day; }
    public String subject() { return subject; }
    public String hobby() { return hobby; }
    public String state() { return state; }
    public String city() { return city; }
}
