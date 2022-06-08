package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;
    public MainPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
        @FindBy (xpath = "//input[@name='q']")
        WebElement searchBtn;

        @FindBy (xpath = "//input[@role='search'")
        WebElement searchBar;

        public void openSearchBar () {searchBtn.click();}

        public void searchForCalculator(String searchTextInput) {searchBar.sendKeys(searchTextInput);}

    }

