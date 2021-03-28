package com.test.TestClass;

import com.core.ConfigLoader.ConfigLoader;
import com.core.Constants.Constants;
import com.core.PageOperations.LoginPage;
import com.core.Utils.WebUtils;
import com.test.BaseTest.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginTest extends BaseTest {

private LoginPage loginPage;
private String baseUrl;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws IOException {
       baseUrl= ConfigLoader.getInstance().getPropertyValue(Constants.BASE_URL_KEY);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage= new LoginPage(driver);
        WebUtils.goToUrl(driver,baseUrl);
        loginPage.closeLoginAccountPopupIfPresents();
    }

   @Test(priority = 0,description = "Verify with valid username and password")
    public void loginWithCorrectData() {
       SoftAssert softAssert= getSoftAssert();
        softAssert.assertTrue(loginPage.isLoginButtonIsDisplay());
        loginPage.clickOnLoginButton();
        softAssert.assertTrue(loginPage.isLoginSectionVisible());
        softAssert.assertTrue(loginPage.isUsernamePlaceholderVisible());
        softAssert.assertEquals(loginPage.getUsernamePlaceHolderText(),Constants.USERNAME_PLACEHOLDER_TEXT);
        softAssert.assertFalse(loginPage.isContinueButtonIsDisplay());
        loginPage.enterUserId(Constants.VALID_USERNAME);
        softAssert.assertTrue(loginPage.isContinueButtonIsDisplay());
        loginPage.clickContinueButton();
        softAssert.assertTrue(loginPage.isEnterPasswordTextFieldIsDisplay());
        loginPage.clickOnEnterPasswordTextField(Constants.VALID_PASSWORD);
        softAssert.assertFalse(loginPage.isLoginNotVisible());
        loginPage.clickOnLogin();
        softAssert.assertTrue(loginPage.isMobilePopUpDisplay());
        softAssert.assertAll();
    }

     @Test(priority = 1,description = "Verify with valid username and invalid password")
    public void loginWithCorrectUserNameWrongPassword() {
        SoftAssert softAssert=getSoftAssert();
        softAssert.assertTrue(loginPage.isLoginButtonIsDisplay());
        loginPage.clickOnLoginButton();
        softAssert.assertTrue(loginPage.isLoginSectionVisible());
        softAssert.assertTrue(loginPage.isUsernamePlaceholderVisible());
        loginPage.enterUserId(Constants.VALID_USERNAME);
        softAssert.assertTrue(loginPage.isContinueButtonIsDisplay());
        loginPage.clickContinueButton();
        softAssert.assertTrue(loginPage.isEnterPasswordTextFieldIsDisplay());
        loginPage.clickOnEnterPasswordTextField(Constants.INVALID_PASSWORD);
        softAssert.assertFalse(loginPage.isLoginNotVisible());
        loginPage.clickOnLogin();
        softAssert.assertTrue(loginPage.isErrorMessageDisplayForWrongPWD());
         softAssert.assertTrue(loginPage.getErrorMessageForWrongPassword().equals(Constants.WRONG_PASSWORD_ERROR_MESSAGE));
         softAssert.assertAll();

    }

    @Test(priority = 2,description = "Verify with valid username and minimum password limit error")
    public void loginWithCorrectUserNameAndMinimumPasswordError(){
        SoftAssert softAssert=getSoftAssert();
        softAssert.assertTrue(loginPage.isLoginButtonIsDisplay());
        loginPage.clickOnLoginButton();
        softAssert.assertTrue(loginPage.isLoginSectionVisible());
        softAssert.assertTrue(loginPage.isUsernamePlaceholderVisible());
        loginPage.enterUserId(Constants.VALID_USERNAME);
        softAssert.assertTrue(loginPage.isContinueButtonIsDisplay());
        loginPage.clickContinueButton();
        softAssert.assertTrue(loginPage.isEnterPasswordTextFieldIsDisplay());
        loginPage.clickOnEnterPasswordTextField(Constants.MINIMUM_PASSWORD_INPUT);
        loginPage.clickOnOutsideOfPasswordPlaceholder();
        softAssert.assertTrue(loginPage.isLoginNotVisible());
        softAssert.assertTrue(loginPage.isErrorMessageDisplayForMinimumPassowordLimitError());
        softAssert.assertTrue(loginPage.getErrorMessageDisplayForMinimumPassowordLimitError().equals(Constants.MINIMUM_PASSWORD_LIMIT_ERROR_MESSAGE),"2");
        softAssert.assertAll();

    }

   @Test(priority = 3,description = "Verify with invalid username")
    public void loginWithInValidUserName() {
        SoftAssert softAssert= getSoftAssert();
        softAssert.assertTrue(loginPage.isLoginButtonIsDisplay());
        loginPage.clickOnLoginButton();
        softAssert.assertTrue(loginPage.isLoginSectionVisible());
        softAssert.assertTrue(loginPage.isUsernamePlaceholderVisible());
        softAssert.assertEquals(loginPage.getUsernamePlaceHolderText(),Constants.USERNAME_PLACEHOLDER_TEXT);
        softAssert.assertFalse(loginPage.isContinueButtonIsDisplay());
        loginPage.enterUserId(Constants.INVALID_USERNAME);
        softAssert.assertFalse(loginPage.isContinueButtonIsDisplay());
        loginPage.clickOnOutsideOfPasswordPlaceholder();
        softAssert.assertTrue(loginPage.isErrorMessageDisplayForWrongUserName());
        softAssert.assertTrue(loginPage.getErrorMessageForWrongUsername().equals(Constants.WRONG_USERNAME_ERROR_MESSAGE));
        softAssert.assertAll();

    }



}
