package com.core.PageEvents;

import org.openqa.selenium.By;

public interface LoginEvents {

    By loginButton = By.cssSelector("li[data-cy='account']");
    By loginSection = By.xpath("//section[@class='modalMain ']");
    By userName = By.cssSelector("#username");
    By continueButton = By.cssSelector("button[data-cy='continueBtn']");
    By enterPasswordTextField = By.cssSelector("#password");
    By login = By.cssSelector("button[data-cy='login']");
    By otpSection = By.xpath("//label[@for='otp']");
    By wrongUserNameError = By.xpath("//p[@data-cy='error']");
    By wrongPasswordErrorMessage = By.cssSelector("span[data-cy='serverError']");
    By minimumPasswordLimitError = By.xpath("//p[@data-cy='error']");
    By outsideOfPasswordPlaceholder = By.xpath("//p[@data-cy='commonModal']");


}
