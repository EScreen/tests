package pages.playersPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PlayerOverviewPage {

    public SelenideElement statusSelector = $("select[ng-model='params.show_players']");
    public SelenideElement searchInput = $("input[ng-model='params.search']");
    public SelenideElement tickertapeButton = $("tbody>tr>td:nth-child(1)>a");
    public ElementsCollection playerLogos = $$("tbody>tr");
    public SelenideElement playerLogo = $("tbody>tr>td:nth-child(2)>span");
    public SelenideElement successMessage = $("div[flash-alert='success']");


    //Tickertape

    public SelenideElement tickertapeSelector = $(".controls.tickertape-select>select");
    public SelenideElement saveTickertape = $("button[type='submit']");

}
