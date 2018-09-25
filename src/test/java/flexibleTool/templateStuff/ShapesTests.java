package flexibleTool.templateStuff;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import helpers.Precondition;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.mediaPages.FlexibleToolPage;

import static com.codeborne.selenide.Selenide.*;

public class ShapesTests {
    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests_Flexible();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void addFigures(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.shapesButton).click();

        $(flexibleToolPage.rectangle).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.square).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.ellipse).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.circle).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.line).dragAndDropTo($(flexibleToolPage.wrapper));

        $$(flexibleToolPage.canvasItems).shouldHave(CollectionCondition.size(6));

    }

    @Test
    public void deleteFigure(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.shapesButton).click();

        $(flexibleToolPage.rectangle).dragAndDropTo($(flexibleToolPage.wrapper));

        $(flexibleToolPage.shapeOnCanvas).click();
        $(flexibleToolPage.deleteShapeButton).click();

        $$(flexibleToolPage.canvasItems).shouldHave(CollectionCondition.size(1));
    }

    @Test
    public void duplicateFigure(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.shapesButton).click();

        $(flexibleToolPage.rectangle).dragAndDropTo($(flexibleToolPage.wrapper));

        $(flexibleToolPage.shapeOnCanvas).click();
        $(flexibleToolPage.duplicateButton).click();

        $$(flexibleToolPage.canvasItems).shouldHave(CollectionCondition.size(3));
    }

    @Test
    public void changeShapeColor(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.shapesButton).click();

        $(flexibleToolPage.rectangle).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.shapeOnCanvas).click();
        $(flexibleToolPage.colorButton).click();

        Selenide.executeJavaScript("arguments[0].click();", $(flexibleToolPage.colorPicker));

        $("div.el-input.el-input--mini>input").setValue("rgba(26, 203, 82, 1)");
        $(flexibleToolPage.saveColorButton).click();

        $("div.rectangle.el-tooltip.item").
                shouldHave(Condition.cssValue("background",
                        "rgb(26, 203, 82) none repeat scroll 0% 0% / auto padding-box border-box"));
    }

    @Test
    public void rotateShape(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.shapesButton).click();

        $(flexibleToolPage.rectangle).dragAndDropTo($(flexibleToolPage.wrapper));

        int heightBefore = $(flexibleToolPage.shapeOnCanvas).getSize().height;
        int widthBefore = $(flexibleToolPage.shapeOnCanvas).getSize().width;

        $("div.canvas.landscape>div").click();
        $(flexibleToolPage.rotateButton).click();

        int heightAfter = $(flexibleToolPage.shapeOnCanvas).getSize().height;
        int widthAfter = $(flexibleToolPage.shapeOnCanvas).getSize().width;

        Assert.assertTrue(heightBefore == widthAfter && widthBefore == heightAfter);
    }
}
