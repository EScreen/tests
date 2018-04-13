package pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anna on 05/04/2018.
 */
public class ProfileSettingsPage {

    WebDriver driver;

    public ProfileSettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@class=\"btn btn-mini btn-blue ng-binding\"]")
    public WebElement changeAvatarButton;

    @FindBy(xpath = "//button[@class=\"btn btn-mini btn-red ng-binding ng-scope\"]")
    public WebElement removeAvatarButton;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[2]/button[1]")
    public WebElement saveProfileDataButton;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[2]/button[2]")
    public WebElement backButton;

    @FindBy(xpath = "//*[@id=\"appcontent\"]/div[4]/flashnotification/div[2]")
    public WebElement successSaveAlert;

    @FindBy(xpath = "html/body/div[1]/div[4]/flashnotification/div[1]")
    public WebElement errorSaveAlert;


/////General Tab


    @FindBy(xpath = "//*[@id=\"general\"]/form/div[1]/div[2]/div/input")
    public WebElement nameField;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[1]/div[3]/div/input")
    public WebElement surnameField;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[1]/div[4]/div/input")
    public WebElement emailField;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[1]/div[5]/div/select")
    public WebElement languageDropDawn;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[1]/div[6]/div/input")
    public WebElement addressField;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[1]/div[7]/div/input")
    public WebElement postalCodeField;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[1]/div[8]/div/input")
    public WebElement cityField;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[1]/div[9]/div/input")
    public WebElement telephoneNumberField;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[1]/div[10]/div/input")
    public WebElement functionField;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[1]/div[11]/div/input")
    public WebElement departamentField;

    @FindBy(xpath = "//*[@id=\"general\"]/form/div[1]/div[12]/div/div/ins")
    public WebElement sendTicketsCkeckBox;

/////Password Tab

    @FindBy(xpath = "//*[@id=\"password\"]/form/div[2]/button[1]")
    public WebElement savePasswordButton;

    @FindBy(xpath = "//*[@id=\"password\"]/form/div[2]/button[2]")
    public WebElement backPasswordButton;


    @FindBy(xpath = "//a[@href=\"#password\"]")
    public WebElement passwordTab;

    @FindBy(xpath = "//*[@id=\"password\"]/form/div[1]/div[2]/div/input")
    public WebElement oldPasswordField;

    @FindBy(xpath = "//*[@id=\"password\"]/form/div[1]/div[3]/div/input")
    public WebElement newPasswordField;

    @FindBy(xpath = "//*[@id=\"password\"]/form/div[1]/div[4]/div/input")
    public WebElement repeatPasswordField;

/////Colors Tab

    @FindBy(xpath = "//*[@id=\"colors\"]/form/div[2]/button[1]")
    public WebElement saveColoursButton;

    @FindBy(xpath = "//*[@id=\"colors\"]/form/div[2]/button[2]")
    public WebElement backColorsButton;

    @FindBy(xpath = "//a[@href=\"#colors\"]")
    public WebElement colorsTab;

    @FindBy(xpath = "//*[@id=\"colors\"]/form/div[1]/div[2]/label/button")
    public WebElement addColorButton;

    @FindBy(xpath = "//div[@class=\"colorpicker_input\"]")
    public WebElement colorPicker;

    @FindBy(xpath = "//*[@id=\"collorpicker_257\"]/div[5]/input")
    public WebElement colorInputField;

    @FindBy(xpath = "//button[@ng-click=\"saveColor()\"]")
    public WebElement saveColorButton;

/////Messages Tab

    @FindBy(xpath = "//a[@href=\"#notifications\"]")
    public WebElement messagesTab;

    @FindBy(xpath = "//*[@id=\"notifications\"]/form/div[2]/button[1]")
    public WebElement saveMessagesButton;

    @FindBy(xpath = "//*[@id=\"notifications\"]/form/div[2]/button[2]")
    public WebElement backMessagesButton;

    @FindBy(xpath = "//*[@id=\"notifications\"]/form/div[1]/table/tbody/tr[4]/td[2]/div/input")
    public WebElement receiveAsMesIncomingMes;








    }





