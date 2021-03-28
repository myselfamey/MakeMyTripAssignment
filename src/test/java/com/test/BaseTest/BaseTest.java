package com.test.BaseTest;

import com.core.DriverSetup.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.time.Duration;


public class BaseTest {

    private DriverSetup driverSetup;
    public static WebDriver driver;

   @BeforeTest(alwaysRun = true)
   @Parameters({"browserName"})
    public void beforeTest(String browserName) throws IOException {
       driverSetup = new DriverSetup();
       driver=driverSetup.setupDriver(browserName);
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
       if(driver!=null)
        driver.quit();
    }

    public SoftAssert getSoftAssert(){
       return new SoftAssert();
    }

}

