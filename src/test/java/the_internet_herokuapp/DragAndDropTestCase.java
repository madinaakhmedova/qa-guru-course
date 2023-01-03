package the_internet_herokuapp;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTestCase {

    @Test
    void openEnterpriseSolutionPage() {
        /*
        2. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
         - Откройте https://the-internet.herokuapp.com/drag_and_drop
         - Перенесите прямоугольник А на место В
         - Проверьте, что прямоугольники действительно поменялись
         - В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
         */
        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement blockA = $("#columns div", 0);
        SelenideElement blockB = $("#columns div", 1);
        blockA.shouldHave(text("A"));

//        Че-то не сработал actions().moveToElement(blockA)
//        actions().clickAndHold(blockA).moveByOffset(215, 0).release().perform();
//        actions().clickAndHold(blockA).moveToElement(blockB).release().build().perform();
        blockA.dragAndDropTo(blockB);

        $("#columns div").shouldHave(text("B"));
    }
}
