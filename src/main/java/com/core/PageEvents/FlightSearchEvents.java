package com.core.PageEvents;

import org.openqa.selenium.By;

public interface FlightSearchEvents {

    By tripTypeValue = By.xpath("//div[@class='hsw_inner']/div[1]/div/div");
    By fromCityText = By.xpath("//input[@id='fromCity']");
    By toCityText = By.xpath("//input[@id='toCity']");
    By travellersAndClassText = By.xpath("//input[@id='travellerAndClass']");
    By departureDateText = By.xpath("//input[@id='departure']");
    By returnDateText = By.xpath("//input[@id='return']");
    By fromflightPrice = By.xpath("(//div[@class='paneView'])[1] //div[@class='listingCard']/div[2]/div[2]/p");
    By toflightPrice = By.xpath("(//div[@class='paneView'])[2] //div[@class='listingCard']/div[2]/div[2]/p");
    By totalPrice = By.cssSelector("div.makeFlex.stickyFlightDtl > div > div > p >span");


    By availableflightSection = By.cssSelector("div.paneView");
    By firstGoFlightsSelectButton = By.xpath("(//div[@class='paneView'])[1] //span[@class='customRadioBtn']");
    By returnGoFlightsSelectButton = By.xpath("(//div[@class='paneView'])[2] //span[@class='customRadioBtn']");
    By bookNowButton = By.cssSelector("button.splitFooterButton.button.buttonPrimary.buttonBig");
    By moreFaresOptions = By.cssSelector("button.buttonPrimary.buttonBig.lato-black.button");
}
