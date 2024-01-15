package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class mainPage{


        static By COOKIES = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
        static By SEARCHER = By.xpath("//*[@id=\"search\"]");
        static By LOCATION = By.xpath("//*[@id=\"searchmain-container\"]/div[1]/div/div/div/form/div/div[2]/div/div/div[1]/div/div/input");
        static By SUBMIT = By.xpath("//*[@id=\"searchmain-container\"]/div[1]/div/div/div/form/div/div[3]/button");


        public static void COOKIES_click(WebDriver driver){
            try {
                WebElement cookies = driver.findElement(COOKIES);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.elementToBeClickable(cookies));
                cookies.click();
            }
            catch (Exception e){
                throw new RuntimeException("Something is wrong with cookies accept!");
            }
        }
        public static void SEARCHER_input(WebDriver driver,String Searching_text){
            try{
            WebElement searcher = driver.findElement(SEARCHER);
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(searcher));
            searcher.sendKeys(Searching_text);
            }
            catch (Exception e){
                throw new RuntimeException("Something is wrong!");
            }

        }
        public static void LOCATION_input(WebDriver driver,String Location_text){
            try{
            WebElement location = driver.findElement(LOCATION);
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(location));
            location.sendKeys(Location_text);
            }
            catch (Exception e ){
                throw new RuntimeException("Something is wrong!");
            }
        }

        public static void SUBMIT_click(WebDriver driver){
            try{
            WebElement submit = driver.findElement(SUBMIT);
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(submit));
            submit.click();
            Thread.sleep(1000);
            }
            catch (Exception e ){
                throw new RuntimeException("Something is wrong!");
            }
        }


}
