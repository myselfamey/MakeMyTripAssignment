package com.core.PageOperations;

import com.core.PageEvents.FlightSearchEvents;
import com.core.Utils.WebUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;

public class FlightSearchPage implements FlightSearchEvents {

    private WebDriver flightSearchDriver;

    public FlightSearchPage(WebDriver driver) {
        flightSearchDriver=driver;
    }

    public String verifyPageUrl(){
        return   WebUtils.getCurrentUrl(flightSearchDriver);
    }

    public String verifyTripType(){
        return WebUtils.getText(WebUtils.getElement(flightSearchDriver,tripTypeValue));
    }

    public String verifyFromCity(){
        return WebUtils.getText(WebUtils.getElement(flightSearchDriver,fromCityText));
    }
    public String verifyToCity(){
        return WebUtils.getText(WebUtils.getElement(flightSearchDriver,toCityText));
    }
    public String verifyDepartDate(){
        return WebUtils.getText(WebUtils.getElement(flightSearchDriver,departureDateText));
    }
    public String verifyReturnDate(){
        return WebUtils.getText(WebUtils.getElement(flightSearchDriver,returnDateText));
    }

    public String verifytotalPassengersAndClass(){
        return WebUtils.getText(WebUtils.getElement(flightSearchDriver,travellersAndClassText));
    }


    public void clickOnFirstWayAndSecondWayFlight(int OneWay, int TwoWay) throws InterruptedException {
        WebUtils.waitUntilElementsAreVisible(flightSearchDriver,availableflightSection,Duration.ofSeconds(10));
        List<WebElement> oneWayFlightsElements=WebUtils.getElements(flightSearchDriver,firstGoFlightsSelectButton);
        List<WebElement> twoWayFlightsElements=WebUtils.getElements(flightSearchDriver,returnGoFlightsSelectButton);
        WebUtils.javascriptClick(flightSearchDriver,oneWayFlightsElements.get(OneWay-1));
        WebUtils.javascriptClick(flightSearchDriver,twoWayFlightsElements.get(TwoWay-1));

    }

    public String fromFlightPrice(int number){
         return WebUtils.getElements(flightSearchDriver,fromflightPrice).get(number-1).getText().replace("₹ ","").replace(",","");
    }

    public String toFlightPrice(int number){
        return WebUtils.getElements(flightSearchDriver,toflightPrice).get(number-1).getText().replace("₹ ","").replace(",","");

    }
    public String totalPrice(){
        return WebUtils.getElement(flightSearchDriver,totalPrice).getText().replace("₹ ","").replace(",","");

    }
    public void clickOnBookNowButton(){
       WebUtils.elementClick(WebUtils.getElement(flightSearchDriver,bookNowButton));
    }

    public String clickOnContinueButtonMoreFaresOptionsIfComes(){
        if(WebUtils.isDisplayed(flightSearchDriver,moreFaresOptions))
        WebUtils.elementClick(WebUtils.getElement(flightSearchDriver,moreFaresOptions));
         flightSearchDriver.switchTo().window(WebUtils.get1stChildWindowIDs(flightSearchDriver));
         return WebUtils.getCurrentUrl(flightSearchDriver);
    }
}
