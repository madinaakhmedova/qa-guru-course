package demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class AutomationPracticeFormTestCase extends TestBase {

    @Test
    void fillFormTest() {
        String userFirstname = "Madina";
        String userSurname = "Akhmedova";
        String userEmail = "akhmedovamadina11@gmail.com";
        String userNumber = "9991112233";
        String gender = "Female";
        String dayOfBirth = "06";
        String monthOfBirth = "January";
        String yearOfBirth = "1993";
        String hobby = "Sports";
        String imagePath = "test.png";
        String state = "NCR";
        String city = "Delhi";
        String subject = "Maths";

        registrationPage.openPage()
                .checkFormTitle("Student Registration Form")
                .setFirstName(userFirstname)
                .setLastName(userSurname)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhone(userNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setHobby(hobby)
                .setState(state)
                .setCity(city)
                .setPicture(imagePath)
                .setSubject(subject)
                .submitForm()
        ;


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", text(userFirstname + " " + userSurname))
                .verifyResult("Student Email", text(userEmail))
                .verifyResult("Gender", text(gender))
                .verifyResult("Mobile", text(userNumber))
                .verifyResult("Date of Birth", text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth))
                .verifyResult("Hobbies", text(hobby))
                .verifyResult("Subjects", text(subject))
                .verifyResult("Picture", text(imagePath))
                .verifyResult("Address", empty)
                .verifyResult("State and City", text(state + " " + city))
        ;
    }
}
