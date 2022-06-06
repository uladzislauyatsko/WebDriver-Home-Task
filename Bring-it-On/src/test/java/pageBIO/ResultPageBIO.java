package pageBIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPageBIO {
    public WebDriver driver;

    public ResultPageBIO(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    @FindBy(xpath = "//div[@class='de1']")
    WebElement pastedCodeField;

    public String pastedCodeText() {
        return pastedCodeField.getText();
    }
}
