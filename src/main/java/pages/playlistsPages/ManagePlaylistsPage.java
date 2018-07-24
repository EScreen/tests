package pages.playlistsPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 17/04/2018.
 */
public class ManagePlaylistsPage {

    public SelenideElement
            searchField = $(By.xpath("//input[@placeholder=\"Search\"]")),
    nameOfPlayList = $("#manage-blocks-table>tbody>tr>td:nth-child(4)>a>strong"),
    statusPlaylistSelector = $(By.xpath("//select[@ng-change=\"changeActiveFilter()\"]")),

    lastPlaylistName = $(By.cssSelector("tr.ng-scope:last-child > td:nth-child(4) > a > strong")),
    firstPlaylistName = $(By.cssSelector("tr.ng-scope:first-child > td:nth-child(4) > a > strong")),

    formulaTab = $("#formula-tab-library"),


    //Single User
    nameOfPlayListSU = $("tbody>tr:first-child>td:nth-child(3) span");
}
