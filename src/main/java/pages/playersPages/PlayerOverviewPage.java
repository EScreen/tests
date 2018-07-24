package pages.playersPages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PlayerOverviewPage {

    public SelenideElement
            statusSelector = $("select[ng-model='params.show_players']"),
    searchInput = $("input[ng-model='params.search']"),
    tickertapeButton = $("tbody>tr>td:nth-child(1)>a"),
    playerLogo = $("tbody>tr>td:nth-child(2)>span"),
    successMessage = $("div[flash-alert='success']"),


    //Tickertape

    tickertapeSelector = $(".controls.tickertape-select>select"),
    saveTickertape = $("button[type='submit']");

    public ElementsCollection playerLogos = $$("tbody>tr");

}
