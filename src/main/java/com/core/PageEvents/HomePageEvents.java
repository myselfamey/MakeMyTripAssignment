package com.core.PageEvents;

import org.openqa.selenium.By;

public interface HomePageEvents {

    By loginPopup=By.cssSelector("div.autopop__wrap.makeFlex.column.defaultCursor");
    By loginAccountButton=By.xpath("//li[@data-cy='account']");

    By roundTripOption=By.cssSelector("li[data-cy='roundTrip']");
    By tripTypeGeneric=By.cssSelector("ul.fswTabs.latoBlack.greyText > li");

    By fromCitySection=By.xpath("//label[@for='fromCity']");
    By fromCitySectionTitleText=By.xpath("//label[@for='fromCity']/span");
    By fromCitySelectedName=By.xpath("//label[@for='fromCity']/input");
    By fromCitySelectedCode=By.xpath("//label[@for='fromCity']/p");
    By sourceCityPlaceholder=By.xpath("//input[@placeholder='From']");


    By toCitySection=By.xpath("//label[@for='toCity']");
    By toCitySectionTitleText=By.xpath("//label[@for='toCity']/span");
    By toCitySelectedName=By.xpath("//label[@for='toCity']/input");
    By toCitySelectedCode=By.xpath("//label[@for='toCity']/p");
    By destinationCityPlaceholder=By.xpath("//input[@placeholder='To']");

    By departureDateSection=By.xpath("//label[@for='departure']");
    By returnDateSection=By.xpath("//label[@for='return']");
    By departureDateText=By.xpath("//label[@for='departure']/span");
    By returnDateText=By.xpath("//label[@for='return']/span");
    By departureDateValue=By.xpath("//label[@for='departure']/input");
    By returnDateValue=By.xpath("//label[@for='return']/input");

    By monthYearCaptionCalender=By.cssSelector("div.DayPicker-Caption");
    By rightArrowCalender=By.xpath("//div[@class='DayPicker-NavBar']/span[2]");
    By availableDateCalender=By.cssSelector("div.DayPicker-Week > div[aria-disabled='false']");

    By travellersAndClassSection=By.xpath("//div[@data-cy='flightTraveller']");
    By travellersAndClassSectionText=By.xpath("//div[@data-cy='flightTraveller']/label/span");
    By travellersClassValueSelected=By.xpath("//div[@data-cy='flightTraveller']/label/p[2]");
    By overallTravellers=By.xpath("//div[@data-cy='flightTraveller']/label/p[1]/span/span");

    By TravellersAndClassButton=By.xpath("//button[@data-cy='travellerApplyBtn']");
    By submitBookingDetails=By.xpath("//p[@data-cy='submit']/a");




}
