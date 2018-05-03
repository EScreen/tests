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

    public SelenideElement searchField = $(By.xpath("//input[@placeholder=\"Search\"]"));
    public SelenideElement nameOfPlayList = $(By.xpath("//*[@id=\"manage-blocks-table\"]/tbody/tr/td[4]/a/strong"));

}
