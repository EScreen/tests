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

    public SelenideElement
            currentView = $("a[ng-click=\"changeUserView()\"]"),
        loginSubUser1 = $(".dataTable.responsive>tbody>tr:nth-child(2)>td:last-child>div>a"),
        loginSubUser2 = $(".dataTable.responsive>tbody>tr:nth-child(3)>td:last-child>div>a"),
        loginToMainUser = $(".dataTable.responsive>tbody>tr:nth-child(1)>td:last-child>div>a"),
    mainUserMenu = $(By.xpath("//li[@id=\"profile-details\"]//a[@class=\"dropdown-toggle\"]")),
    mainUserMenuUsers = $(By.xpath("//a[@ui-sref=\"users.all\"]")),
    mainUserMenuProfile = $(By.xpath("//a[@ui-sref=\"profile\"]")),
    mainUserMenuTickers = $(By.xpath("//*[@id=\"tickets-tour\"]/a")),
    mainUserMenuMessages = $(By.xpath("//*[@id=\"messages-tour\"]/a")),
    mainUserMenuLog = $(By.xpath("//*[@id=\"archive-tour\"]/a")),
    mainUserMenuLogOut = $(By.xpath("//*[@id=\"logout-tour\"]/a")),
    dashboard = $(By.xpath("//*[@id=\"dashboard-sidebar-menuItem\"]/a")),

     media = $(By.xpath("//*[@id=\"media-sidebar-menuItem\"]/a")),
        createNewClip = $(By.xpath("//*[@id=\"menu2\"]/li[1]/a")),
        clipLibrary = $(By.xpath("//*[@id=\"menu2\"]/li[2]/a")),
        myFiles = $(By.xpath("//*[@id=\"menu2\"]/li[3]/a")),
        happening = $(By.xpath("//*[@id=\"feeds-sidebar-menuItem\"]/a")),

    playlists = $(By.xpath("//*[@id=\"schedule-sidebar-menuItem\"]/a")),
        createNewPlayList = $(By.xpath("//*[@id=\"block-new_block\"]/a")),
        createNewPowerBlock = $(By.xpath("//*[@id=\"block-nw_pblock\"]/a")),
        managePlayLIsts = $("ul[id='menu3']>li:nth-child(3)>a"),
        managePowerBlocks = $(By.xpath("//*[@id=\"manage_pb\"]/a")),

    scheduleButton = $(By.xpath("//*[@id=\"block-result_per_device\"]/a")),

    players = $(By.xpath("//*[@id=\"devices-sidebar-menuItem\"]/a")),
        playerOverview = $("#devices-sidebar-menuItem>ul>li:first-child>a"),
        playerGroups = $(By.xpath("//*[@id=\"programming-tags\"]/a")),
        resultOverview = $(By.xpath("//*[@id=\"block-manage_blocks\"]/a")),
        export = $(By.xpath("//*[@id=\"manage_pb\"]/a")),

    radio = $(By.xpath("//*[@id=\"radio-sidebar-menuItem\"]/a")),
        radioPlayers = $(By.xpath("//*[@id=\"block-manage_blocks\"]/a")),
        radioPlayersSchedule = $(By.xpath("//*[@id=\"manage_pb\"]/a"));



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
