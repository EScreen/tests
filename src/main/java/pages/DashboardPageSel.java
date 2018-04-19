package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 18/04/2018.
 */
public class DashboardPageSel {

    public SelenideElement createClipButton1 = $(By.xpath("//*[@id=\"dushbutton--1\"]/a/div/i"));
    public SelenideElement searchField1 = $(By.xpath("//*[@id=\"template-name-search\"]/input"));
    public SelenideElement templateTestNameField = $(By.id("fragmentname"));
    public SelenideElement templateExistedPlaylistField = $(By.xpath("//li[@class=\"select2-search-field\"]/input"));
    public SelenideElement firstExistedPlaylist = $(By.xpath("//div[@ng-bind-html=\"playlist.name | highlight: $select.search\"]"));
    public SelenideElement nextButton = $(By.cssSelector("#simplemodal-data > div.wizard-modal-footer > div > button.btn.wizard-next.btn-blue.ng-scope"));
    public SelenideElement templateTestDurationField = $(By.xpath("//input[@name=\"duration1\"]"));
    public SelenideElement saveClipButton = $(By.xpath("//*[@id=\"simplemodal-data\"]/div[4]/div/span[2]/button[3]"));
    public SelenideElement playlists = $(By.xpath("//*[@id=\"schedule-sidebar-menuItem\"]/a"));
    public SelenideElement managePlaylists = $(By.xpath("//*[@id=\"block-manage_blocks\"]/a"));
    public SelenideElement searchField = $(By.xpath("//input[@placeholder=\"Search\"]"));
    public SelenideElement nameOfPlayList = $(By.xpath("//*[@id=\"manage-blocks-table\"]/tbody/tr[1]/td[4]/a/strong"));








}
