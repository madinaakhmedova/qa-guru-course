package github;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class EnterpriseSolutionTestCase {

    @Test
    void openEnterpriseSolutionPage() {
        /*
        1. На главной странице GitHub выберите меню Solutions -> Enterprise с помощью команды hover для Solutions.
        Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
         */
        open("https://github.com");
        SelenideElement solutionsElement = $("header .header-menu-wrapper nav ul").
                find(byText("Solutions"));

        solutionsElement.hover();

        solutionsElement.ancestor("li").$(".HeaderMenu-dropdown.dropdown-menu ul").
                $(byText("Enterprise")).click();

        $("h1").shouldBe(text("Build like the best"));
    }
}
