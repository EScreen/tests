package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anna on 17/04/2018.
 */
public class ManagePlaylistsPage {

    WebDriver driver;

    public ManagePlaylistsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@placeholder=\"Search\"]")
    public WebElement searchField;

    @FindBy(xpath = "//*[@id=\"manage-blocks-table\"]/tbody/tr[1]/td[4]/a/strong")
    public WebElement nameOfPlayList;


}
