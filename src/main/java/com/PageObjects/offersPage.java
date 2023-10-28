package com.PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

public class offersPage {


        // DROP-DOWN "CATEGORY"
        static By dropCATEGORY = By.xpath("//*[@id=\"mainContent\"]/div[2]/form/div[3]/div[1]/div/div[1]/div/div/div/div");

        // CATEGORY "Praca"
        static By dropCATEGORY_praca = By.xpath("//*[@id=\"mainContent\"]/div[2]/form/div[3]/div[1]/div/div[1]/div/div/div[2]/ul/li[5]/div");
        //  "Praca" sub-categories
        static  By praca_ALL = By.xpath("//span[normalize-space()='Wszystkie w Praca']");
        static By praca_IT = By.xpath("//span[normalize-space()='IT / telekomunikacja']");

        // CATEGORY "Dom i Ogrod"
        static By dropCATEGORY_domiogrod = By.xpath("//*[@id=\"mainContent\"]/div[2]/form/div[3]/div[1]/div/div[1]/div/div/div[2]/ul/li[6]/div/span[1]");


        // OTHERS
        static By CONTRACT_TYPE = By.xpath("//div[@class='css-c5h5gn']//div[1]//div[1]//div[1]//div[1]//div[1]");
        static By WORKLOAD = By.xpath("//div[@class='css-tx3aze']//div[4]//div[1]//div[1]//div[1]//div[1]//span[1]");
        static By EXPERIENCE = By.xpath("//div[@class='css-1d90tha']//div[5]//div[1]//div[1]//div[1]//div[1]//span[1]");
        static By COUNTER = By.xpath("//span[@data-testid='total-count']");
        static By SUBCATEGORY = By.xpath("//div[@class='css-12snx2d']");


        public static void set_dropCATEGORY_dropSUBCATEGORY(WebDriver driver, String category_name, String sub_category_name) throws InterruptedException {
                if (category_name.equalsIgnoreCase("praca")) {
                        WebElement dropCategory = driver.findElement(dropCATEGORY);

                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                        wait.until(ExpectedConditions.visibilityOf(dropCategory));
                        dropCategory.click();
                       ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400)");
                       Thread.sleep(1000);



                        WebElement praca = driver.findElement(dropCATEGORY_praca);
                        wait.until(ExpectedConditions.visibilityOf(praca));
                        Thread.sleep(1000);
                        Actions actions = new Actions(driver);
                        actions.moveToElement(praca).build().perform();


                }else if (category_name.equalsIgnoreCase("dom i ogród")) {
                        WebElement dropCategory = driver.findElement(dropCATEGORY);

                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                        wait.until(ExpectedConditions.elementToBeClickable(dropCategory));
                        dropCategory.click();


                        WebElement domiogrod = driver.findElement(dropCATEGORY_domiogrod);
                        wait.until(ExpectedConditions.visibilityOf(domiogrod));
                        Thread.sleep(1000);
                        Actions actions = new Actions(driver);
                        actions.moveToElement(domiogrod).build().perform();

                } else  {
                        throw new InterruptedException("Invalid category_name parameter. Check executing xml file "+category_name);
                }


                if (sub_category_name.equalsIgnoreCase("IT")) {

                        WebElement praca_it = driver.findElement(praca_IT);
                        WebElement praca_all = driver.findElement(praca_ALL);

                        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
                        wait1.until(ExpectedConditions.elementToBeClickable(praca_it));

                        Actions actions = new Actions(driver);
                        actions.moveToElement(praca_all).build().perform();
                        Thread.sleep(1000);


                        actions.moveToElement(praca_it).click().perform();
                        Thread.sleep(1000);




                } else  {
                        throw new InterruptedException("Invalid sub_category_name parameter. Check executing xml file "+sub_category_name);
                }

        }

        public static int get_COUNTER_value(WebDriver driver){
                WebElement counter= driver.findElement(COUNTER);

                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
                wait.until(ExpectedConditions.visibilityOf(counter));

                String counter_text = counter.getText();
                String numberOnly= counter_text.replaceAll("[^0-9]", "");

                return Integer.parseInt(numberOnly);

        }

}
