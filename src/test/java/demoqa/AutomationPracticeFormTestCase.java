package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTestCase extends TestBase {

    @Test
    void fillFormTest() {
        String userFirstname = "Madina";
        String userSurname = "Akhmedova";
        String userEmail = "akhmedovamadina11@gmail.com";
        String userNumber = "9991112233";
        String gender = "Female";

        registrationPage.openPage();

        registrationPage.openPage()
                .setFirstName(userFirstname)
                .setLastName(userSurname)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(userNumber)
                .setBirthDate("06", "January", "1993");
        SelenideElement userForm = $("#userForm");

        userForm.parent().$("h5").shouldHave(text("Student Registration Form"));

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


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", text(userFirstname + " " + userSurname))
                .verifyResult("Student Email", text(userEmail))
                .verifyResult("Gender", text(gender))
                .verifyResult("Mobile", text(userNumber))
                .verifyResult("Date of Birth", text("06 January,1993"))
                .verifyResult("Hobbies", text("Sports"))
                .verifyResult("Subjects", text("Maths"))
                .verifyResult("Picture", text("test.png"))
                .verifyResult("Address", empty)
                .verifyResult("State and City", text("Uttar Pradesh Lucknow"))
        ;

    }
}
