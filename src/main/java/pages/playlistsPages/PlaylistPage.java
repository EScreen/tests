package pages.playlistsPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 20/04/2018.
 */
public class PlaylistPage {

    public SelenideElement nameOfPlaylistField = $(By.xpath("//*[@ng-model=\"data.name\"]"));
    public SelenideElement namesOfClips = $(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//span[@class=\"ng-binding\"]"));

}
