package pages.mediaPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 20/04/2018.
 */
public class MyFilesPage {

    public SelenideElement categorySelector = $(By.xpath("//select[@ng-model=\"data.category\"]"));

}
