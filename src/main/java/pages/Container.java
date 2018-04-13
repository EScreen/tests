package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 06/04/2018.
 */
public class Container {

    WebDriver driver;

    public Container(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@ng-click=\"changeUserView()\"]")
    public WebElement currentView;

    @FindBy(xpath = "//li[@id=\"profile-details\"]//a[@class=\"dropdown-toggle\"]")
    public WebElement mainUserMenu;

    @FindBy(xpath = "//a[@ui-sref=\"users.all\"]")
    public WebElement mainUserMenuUsers;

    @FindBy(xpath = "//a[@ui-sref=\"profile\"]")
    public WebElement mainUserMenuProfile;

    @FindBy(xpath = "//*[@id=\"tickets-tour\"]/a")
    public WebElement mainUserMenuTickers;

    @FindBy(xpath = "//*[@id=\"messages-tour\"]/a")
    public WebElement mainUserMenuMessages;

    @FindBy(xpath = "//*[@id=\"archive-tour\"]/a")
    public WebElement mainUserMenuLog;

    @FindBy(xpath = "//*[@id=\"logout-tour\"]/a")
    public WebElement mainUserMenuLogOut;


    @FindBy(xpath = "//*[@id=\"dashboard-sidebar-menuItem\"]/a")
    public WebElement dashboard;

    @FindBy(xpath = "//*[@id=\"media-sidebar-menuItem\"]/a")
    public WebElement media;

        @FindBy(xpath = "//*[@id=\"menu2\"]/li[1]/a")
        public WebElement createNewClip;

        @FindBy(xpath = "//*[@id=\"menu2\"]/li[2]/a")
        public WebElement clipLibrary;

        @FindBy(xpath = "//*[@id=\"menu2\"]/li[3]/a")
        public WebElement myFiles;

        @FindBy(xpath = "//*[@id=\"feeds-sidebar-menuItem\"]/a")
        public WebElement happening;


    @FindBy(xpath = "//*[@id=\"schedule-sidebar-menuItem\"]/a")
    public WebElement playlists;

        @FindBy(xpath = "//*[@id=\"block-new_block\"]/a")
        public WebElement createNewPlayList;

        @FindBy(xpath = "//*[@id=\"block-nw_pblock\"]/a")
        public WebElement createNewPowerBlock;

        @FindBy(xpath = "//*[@id=\"block-manage_blocks\"]/a")
        public WebElement managePlayLIsts;

        @FindBy(xpath = "//*[@id=\"manage_pb\"]/a")
        public WebElement managePowerBlocks;


    @FindBy(xpath = "//*[@id=\"block-result_per_device\"]/a")
    public WebElement scheduleButton;


    @FindBy(xpath = "//*[@id=\"devices-sidebar-menuItem\"]/a")
    public WebElement players;

        @FindBy(xpath = "//*[@id=\"block-new_block\"]/a")
        public WebElement playerOverview;

        @FindBy(xpath = "//*[@id=\"block-nw_pblock\"]/a")
        public WebElement playerGroups;

        @FindBy(xpath = "//*[@id=\"block-manage_blocks\"]/a")
        public WebElement resultOverview;

        @FindBy(xpath = "//*[@id=\"manage_pb\"]/a")
        public WebElement export;

    @FindBy(xpath = "//*[@id=\"radio-sidebar-menuItem\"]/a")
    public WebElement radio;

        @FindBy(xpath = "//*[@id=\"block-manage_blocks\"]/a")
        public WebElement radioPlayers;

        @FindBy(xpath = "//*[@id=\"manage_pb\"]/a")
        public WebElement radioPlayersSchedule;



    public void onProfile(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        actions.moveToElement(mainUserMenu).click().perform();
        actions.moveToElement(mainUserMenuProfile).click().perform();
    }

}
