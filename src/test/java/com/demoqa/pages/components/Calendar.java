package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    public void calendarDateSelect (String year, String month, String day){
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
