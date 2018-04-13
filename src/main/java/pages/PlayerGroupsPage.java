package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anna on 06/04/2018.
 */
public class PlayerGroupsPage {

    WebDriver driver;

    public PlayerGroupsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"DataTables_Table_0_filter\"]/label/input")
    public WebElement searchField;

    @FindBy(xpath = "//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[2]/a")
    public WebElement playerGroupName;

    @FindBy(xpath = "//li[@class=\"toolbar-link\"]/a")
    public WebElement createPlayerGroupButton;

    @FindBy(xpath = "//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[4]/div/a[1]")
    public WebElement editPlayerGroupButton;

    @FindBy(xpath = "//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[4]/div/a[2]")
    public WebElement deletePlayerGroupButton;

    @FindBy(xpath = "//div[@class=\"modal-footer\"]/button[2]")
    public WebElement YesDeleteButton;

    @FindBy(xpath = "//*[@id=\"dataTables\"]/table/thead/tr/th[2]/div")
    public WebElement SortByName;

    @FindBy(xpath = "//*[@id=\"dataTables\"]/table/thead/tr/th[3]/div")
    public WebElement SortByDate;

    @FindBy(xpath = "//*[@id=\"dataTables\"]/table/thead/tr/th[3]/div")
    public WebElement addNewOptionButton;

    @FindBy(xpath = "//*[@id=\"device-tag-name\"]/input")
    public WebElement playerGroupNameField;

    @FindBy(xpath = "//*[@id=\"device-tag-options\"]/div/span/input")
    public WebElement optionField;

    @FindBy(xpath = "//*[@id=\"device-tag-options\"]/div/button")
    public WebElement removeOptionButton;

    @FindBy(xpath = "//button[@name=\"save\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"appcontent\"]/div[4]/section[2]/div/div/div[1]/div/div[2]/div/div[3]/button[2]")
    public WebElement backButton;

    @FindBy(xpath = "//*[@id=\"appcontent\"]/div[4]/flashnotification/div[2]")
    public WebElement succesSaveAlert;

    @FindBy(xpath = "//*[@id=\"appcontent\"]/div[4]/section[2]/div/div[1]/flashnotification/div[2]")
    public WebElement succesDeleteAlert;




















}
