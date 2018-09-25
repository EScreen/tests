package flexibleTool.templateStuff;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.mediaPages.FlexibleToolPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ImageTests {
    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests_Flexible();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void uploadImageFromPC(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.templateNameInput).setValue(GenerateData.generateString(3));
        $(flexibleToolPage.templateDurationInput).setValue("5");

        $(flexibleToolPage.imageButton).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.setImage).click();
        $(flexibleToolPage.uploadButton).click();
        File file = new File("/Users/qa-tester/IdeaProjects/tests/src/main/resources/car.jpg");
        $("#items").uploadFile(file);
        sleep(1000);

        $(flexibleToolPage.saveButton).click();
        $(flexibleToolPage.successAlert).shouldBe(Condition.appear);
        open(flexibleToolPage.clipLibrSrc);

        flexibleToolPage.openPreview();

        $("div>img").shouldBe(Condition.visible);
    }

    @Test
    public void uploadImgFromLibr(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.templateNameInput).setValue(GenerateData.generateString(3));
        $(flexibleToolPage.templateDurationInput).setValue("5");

        $(flexibleToolPage.imageButton).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.setImage).click();
        $("div.library>div:nth-child(10)").click();
        sleep(2000);

        $(flexibleToolPage.saveButton).click();
        $(flexibleToolPage.successAlert).shouldBe(Condition.appear);
        open(flexibleToolPage.clipLibrSrc);

        flexibleToolPage.openPreview();
        $("div>img").shouldBe(Condition.visible);
    }

    @Test
    public void librarySorting(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.imageButton).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.setImage).click();

        $("input[placeholder='Category']").click();
        $(By.xpath("//li[@class=\"el-select-dropdown__item\"]/span[contains(text(),'Three')]")).click();

        $$("div.library>div").shouldHave(CollectionCondition.size(3));
    }

    @Test
    public void searchImgInLibr(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.imageButton).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.setImage).click();

        String searchedImg = $("div.library>div:nth-child(3)>p").text();

        $(flexibleToolPage.searchInput).setValue(searchedImg);

        $("div.library>div:first-child>p").shouldHave(Condition.exactText(searchedImg));
    }

    @Test
    public void resizeImg(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();

        $(flexibleToolPage.imageButton).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.setImage).click();
        $("div.library>div:nth-child(10)").click();

        int heightBefore = $("div.vdr.draggable.resizable > img").getSize().height;

        $(".canvas.landscape img").click();
        SelenideElement dragPoint = $("div.vdr.draggable.resizable > div.handle.handle-bm");
        Selenide.actions().dragAndDropBy(dragPoint, 0, -30).build().perform();

        int heightAfter = $("div.vdr.draggable.resizable.active > img").getSize().height;

        Assert.assertNotEquals(heightBefore, heightAfter);
    }

   /* @Test
    public void cropImg(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();

        $(flexibleToolPage.imageButton).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.setImage).click();
        $("div.library>div:nth-child(10)").click();

        int widthBefore = $("div.vdr.draggable.resizable > img").getSize().width;
        System.out.println(widthBefore);

        $(".canvas.landscape img").click();
        $(flexibleToolPage.cropButton).click();

        Selenide.actions().dragAndDropBy($("span.cropper-point.point-nw"), 180, 50).build().perform();
        sleep(2000);

        $(flexibleToolPage.acceptCropping).click();
        $(flexibleToolPage.saveCropping).click();

        int widthAfter = $("div.vdr.draggable.resizable > img").getSize().width;
        sleep(2000);
        System.out.println(widthAfter);

        Assert.assertNotEquals(widthBefore, widthAfter);
    }*/

    @Test
    public void deleteImg(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();

        $(flexibleToolPage.imageButton).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.setImage).click();
        $(flexibleToolPage.uploadButton).click();
        File file = new File("/Users/qa-tester/IdeaProjects/tests/src/main/resources/car.jpg");
        $("#items").uploadFile(file);

        $(".canvas.landscape img").click();
        $(flexibleToolPage.deleteImgButton).click();

        $(".canvas.landscape img").shouldNotBe(Condition.visible);
    }
}
