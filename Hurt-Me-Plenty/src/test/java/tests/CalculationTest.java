package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;

public class CalculationTest {
    public static WebDriver driver;

    @BeforeClass
    public static void setup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigProperties.getProperty("mainPageUrl"));
    }

    @Test
    public void calculationTest () {

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));


        MainPage mainPage = new MainPage(driver);
        mainPage.openSearchBar();
        mainPage.searchForCalculator(ConfigProperties.getProperty("searchText"));


    }
}
