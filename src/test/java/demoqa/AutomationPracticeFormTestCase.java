package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTestCase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String userFirstname = "Madina";
        String userSurname = "Akhmedova";
        String userEmail = "akhmedovamadina11@gmail.com";
        String userNumber = "9991112233";

        open("/automation-practice-form");
        SelenideElement userForm = $("#userForm");

        userForm.parent().$("h5").shouldHave(text("Student Registration Form"));

        userForm.$("#firstName").setValue(userFirstname);
        userForm.$("#lastName").setValue(userSurname);
        userForm.$("#userEmail").setValue(userEmail);
        userForm.$("#gender-radio-2").parent().$("label").shouldBe(text("Female"));
        userForm.$("#gender-radio-2").parent().$("label").click();
        userForm.$("#userNumber").setValue(userNumber);
        userForm.$("#hobbies-checkbox-1").parent().$("label").shouldBe(text("Sports"));
        userForm.$("#hobbies-checkbox-1").parent().$("label").click();
        userForm.$("#uploadPicture").uploadFromClasspath("test.png");

        executeJavaScript("$('#adplus-anchor').remove();$('footer').remove();");

        actions().moveToElement(userForm.$("#stateCity-wrapper").sibling(0)).perform();
        $("#state").click();
        $("#react-select-3-option-1").shouldBe(text("Uttar Pradesh")).click();
        $("#city").click();
        $("#react-select-4-option-1").shouldBe(text("Lucknow")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January"); // select from months dropdown
        $(".react-datepicker__year-select").selectOption("1993"); // select from years dropdown
        $(".react-datepicker__month").$$(".react-datepicker__week")
                .get(1).$$(".react-datepicker__day").findBy(text("6")).click(); // select the day

        $("#subjectsInput").setValue("m");
        $("#react-select-2-option-0").shouldBe(visible).shouldBe(text("Maths")).click();
        $("#subjectsInput").pressEnter();


        SelenideElement modal = $("[role=dialog]");
        modal.shouldBe(visible);

        SelenideElement tableTbody = modal.$("table tbody");
        tableTbody.$("tr", 0).$("td",0).shouldBe(text("Student Name"));
        tableTbody.$("tr", 0).$("td",1).shouldBe(text(userFirstname + " " + userSurname));
        tableTbody.$("tr", 1).$("td",0).shouldBe(text("Student Email"));
        tableTbody.$("tr", 1).$("td",1).shouldBe(text(userEmail));
        tableTbody.$("tr", 2).$("td",0).shouldBe(text("Gender"));
        tableTbody.$("tr", 2).$("td",1).shouldBe(text("Female"));
        tableTbody.$("tr", 3).$("td",0).shouldBe(text("Mobile"));
        tableTbody.$("tr", 3).$("td",1).shouldBe(text(userNumber));
        tableTbody.$("tr", 4).$("td",0).shouldBe(text("Date of Birth"));
        tableTbody.$("tr", 4).$("td",1).shouldBe(text("06 January,1993"));
        tableTbody.$("tr", 5).$("td",0).shouldBe(text("Subjects"));
        tableTbody.$("tr", 5).$("td",1).shouldBe(text("Maths"));
        tableTbody.$("tr", 6).$("td",0).shouldBe(text("Hobbies"));
        tableTbody.$("tr", 6).$("td",1).shouldBe(text("Sports"));
        tableTbody.$("tr", 7).$("td",0).shouldBe(text("Picture"));
        tableTbody.$("tr", 7).$("td",1).shouldBe(text("test.png"));
        tableTbody.$("tr", 8).$("td",0).shouldBe(text("Address"));
        tableTbody.$("tr", 8).$("td",1).shouldBe(empty);
        tableTbody.$("tr", 9).$("td",0).shouldBe(text("State and City"));
        tableTbody.$("tr", 9).$("td",1).shouldBe(text("Uttar Pradesh Lucknow"));


    }
}
