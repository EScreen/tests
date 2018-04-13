package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anna on 06/04/2018.
 */
public class CreateNewClipPage {
    WebDriver driver;

    public CreateNewClipPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"template-name-search\"]/input")
    public WebElement searchField;

    @FindBy(xpath = "//*[@id=\"template-categories-select\"]/form/div/div/span")
    public WebElement categoriesSelect;

    @FindBy(xpath = "//*[@id=\"template-orientation-select\"]/form/div/div/span")
    public WebElement orientationSelect;

    @FindBy(xpath = "//*[@id=\"template-orientation-select\"]/form/div/div/div/div[2]/span[1]")
    public WebElement portraitOrientation;

    @FindBy(xpath = "//*[@id=\"template-list\"]/div/div[1]/div/div[3]/div/div[1]/div[1]/ul/li[1]/div/a")
    public WebElement templateforTest;

    @FindBy(xpath = "//button[@ng-click=\"nextStep()\"]")
    public WebElement nextButton;

    @FindBy(id = "fragmentname")
    public WebElement templateforTestNameField;

    @FindBy(xpath = "//input[@name=\"duration1\"]")
    public WebElement templateforTestDurationField;

    @FindBy(xpath = "//*[@id=\"simplemodal-data\"]/div[4]/div/span[2]/button[3]")
    public WebElement saveClipButton;

    @FindBy(xpath = "//div[@class=\"scroller-content\"]/span[4]")
    public WebElement categoryTest;

    @FindBy(xpath = "//div[@class=\"row-fluid box-tour\"]/div/h3")
    public WebElement nameOfCategory;

    @FindBy(xpath = "//*[@id=\"template-list\"]/div/div[1]/div/div[1]/div/div[1]/div[1]/ul/li/div/img")
    public WebElement portraitTemplate;

    @FindBy(xpath = "//*[@id=\"template-list\"]/div/div[1]/div/div/div/div[1]/div[1]/ul/li/div/a")
    public WebElement nameOfClip;

    public String categoryGetText(WebElement categoryTest){
        return categoryTest.getText();
    }

}
