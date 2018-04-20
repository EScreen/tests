package pages.profilePages;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 05/04/2018.
 */
public class ProfileSettingsPage {

    public SelenideElement changeAvatarButton = $(By.xpath("//button[@class=\"btn btn-mini btn-blue ng-binding\"]"));
    public SelenideElement removeAvatarButton = $(By.xpath("//button[@class=\"btn btn-mini btn-red ng-binding ng-scope\"]"));
    public SelenideElement saveProfileDataButton = $(By.xpath("//*[@id=\"general\"]/form/div[2]/button[1]"));
    public SelenideElement backButton = $(By.xpath("//*[@id=\"general\"]/form/div[2]/button[2]"));
    public SelenideElement successSaveAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/flashnotification/div[2]"));
    public SelenideElement errorSaveAlert = $(By.xpath("html/body/div[1]/div[4]/flashnotification/div[1]"));


/////General Tab

    public SelenideElement nameField = $(By.xpath("//*[@id=\"general\"]/form/div[1]/div[2]/div/input"));
    public SelenideElement surnameField = $(By.xpath("//*[@id=\"general\"]/form/div[1]/div[3]/div/input"));
    public SelenideElement emailField = $(By.xpath("//*[@id=\"general\"]/form/div[1]/div[4]/div/input"));
    public SelenideElement languageDropDawn = $(By.xpath("//*[@id=\"general\"]/form/div[1]/div[5]/div/select"));
    public SelenideElement addressField = $(By.xpath("//*[@id=\"general\"]/form/div[1]/div[6]/div/input"));
    public SelenideElement postalCodeField = $(By.xpath("//*[@id=\"general\"]/form/div[1]/div[7]/div/input"));
    public SelenideElement cityField = $(By.xpath("//*[@id=\"general\"]/form/div[1]/div[8]/div/input"));
    public SelenideElement telephoneNumberField = $(By.xpath("//*[@id=\"general\"]/form/div[1]/div[9]/div/input"));
    public SelenideElement functionField = $(By.xpath("//*[@id=\"general\"]/form/div[1]/div[10]/div/input"));
    public SelenideElement departamentField = $(By.xpath("//*[@id=\"general\"]/form/div[1]/div[11]/div/input"));
    public SelenideElement sendTicketsCkeckBox = $(By.xpath("//*[@id=\"general\"]/form/div[1]/div[12]/div/div/ins"));

/////Password Tab

    public SelenideElement savePasswordButton = $(By.xpath("//*[@id=\"password\"]/form/div[2]/button[1]"));
    public SelenideElement backPasswordButton = $(By.xpath("//*[@id=\"password\"]/form/div[2]/button[2]"));
    public SelenideElement passwordTab = $(By.xpath("//a[@href=\"#password\"]"));
    public SelenideElement oldPasswordField = $(By.xpath("//*[@id=\"password\"]/form/div[1]/div[2]/div/input"));
    public SelenideElement newPasswordField = $(By.xpath("//*[@id=\"password\"]/form/div[1]/div[3]/div/input"));
    public SelenideElement repeatPasswordField = $(By.xpath("//*[@id=\"password\"]/form/div[1]/div[4]/div/input"));


/////Colors Tab

    public SelenideElement saveColoursButton = $(By.xpath("//*[@id=\"colors\"]/form/div[2]/button[1]"));
    public SelenideElement backColorsButton = $(By.xpath("//*[@id=\"colors\"]/form/div[2]/button[2]"));
    public SelenideElement colorsTab = $(By.xpath("//a[@href=\"#colors\"]"));
    public SelenideElement addColorButton = $(By.xpath("//*[@id=\"colors\"]/form/div[1]/div[2]/label/button"));
    public SelenideElement colorPicker = $(By.xpath("//div[@class=\"colorpicker_input\"]"));
    public SelenideElement colorInputField = $(By.xpath("//*[@id=\"collorpicker_257\"]/div[5]/input"));
    public SelenideElement saveColorButton = $(By.xpath("//button[@ng-click=\"saveColor()\"]"));

/////Messages Tab

    public SelenideElement messagesTab = $(By.xpath("//a[@href=\"#notifications\"]"));
    public SelenideElement saveMessagesButton = $(By.xpath("//*[@id=\"notifications\"]/form/div[2]/button[1]"));
    public SelenideElement backMessagesButton = $(By.xpath("//*[@id=\"notifications\"]/form/div[2]/button[2]"));
    public SelenideElement receiveAsMesIncomingMes = $(By.xpath("//*[@id=\"notifications\"]/form/div[1]/table/tbody/tr[4]/td[2]/div/input"));

    }





