package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    public WebDriver driver;
    public CalculatorPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//input[@name='quantity'")
    WebElement instanceQuantity;

    @FindBy (id = "select_98")
    WebElement operatingSystemDropdown;

    @FindBy (xpath = "////li[text()[contains(.,'Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)')]]")
    WebElement operatingSystem;

    @FindBy (id = "select_102")
    WebElement virtualMachineTypeDropdown;

    @FindBy (id = "select_112")
    WebElement machineTypeDropdown;

    @FindBy (id = "select_110")
    WebElement seriesTypeDropdown;

    public void setInstanceQuantity () {
        instanceQuantity.sendKeys("4");
    }


}
