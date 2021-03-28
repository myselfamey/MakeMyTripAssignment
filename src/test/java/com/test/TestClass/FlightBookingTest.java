package com.test.TestClass;

import com.core.ConfigLoader.ConfigLoader;
import com.core.Constants.Constants;
import com.core.PageOperations.FlightSearchPage;
import com.core.PageOperations.HomePage;
import com.core.Utils.HelperUtils;
import com.core.Utils.WebUtils;
import com.test.BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public class FlightBookingTest extends BaseTest {

    private HomePage homePage;
    private FlightSearchPage flightSearchPage;
    private String baseUrl;


    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws IOException {
        baseUrl = ConfigLoader.getInstance().getPropertyValue(Constants.BASE_URL_KEY);
        homePage = new HomePage(driver);
        WebUtils.goToUrl(driver, baseUrl);
        homePage.closeLoginAccountPopupIfPresents();

    }

    @Test(priority = 0, description = "verify Page Url And Title Of Home Page")
    public void verifyPageUrlAndTitleOfHomePage() {
        SoftAssert softAssert = getSoftAssert();
        softAssert.assertEquals(homePage.getPageUrl(), baseUrl);
        softAssert.assertEquals(homePage.getPageTitle(), Constants.HOME_PAGE_TITLE);
        softAssert.assertAll();
    }

    @Test(priority = 1, description = "Verify round trip if visible")
    public void verifyRoundTripVisibility() {
        Assert.assertTrue(homePage.roundTripVisibility());
    }

    @Test(priority = 2, description = "Verify round trip is selected")
    public void verifyRoundTripSelected() {
        homePage.selectTripType(Constants.TRIP_TYPE);
        Assert.assertTrue(homePage.roundTripSelected());
    }

    @Test(priority = 3, description = "Verify 'from' City Main Section is visible")
    public void fromCitySectionVisibility() {
        SoftAssert softAssert = getSoftAssert();
        softAssert.assertTrue(homePage.fromCitySectionVisibility());
        softAssert.assertEquals(homePage.fromCitySectionTitleText(), Constants.FROM_SECTION_TITLE_TEXT);
        softAssert.assertAll();
    }

    @Test(priority = 4, description = "Verify 'to' City Main Section is visible")
    public void toCitySectionVisibility() {
        SoftAssert softAssert = getSoftAssert();
        softAssert.assertTrue(homePage.toCitySectionVisibility());
        softAssert.assertEquals(homePage.toCitySectionTitleText(), Constants.TO_SECTION_TITLE_TEXT);
        softAssert.assertAll();
    }

    @Test(priority = 5, description = "select And Verify Source City")
    public void selectAndVerifySourceCity() {
        SoftAssert softAssert = getSoftAssert();
        homePage.selectFromCityOption();
        homePage.enterKeysForSourceCity(Constants.SOURCE_CITY);
        homePage.selectSourceCityFromAutosuggestions(Constants.SOURCE_CITY_CODE);
        softAssert.assertEquals(homePage.verifySourceCitySelected().toLowerCase(), Constants.SOURCE_CITY.toLowerCase());
        softAssert.assertTrue(homePage.verifySourceCityCodeSelected().contains(Constants.SOURCE_CITY_CODE));
        softAssert.assertAll();
    }

    @Test(priority = 6, description = "select And Verify Destination City")
    public void selectAndVerifyDestinationCity() {
        SoftAssert softAssert = getSoftAssert();
        homePage.enterKeysForDestinationCity(Constants.DESTINATION_CITY);
        homePage.selectDestinationCityFromAutosuggestions(Constants.DESTINATION_CITY_CODE);
        softAssert.assertEquals(homePage.verifyDestinationCitySelected().toLowerCase(), Constants.DESTINATION_CITY.toLowerCase());
        softAssert.assertTrue(homePage.verifyDestinationCityCodeSelected().contains(Constants.DESTINATION_CITY_CODE));
        softAssert.assertAll();
    }

    @Test(priority = 7, description = "Verify departure Date Section Visiblity And Text")
    public void departureDateSectionVisiblityAndText() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.verifyDepartureSectionVisibility());
        softAssert.assertEquals(homePage.verifyDepartureSectionText(), Constants.DEPARTURE_DATE_SECTION_TEXT);
    }

    @Test(priority = 8, description = "Verify return Date Section Visiblity And Text")
    public void returnDateSectionVisiblityAndText() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.verifyReturnSectionVisibility());
        softAssert.assertEquals(homePage.verifyReturnSectionText(), Constants.RETURN_DATE_SECTION_TEXT);
    }

    @Test(priority = 9, description = "select And Verify Departure Date")
    public void selectAndVerifyDepartureDate() {
        String expectedDepartureDate = HelperUtils.getPlusDateFromNow(Constants.DEPARTURE_DATE_FROM_NOW, Constants.STRING_FORMAT_I);
        homePage.selectDepartureDate(expectedDepartureDate);
        compareActualAndExpectedDate(expectedDepartureDate, homePage.verifyDepartureDate());
    }

    @Test(priority = 10, description = "select And Verify Return Date")
    public void selectAndVerifyReturnDate() {
        String expectedReturnDate = HelperUtils.getPlusDateFromNow(Constants.RETURN_DATE_FROM_NOW, Constants.STRING_FORMAT_I);
        homePage.selectDepartureDate(expectedReturnDate);
        compareActualAndExpectedDate(expectedReturnDate, homePage.verifyReturnDate());
    }

    @Test(priority = 11, description = "verify Travellers Class Section Visiblity")
    public void verifyTravellersClassSectionVisiblity() {
        SoftAssert softAssert = getSoftAssert();
        softAssert.assertTrue(homePage.verifyTravellersSectionVisibility());
        softAssert.assertEquals(homePage.verifyTravellersSectionText(), Constants.TRAVELLERS_CLASS_SECTION_TEXT);
        softAssert.assertAll();
    }

    @Test(priority = 12, description = "select And Verify Overall Travellers")
    public void selectAndVerifyOverallTravellers() {
        SoftAssert softAssert = getSoftAssert();
        homePage.selectTravellersSection();
        homePage.selectAdults(Constants.ADULTS_COUNT);
        homePage.selectChildren(Constants.CHILDREN_COUNT);
        homePage.selectInfants(Constants.INFANTS_COUNT);
        homePage.selectTravellerClass(Constants.TRAVELLERS_CLASS);
        homePage.clickOnApplyButtonOfTravellerSection();
        softAssert.assertEquals(homePage.travellersClassValueSelected(), Constants.TRAVELLERS_CLASS);
        softAssert.assertEquals(Integer.parseInt(homePage.verifyOverallTravellers()), Constants.ADULTS_COUNT+Constants.CHILDREN_COUNT+Constants.INFANTS_COUNT);
        softAssert.assertAll();
    }

    @Test(priority = 13, description = "verify Search Button Visibility")
    public void verifySearchButtonVisibility() {
        Assert.assertTrue(homePage.searchButtonOfHomePageVisibility());
    }

    @Test(priority = 14, description = "clickOnSearchButton")
    public void clickOnSearchButton() {
        flightSearchPage = homePage.clickOnSearchButtonOfHomePage();
    }

    @Test(priority = 15, description = "verify Flight Search PageUrl")
    public void verifyFlightSearchPageUrl() {
        Assert.assertTrue(flightSearchPage.verifyPageUrl().contains(Constants.FLIGHT_SEARCH_PAGE_URL));
    }

    @Test(priority = 16, description = "verify customer selected properties on flight search page")
    public void verifyUserInfoOnFlightSearchPage() {
        SoftAssert softAssert = getSoftAssert();
        softAssert.assertEquals(flightSearchPage.verifyTripType(), Constants.ROUND_TRIP_TEXT);
        softAssert.assertTrue(flightSearchPage.verifyFromCity().contains(Constants.SOURCE_CITY));
        softAssert.assertTrue(flightSearchPage.verifyToCity().contains(Constants.DESTINATION_CITY));
        softAssert.assertEquals(flightSearchPage.verifytotalPassengersAndClass(), Constants.PASSENGERS_CLASS_FLIGHT_SEARCH.replace("%", String.valueOf(Constants.ADULTS_COUNT+Constants.INFANTS_COUNT+Constants.CHILDREN_COUNT)).replace("$", Constants.TRAVELLERS_CLASS));
        softAssert.assertTrue(flightSearchPage.verifyDepartDate().contains(HelperUtils.getPlusDateFromNow(Constants.DEPARTURE_DATE_FROM_NOW, Constants.STRING_FORMAT_II)));
        softAssert.assertTrue(flightSearchPage.verifyReturnDate().contains(HelperUtils.getPlusDateFromNow(Constants.RETURN_DATE_FROM_NOW, Constants.STRING_FORMAT_II)));

    }

    @Test(priority = 17, description = "click On Specific Depart And Return Flight")
    public void clickOnSpecificDepartAndReturnFlight() throws InterruptedException {
        flightSearchPage.clickOnFirstWayAndSecondWayFlight(Constants.oneWayflightNumber, Constants.twoWayflightNumber);
    }

    @Test(priority = 18, description = "Verify the overall price")
    public void verifyOverallPrice() {
        int fromFlightPrice = Integer.parseInt(flightSearchPage.fromFlightPrice(Constants.oneWayflightNumber));
        int toFlightPrice = Integer.parseInt(flightSearchPage.toFlightPrice(Constants.twoWayflightNumber));
        Assert.assertTrue(fromFlightPrice + toFlightPrice == Integer.parseInt(flightSearchPage.totalPrice()));
    }

    @Test(priority = 19, description = "click On Book Now Button")
    public void clickOnBookNowButton() {
        flightSearchPage.clickOnBookNowButton();
        Assert.assertTrue(flightSearchPage.clickOnContinueButtonMoreFaresOptionsIfComes().contains(Constants.FLIGHT_REVIEW_PAGE_URL));
    }

    private void compareActualAndExpectedDate(String expected, String actual) {
        SoftAssert softAssert = getSoftAssert();
        String[] s = expected.split(" ");
        String expectedDate = s[0];
        expectedDate = expectedDate.charAt(0) == '0' ? String.valueOf(expectedDate.charAt(1)) : expectedDate;
        String expectedMonth = s[1];
        String expectedYear = s[2];
        String[] s1 = actual.split(" ");
        String actualDate = s1[1];
        String actualMonth = s1[2];
        String actualYear = s1[3];
        softAssert.assertEquals(actualDate, expectedDate);
        softAssert.assertEquals(actualMonth, expectedMonth);
        softAssert.assertEquals(actualYear, expectedYear);
        softAssert.assertAll();
    }


}
