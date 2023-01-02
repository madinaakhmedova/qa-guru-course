package github;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.conditions.ExactText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSoftAssertionsExampleTestCase {

    @Test
    void junitCodeExampleExists() {
        // 1. открыть страницу репозитория селенида https://github.com/selenide/selenide
        // 2. перейдите в раздел Wiki проекта https://github.com/selenide/selenide/wiki/
        // 3. Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        // 4. Откройте страницу SoftAssertions https://github.com/selenide/selenide/wiki/SoftAssertions
        // 5. проверьте что внутри есть пример кода для JUnit5 https://github.com/selenide/selenide/wiki/SoftAssertions#3-using-junit5-extend-test-class

        open("https://github.com/selenide/selenide");
//        SelenideElement navUl = $("nav[data-pjax='#js-repo-pjax-container'] ul a"); // не сработало
//        $("[id=wiki-tab]").click(); // easy way
//        // collection way
        ElementsCollection ulAs = $$(".UnderlineNav-body a");
        ExactText wiki = new ExactText("Wiki");
        ulAs.find(wiki).click();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions.
        // С помощью поиска
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        // Перейти на страницу
        $(byText("Soft assertions")).click();

        $("div.markdown-body").shouldHave(text(" Using JUnit5 extend test class:"));
    }
}
