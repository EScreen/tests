package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by Anna on 06/04/2018.
 */
public class Container {

    public SelenideElement currentView = $("a[ng-click=\"changeUserView()\"]");
        public SelenideElement loginSubUser1 = $(".dataTable.responsive>tbody>tr:nth-child(2)>td:last-child>div>a");
        public SelenideElement loginSubUser2 = $(".dataTable.responsive>tbody>tr:nth-child(3)>td:last-child>div>a");
        public SelenideElement loginToMainUser = $(".dataTable.responsive>tbody>tr:nth-child(1)>td:last-child>div>a");
    public SelenideElement mainUserMenu = $(By.xpath("//li[@id=\"profile-details\"]//a[@class=\"dropdown-toggle\"]"));
    public SelenideElement mainUserMenuUsers = $(By.xpath("//a[@ui-sref=\"users.all\"]"));
    public SelenideElement mainUserMenuProfile = $(By.xpath("//a[@ui-sref=\"profile\"]"));
    public SelenideElement mainUserMenuTickers = $(By.xpath("//*[@id=\"tickets-tour\"]/a"));
    public SelenideElement mainUserMenuMessages = $(By.xpath("//*[@id=\"messages-tour\"]/a"));
    public SelenideElement mainUserMenuLog = $(By.xpath("//*[@id=\"archive-tour\"]/a"));
    public SelenideElement mainUserMenuLogOut = $(By.xpath("//*[@id=\"logout-tour\"]/a"));
    public SelenideElement dashboard = $(By.xpath("//*[@id=\"dashboard-sidebar-menuItem\"]/a"));

    public SelenideElement media = $(By.xpath("//*[@id=\"media-sidebar-menuItem\"]/a"));
        public SelenideElement createNewClip = $(By.xpath("//*[@id=\"menu2\"]/li[1]/a"));
        public SelenideElement clipLibrary = $(By.xpath("//*[@id=\"menu2\"]/li[2]/a"));
        public SelenideElement myFiles = $(By.xpath("//*[@id=\"menu2\"]/li[3]/a"));
        public SelenideElement happening = $(By.xpath("//*[@id=\"feeds-sidebar-menuItem\"]/a"));

    public SelenideElement playlists = $(By.xpath("//*[@id=\"schedule-sidebar-menuItem\"]/a"));
        public SelenideElement createNewPlayList = $(By.xpath("//*[@id=\"block-new_block\"]/a"));
        public SelenideElement createNewPowerBlock = $(By.xpath("//*[@id=\"block-nw_pblock\"]/a"));
        public SelenideElement managePlayLIsts = $("ul[id='menu3']>li:nth-child(3)>a");
        public SelenideElement managePowerBlocks = $(By.xpath("//*[@id=\"manage_pb\"]/a"));

    public SelenideElement scheduleButton = $(By.xpath("//*[@id=\"block-result_per_device\"]/a"));

    public SelenideElement players = $(By.xpath("//*[@id=\"devices-sidebar-menuItem\"]/a"));
        public SelenideElement playerOverview = $("#devices-sidebar-menuItem>ul>li:first-child>a");
        public SelenideElement playerGroups = $(By.xpath("//*[@id=\"programming-tags\"]/a"));
        public SelenideElement resultOverview = $(By.xpath("//*[@id=\"block-manage_blocks\"]/a"));
        public SelenideElement export = $(By.xpath("//*[@id=\"manage_pb\"]/a"));

    public SelenideElement radio = $(By.xpath("//*[@id=\"radio-sidebar-menuItem\"]/a"));
        public SelenideElement radioPlayers = $(By.xpath("//*[@id=\"block-manage_blocks\"]/a"));
        public SelenideElement radioPlayersSchedule = $(By.xpath("//*[@id=\"manage_pb\"]/a"));



    public void goToSubUser1(){
        $(currentView).click();
        sleep(1000);
        $(loginSubUser1).click();
        }

    public void goToSubUser2(){
        $(currentView).click();
        sleep(1000);
        $(loginSubUser2).click();
    }

    public void goToMainUser(){
        $(currentView).click();
        sleep(1000);
        $(loginToMainUser).click();

    }


}
