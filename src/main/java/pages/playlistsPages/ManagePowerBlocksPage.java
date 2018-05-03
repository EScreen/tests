package pages.playlistsPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by qwerty on 5/3/18.
 */
public class ManagePowerBlocksPage {

    public SelenideElement powerBlocksNames = $(By.xpath("//span[@class=\"ng-binding ng-scope\"]"));
    public SelenideElement nameOfPlayList = $(By.xpath("//*[@id=\"manage-blocks-table\"]/tbody/tr/td[4]/a/strong"));

}
