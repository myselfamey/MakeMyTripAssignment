package com.core.DriverSetup;

import com.core.ConfigLoader.ConfigLoader;
import com.core.Constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;

public class DriverSetup {

    private WebDriver driver;

    public WebDriver setupDriver(String browserName) throws IOException {

        ConfigLoader configLoader = ConfigLoader.getInstance();

        String browserExe =configLoader.getPropertyValue(getOsType() + "_" + validateBrowserName(browserName));

        String driverExePath=System.getProperty("user.dir")+ File.separator+"DriversExe"+File.separator+browserExe;

        if("chrome".equalsIgnoreCase(browserName)) {
            System.setProperty("webdriver."+ configLoader.getPropertyValue(Constants.CHROME_EXE_KEY)+".driver", driverExePath);
            this.driver = new ChromeDriver();
            return driver;
        }
        else if("firefox".equalsIgnoreCase(browserName)){
            System.setProperty("webdriver."+ configLoader.getPropertyValue(Constants.FIREFOX_EXE_KEY)+".driver", driverExePath);
            this.driver = new FirefoxDriver();
            return driver;
        }
        else {
            throw new RuntimeException("Unsupported Browser Name");
        }
    }

    private String validateBrowserName(String browser) {
        if(browser!=null && !browser.isEmpty()){
            if("chrome".equalsIgnoreCase(browser))
                return "CHROME";
           else if("firefox".equalsIgnoreCase(browser))
                return "FIREFOX";
           else
               throw new RuntimeException("Provided Browser name is not supported");
        }
        throw new RuntimeException("Browser name cannot be null or empty");
    }

    private String getOsType(){
        String osName= System.getProperty("os.name").toLowerCase();
       if(osName.contains("linux"))
           return "LINUX";
        else if(osName.contains("window"))
            return "WINDOW";
         else if(osName.contains("mac"))
            return "MAC";
         else
           throw new RuntimeException("Currently Unsupported Os.");
    }
}
