package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anna on 16/04/2018.
 */
public class ClipLibraryPage {
    WebDriver driver;

    public ClipLibraryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"owned-tab-library\"]/a")
    public WebElement ownTab;

    @FindBy(xpath = "//*[@id=\"formula-tab-library\"]/a")
    public WebElement formulaTab;

    @FindBy(xpath = "//*[@id=\"other-tab-library\"]/a")
    public WebElement otherTab;

    @FindBy(xpath = "//*[@id=\"approve-tab-library\"]/a")
    public WebElement needApprovalTab;

    @FindBy(xpath = "//input[@placeholder=\"Search\"]")
    public WebElement searchField;

    @FindBy(xpath = "//select[@ng-change=\"changeCategory()\"]")
    public WebElement categoryDropDawn;

    @FindBy(xpath = "//li[@ng-if=\"manage_cats\"]/a")
    public WebElement managementCategoriesbutton;

    @FindBy(xpath = "//button[@class=\"btn btn-mini btn-default dropdown-toggle\"]")
    public WebElement settingsClipButton;

        @FindBy(xpath = "//*[@id=\"dataTables\"]/table/tbody[1]/tr/td[9]/div/ul/li[2]/a[1]")
        public WebElement editClipButton;

        @FindBy(xpath = "//*[@id=\"dataTables\"]/table/tbody[1]/tr/td[9]/div/ul/li[3]/a")
        public WebElement shareClipButton;

        @FindBy(xpath = "//*[@id=\"dataTables\"]/table/tbody[1]/tr/td[9]/div/ul/li[5]/a")
        public WebElement deleteClipButton;



}
