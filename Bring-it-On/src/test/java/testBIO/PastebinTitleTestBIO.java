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
import pageBIO.PastebinPageBIO;
import pageBIO.ResultPageBIO;

public class PastebinTitleTestBIO {
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
                .until(ExpectedConditions.presenceOfElementLocated(By.id("select2-postform-format-container")));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("select2-postform-expiration-container")));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-name")));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));

        PastebinPageBIO pasteBin = new PastebinPageBIO(driver);

        pasteBin.pasteCode(ConfPropertiesBIO.getProperty("pasteCodeValue"));
        pasteBin.openStyleDropDown();
        pasteBin.selectSyntaxHighlightOption("syntaxHighlight");
        pasteBin.openDropdown();
        pasteBin.selectExpirationTime(ConfPropertiesBIO.getProperty("pasteExpirationValue"));
        pasteBin.pasteNameInput(ConfPropertiesBIO.getProperty("pasteNameValue"));
        pasteBin.submitPaste();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='de1']")));


        ResultPageBIO resultCheck = new ResultPageBIO(driver);
        String title = resultCheck.getPageTitle();
        Assert.assertEquals(title, "how to gain dominance among developers - Pastebin.com");

    }
    @AfterClass
    public static void tearDown () {
        driver.quit();
    }
}
