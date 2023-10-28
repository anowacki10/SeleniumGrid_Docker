package testCases;



import com.PageObjects.mainPage;
import com.PageObjects.offersPage;
import com.TestBase.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Tests extends WebDriverFactory {


    @Parameters({"searchingText","locationText","expectedURL1"})
    @Test(priority = 1)
    public void shouldSearchForOffer(String searchingText, String locationText, String expectedURL1) throws InterruptedException {


        mainPage.COOKIES_click(driver);
        mainPage.SEARCHER_input(driver,searchingText);
        mainPage.LOCATION_input(driver,locationText);
        mainPage.SUBMIT_click(driver);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL1);

    }


    @Parameters({"searchingText","locationText","categoryName","subCategoryName","expectedURL2"})
    @Test(priority = 2)
    public void shouldPrintAmountOfQaOffers(String searchingText,String locationText,String categoryName,String subCategoryName,String expectedURL2) throws InterruptedException {

        mainPage.COOKIES_click(driver);
        mainPage.SEARCHER_input(driver,searchingText);
        mainPage.LOCATION_input(driver,locationText);
        mainPage.SUBMIT_click(driver);
        offersPage.set_dropCATEGORY_dropSUBCATEGORY(driver,categoryName,subCategoryName);
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL2);
    }
}
