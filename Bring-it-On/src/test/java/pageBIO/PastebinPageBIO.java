package pageBIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinPageBIO {
    public WebDriver driver;
    public PastebinPageBIO(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    @FindBy(id = "postform-text" )
    WebElement pasteCodeField;

    @FindBy (id = "select2-postform-expiration-container" )
    WebElement dropDownBtn;

    @FindBy (id = "select2-postform-format-container" )
    WebElement styleDropDown;

    @FindBy (xpath = "//li[text()[contains(.,'10 Minutes')]]" )
    WebElement expirationOption;

    @FindBy (xpath = "//li[text()[contains(.,'Bash')]]")
    WebElement syntaxHighlightOption;

    @FindBy (id = "postform-name" )
    WebElement pasteName;

    @FindBy (xpath = "//button[@type='submit']" )
    WebElement pasteBtn;


    public void pasteCode(String pasteCode){ pasteCodeField.sendKeys(pasteCode); }

    public void openDropdown (){
        dropDownBtn.click();
    }

    public void openStyleDropDown () {styleDropDown.click();}

    public void selectSyntaxHighlightOption(String syntaxHighlight) {syntaxHighlightOption.click();}

    public void selectExpirationTime(String pasteExpirationValue){
        expirationOption.click();
    }

    public void pasteNameInput(String pasteNameInput){
        pasteName.sendKeys(pasteNameInput);
    }

    public void submitPaste (){
        pasteBtn.click();
    }
    }



