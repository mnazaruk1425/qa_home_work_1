package tests.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;


public class NewRegistrationFormWithRandomUtils {

    @Test
    void dataAppearsInOutRegForm(){
        String firstName = getRandomString(10),
               lastName = getRandomString(10),
               email = getRandomEmail(),
               gender = "Other",
               mobile = getRandomPhone(),
               dayOfBirth = "14",
               monthOfBirth = "February",
               yearOfBirth = "2021",
               subject1 = "Economics",
               subject2 = "English",
               hobby1 = "Sports",
               hobby2 = "Reading",
               hobby3 = "Music",
               picture = "1.png",
               currentAddress =getRandomMessage(30,100),
               state ="NCR",
               city = "Delhi";

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration form"));

        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").val(mobile);
        //set date
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $("#dateOfBirth").click();
       // $(".react-datepicker__day react-datepicker__day--002 " + dayOfBirth).click();
         //set subject
        $("#subjectsInput").val(subject1);
        $(".subjects-auto-complete__menu-list").$(byText(subject1)).click();
        $("#subjectsInput").val(subject2);
        $(".subjects-auto-complete__menu-list").$(byText(subject2)).click();
         //set hobbis
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/" + picture));
        $("#uploadPicture").uploadFromClasspath("img/" + picture);
         //set current address
        $("#currentAddress").val(currentAddress);
        //set state and city
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();
       $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));





    }
}
