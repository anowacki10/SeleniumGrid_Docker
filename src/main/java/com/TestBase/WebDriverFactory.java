package com.TestBase;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;


public class WebDriverFactory {

    public WebDriver driver;

    @BeforeMethod
    @Parameters({"browser", "gridURL", "appURL"})
    public void setDriver(String browser, String gridURL, String appURL) throws MalformedURLException, InterruptedException {


        if (browser.equalsIgnoreCase("chrome")) {


            DesiredCapabilities chromeCap = new DesiredCapabilities();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            //chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeCap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            chromeCap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            driver = new RemoteWebDriver(new URL(gridURL), chromeCap);
            driver.manage().window().maximize();
            driver.get(appURL);
            Thread.sleep(2000);


        } else if (browser.equalsIgnoreCase("firefox")) {

            DesiredCapabilities firefoxCap = new DesiredCapabilities();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--private");
            //firefoxOptions.addArguments("--headless");
            firefoxCap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
            firefoxCap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
            driver = new RemoteWebDriver(new URL(gridURL), firefoxCap);
            driver.manage().window().maximize();
            driver.get(appURL);
            Thread.sleep(2000);


        }else if (browser.equalsIgnoreCase("edge")) {


            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setCapability("ms:inPrivate", true);
            //edgeOptions.addArguments("headless");
            driver = new RemoteWebDriver(new URL(gridURL), edgeOptions);
            driver.manage().window().maximize();
            driver.get(appURL);
            Thread.sleep(3000);


        }else {
            throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }
    }


    @AfterMethod
    public void tearDown() {
            driver.quit();

    }
}



