package com.core.PageOperations;

import com.core.Constants.MonthEnum;
import com.core.PageEvents.HomePageEvents;
import com.core.Utils.HelperUtils;
import com.core.Utils.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage implements HomePageEvents {

    private final WebDriver homePageDriver;

    private final String cityAutosuggestionsKey = "//div[@role='listbox']/div[1]/ul/li[%]/div/div[2]";
    private final String childrenLocatorKey = "//li[@data-cy='children-$']";
    private final String adultsLocatorKey = "//li[@data-cy='adults-$']";
    private final String infantsLocatorKey = "//li[@data-cy='infants-$']";
    private final String travellersCLassLocatorKey = "//li[@data-cy='travelClass-$']";


    public HomePage(WebDriver driver) {
        homePageDriver = driver;
    }

    public String getPageUrl() {
        return WebUtils.getCurrentUrl(homePageDriver);
    }

    public String getPageTitle() {
        return WebUtils.getPageTitle(homePageDriver);
    }

    public void closeLoginAccountPopupIfPresents() {
        if (WebUtils.isDisplayed(homePageDriver, loginPopup))
            WebUtils.elementClick(WebUtils.getElement(homePageDriver, loginAccountButton));
    }

    public boolean roundTripVisibility() {
        return WebUtils.isDisplayed(homePageDriver, roundTripOption);
    }

    public void selectTripType(String trip) {
        WebUtils.getElements(homePageDriver, tripTypeGeneric)
                .stream()
                .filter(tripType -> trip.equalsIgnoreCase(WebUtils.getAttributeValue(tripType, "data-cy")))
                .forEach(tripType -> WebUtils.elementClick(tripType));
    }

    public boolean roundTripSelected() {
        return WebUtils.getAttributeValue(WebUtils.getElement(homePageDriver, roundTripOption), "class").equals("selected");
    }

    public boolean fromCitySectionVisibility() {
        return WebUtils.isDisplayed(homePageDriver, fromCitySection);
    }

    public boolean toCitySectionVisibility() {
        return WebUtils.isDisplayed(homePageDriver, toCitySection);
    }

    public String fromCitySectionTitleText() {
        return WebUtils.getText(WebUtils.getElement(homePageDriver, fromCitySectionTitleText));
    }

    public String toCitySectionTitleText() {
        return WebUtils.getText(WebUtils.getElement(homePageDriver, toCitySectionTitleText));
    }

    public void selectFromCityOption() {
        WebUtils.elementClick(WebUtils.getElement(homePageDriver, fromCitySelectedName));
    }

    public void enterKeysForSourceCity(String city) {
        enterKeysForCity(city, sourceCityPlaceholder);
    }

    public void enterKeysForDestinationCity(String city) {
        enterKeysForCity(city, destinationCityPlaceholder);
    }

    public void selectSourceCityFromAutosuggestions(String cityCode) {
        selectCityFromAutosuggestions(cityCode, cityAutosuggestionsKey);

    }

    public void selectDestinationCityFromAutosuggestions(String cityCode) {
        selectCityFromAutosuggestions(cityCode, cityAutosuggestionsKey);

    }

    public String verifySourceCitySelected() {
        return WebUtils.getAttributeValue(WebUtils.getElement(homePageDriver, fromCitySelectedName), "value");
    }

    public String verifySourceCityCodeSelected() {
        return WebUtils.getAttributeValue(WebUtils.getElement(homePageDriver, fromCitySelectedCode), "title");
    }

    public String verifyDestinationCitySelected() {
        return WebUtils.getAttributeValue(WebUtils.getElement(homePageDriver, toCitySelectedName), "value");
    }

    public String verifyDestinationCityCodeSelected() {
        return WebUtils.getAttributeValue(WebUtils.getElement(homePageDriver, toCitySelectedCode), "title");
    }

    public void selectDepartureDate(String date) {
        selectDateOnCalender(date);
    }

    public void selectReturnDate(String date) {
        selectDateOnCalender(date);
    }

    public String verifyDepartureDate() {
        return WebUtils.getAttributeValue(WebUtils.getElement(homePageDriver, departureDateValue), "value");
    }

    public String verifyReturnDate() {
        return WebUtils.getAttributeValue(WebUtils.getElement(homePageDriver, returnDateValue), "value");
    }

    public boolean verifyDepartureSectionVisibility() {
        return WebUtils.isDisplayed(homePageDriver, departureDateSection);
    }

    public boolean verifyReturnSectionVisibility() {
        return WebUtils.isDisplayed(homePageDriver, returnDateSection);
    }

    public String verifyDepartureSectionText() {
        return WebUtils.getText(WebUtils.getElement(homePageDriver, departureDateText));
    }

    public String verifyReturnSectionText() {
        return WebUtils.getText(WebUtils.getElement(homePageDriver, returnDateText));
    }

    public void selectTravellersSection() {
        WebUtils.elementClick(WebUtils.getElement(homePageDriver, travellersAndClassSection));
    }

    public boolean verifyTravellersSectionVisibility() {
        return WebUtils.isDisplayed(homePageDriver, travellersAndClassSection);
    }

    public String verifyTravellersSectionText() {
        return WebUtils.getText(WebUtils.getElement(homePageDriver, travellersAndClassSectionText));
    }

    public String travellersClassValueSelected() {
        return WebUtils.getText(WebUtils.getElement(homePageDriver, travellersClassValueSelected));
    }

    public String verifyOverallTravellers() {
        return WebUtils.getText(WebUtils.getElement(homePageDriver, overallTravellers));
    }

    public void selectChildren(int children) {
        String value = String.valueOf(children);
        WebUtils.elementClick(WebUtils.getElement(homePageDriver, WebUtils.getLocatorFromXpath(childrenLocatorKey.replace("$", value))));

    }

    public void selectAdults(int adults) {
        String value = String.valueOf(adults);
        WebUtils.elementClick(WebUtils.getElement(homePageDriver, WebUtils.getLocatorFromXpath(adultsLocatorKey.replace("$", value))));
    }

    public void selectInfants(int infants) {
        String value = String.valueOf(infants);
        WebUtils.elementClick(WebUtils.getElement(homePageDriver, WebUtils.getLocatorFromXpath(infantsLocatorKey.replace("$", value))));
    }

    public void selectTravellerClass(String value) {
        for (int i = 0; i <= 2; i++) {
            WebElement element = WebUtils.getElement(homePageDriver, WebUtils.getLocatorFromXpath(travellersCLassLocatorKey.replace("$", String.valueOf(i))));
            if (value.equalsIgnoreCase(element.getText()))
                WebUtils.elementClick(element);
        }
    }

    public void clickOnApplyButtonOfTravellerSection() {
        WebUtils.elementClick(WebUtils.getElement(homePageDriver, TravellersAndClassButton));

    }

    public FlightSearchPage clickOnSearchButtonOfHomePage() {
        WebUtils.elementClick(WebUtils.getElement(homePageDriver, submitBookingDetails));
        return new FlightSearchPage(homePageDriver);
    }

    public boolean searchButtonOfHomePageVisibility() {
        return WebUtils.isDisplayed(homePageDriver, submitBookingDetails);
    }

    private void enterKeysForCity(String city, By locator) {
        for (Character character : city.toCharArray()) {
            WebUtils.enterKeys(WebUtils.getElement(homePageDriver, locator), String.valueOf(character));
            try {
                HelperUtils.doWait(Thread.currentThread(), 700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void selectCityFromAutosuggestions(String cityCode, String locatorKey) {
        List<WebElement> autosuggestions = WebUtils.getElements(homePageDriver, WebUtils.getLocatorFromXpath(locatorKey.replace("[%]", "")));
        for (int i = 0; i < autosuggestions.size(); i++) {
            if (cityCode.equals(WebUtils.getText(autosuggestions.get(i)))) {
                WebUtils.elementClick(WebUtils
                        .getElement(homePageDriver, WebUtils
                                .getLocatorFromXpath(locatorKey.replace("%", String.valueOf(i + 1)))));
                break;
            }
        }
    }


    private void selectDateOnCalender(String date) {
        String[] time = date.split(" ");
        String dateOfMonth = time[0];
        String month = time[1];
        String year = time[2];
        selectMonthYear(month, year);
        selectDateAfterMonth(dateOfMonth, month);

    }

    private void selectMonthYear(String month, String year) {
        boolean flag = false;
        List<WebElement> monthYearCaptionsElements = WebUtils.getElements(homePageDriver, monthYearCaptionCalender);
        while (true) {
            for (WebElement element : monthYearCaptionsElements) {
                String monthYearCaption = WebUtils.getText(element);
                if ((MonthEnum.valueOf(month.toUpperCase()).getFullname() + year).equalsIgnoreCase(monthYearCaption)) {
                    flag = true;
                    break;
                }
            }
            if (flag == true)
                break;
            WebUtils.elementClick(WebUtils.getElement(homePageDriver, rightArrowCalender));
        }
    }

    private void selectDateAfterMonth(String dayOfMonth, String month) {
        List<WebElement> dateElements = WebUtils.getElements(homePageDriver, availableDateCalender);
        for (WebElement element : dateElements) {
            String text = element.getAttribute("aria-label");
            if (text.toLowerCase().contains(month.toLowerCase()
                    + " " + dayOfMonth)) {
                WebUtils.elementClick(element);
                break;
            }
        }
    }
}



