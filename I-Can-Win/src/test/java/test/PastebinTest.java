package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.PastebinPage;
import page.ResultPage;

public class PastebinTest {
    public static WebDriver driver;


    @BeforeClass
    public static void setup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("landingPageUrl"));
    }

    @Test
    public void pastebinTest () {

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("select2-postform-expiration-container")));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-name")));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));

        PastebinPage pasteBin = new PastebinPage(driver);

        pasteBin.pasteCode(ConfProperties.getProperty("pasteCodeValue"));
        pasteBin.openDropdown();
        pasteBin.selectExpirationTime(ConfProperties.getProperty("pasteExpirationValue"));
        pasteBin.pasteNameInput(ConfProperties.getProperty("pasteNameValue"));
        pasteBin.submitPaste();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='de1']")));

        ResultPage resultCheck = new ResultPage(driver);

        Assert.assertTrue(resultCheck.pastedCodeText()
                .contains(ConfProperties.getProperty("pasteCodeValue")), "Pasted and saved data is different!");

    }
    @AfterClass
    public static void tearDown () {
        driver.quit();
    }
}
