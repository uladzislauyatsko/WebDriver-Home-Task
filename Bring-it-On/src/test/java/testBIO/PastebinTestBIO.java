package testBIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageBIO.ResultPageBIO;

import pageBIO.PastebinPageBIO;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class PastebinTestBIO {
    public static WebDriver driver;


    @BeforeClass
    public static void setup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfPropertiesBIO.getProperty("landingPageUrl"));
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

        PastebinPageBIO pasteBin = new PastebinPageBIO(driver);

        pasteBin.pasteCode(ConfPropertiesBIO.getProperty("pasteCodeValue"));
        pasteBin.openDropdown();
        pasteBin.selectExpirationTime(ConfPropertiesBIO.getProperty("pasteExpirationValue"));
        pasteBin.pasteNameInput(ConfPropertiesBIO.getProperty("pasteNameValue"));
        pasteBin.submitPaste();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='de1']")));

        ResultPageBIO resultCheck = new ResultPageBIO(driver);
        StringTokenizer stringTokenizer = new StringTokenizer(ConfPropertiesBIO.getProperty("pasteCodeValue")," \n");
        StringTokenizer secondTokenizer = new StringTokenizer(resultCheck.pastedCodeText(), " \n");
        ArrayList<String> baseStringArray = new ArrayList<>();
        ArrayList<String> stringToCompare = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()) {
            baseStringArray.add(stringTokenizer.nextToken());
        }
        while(secondTokenizer.hasMoreTokens()){
            stringToCompare.add(secondTokenizer.nextToken());
        }
        Assert.assertEquals(baseStringArray, stringToCompare, "Pasted and saved data is different!");

    }
    @AfterClass
    public static void tearDown () {
        driver.quit();
    }
}
