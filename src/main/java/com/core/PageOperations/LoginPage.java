package com.core.PageOperations;

import com.core.PageEvents.LoginEvents;
import com.core.Utils.WebUtils;
import org.openqa.selenium.WebDriver;

import static com.core.PageEvents.HomePageEvents.loginPopup;

public class LoginPage implements LoginEvents {

    private final WebDriver loginPageDriver;

    public LoginPage(WebDriver driver) {
        loginPageDriver = driver;
    }

    public void closeLoginAccountPopupIfPresents() {
        if (WebUtils.isDisplayed(loginPageDriver, loginPopup))
            WebUtils.elementClick(WebUtils.getElement(loginPageDriver, loginButton));
    }

    public boolean isLoginButtonIsDisplay() {
        return WebUtils.isDisplayed(loginPageDriver, loginButton);
    }

    public void clickOnLoginButton() {
        WebUtils.elementClick(WebUtils.getElement(loginPageDriver, loginButton));
    }

    public boolean isLoginSectionVisible() {
        return WebUtils.isDisplayed(loginPageDriver, loginSection);
    }

    public boolean isUsernamePlaceholderVisible() {
        return WebUtils.isDisplayed(loginPageDriver, userName);
    }

    public String getUsernamePlaceHolderText() {
        return WebUtils.getAttributeValue(WebUtils.getElement(loginPageDriver, userName), "placeholder");
    }

    public void enterUserId(String username) {
        WebUtils.enterKeys(WebUtils.getElement(loginPageDriver, userName), username);
    }

    public boolean isContinueButtonIsDisplay() {
        return WebUtils.isEnabled(WebUtils.getElement(loginPageDriver, continueButton));
    }

    public void clickContinueButton() {
        WebUtils.elementClick(WebUtils.getElement(loginPageDriver, continueButton));
    }

    public boolean isEnterPasswordTextFieldIsDisplay() {
        return WebUtils.isDisplayed(loginPageDriver, enterPasswordTextField);
    }

    public void clickOnEnterPasswordTextField(String passWord) {
        WebUtils.enterKeys(WebUtils.getElement(loginPageDriver, enterPasswordTextField), passWord);
    }

    public boolean isLoginNotVisible() {
        return Boolean.parseBoolean(WebUtils.getAttributeValue(WebUtils.getElement(loginPageDriver, login), "disabled"));
    }

    public void clickOnLogin() {
        WebUtils.elementClick(WebUtils.getElement(loginPageDriver, login));

    }


    public boolean isMobilePopUpDisplay() {
        return WebUtils.isDisplayed(loginPageDriver, otpSection);
    }


    public boolean isErrorMessageDisplayForWrongPWD() {
        return WebUtils.isDisplayed(loginPageDriver, wrongPasswordErrorMessage);
    }

    public String getErrorMessageForWrongPassword() {
        return WebUtils.getText(WebUtils.getElement(loginPageDriver, wrongPasswordErrorMessage));
    }

    public void clickOnOutsideOfPasswordPlaceholder() {
        WebUtils.elementClick(WebUtils.getElement(loginPageDriver, outsideOfPasswordPlaceholder));

    }

    public boolean isErrorMessageDisplayForMinimumPassowordLimitError() {
        return WebUtils.isDisplayed(loginPageDriver, minimumPasswordLimitError);
    }

    public String getErrorMessageDisplayForMinimumPassowordLimitError() {
        return WebUtils.getText(WebUtils.getElement(loginPageDriver, minimumPasswordLimitError));
    }

    public boolean isErrorMessageDisplayForWrongUserName() {
        return WebUtils.isDisplayed(loginPageDriver, wrongUserNameError);

    }

    public String getErrorMessageForWrongUsername() {
        return WebUtils.getText(WebUtils.getElement(loginPageDriver, wrongUserNameError));
    }

}
