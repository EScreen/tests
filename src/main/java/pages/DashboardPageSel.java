package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

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


}
