package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class NewRegistrationForm {

    @Test
    void dataAppearsInOutRegForm(){
        String firstName = "Oleg",
               lastName = "Ivanov",
               email = "oliva@ru.com",
               gender = "Other",
               mobile = "2254963154",
               dayOfBirth = "10",
               monthOfBirth = "April",
               yearOfBirth = "1974",
               subject1 = "Economics",
               subject2 = "English",
               hobby1 = "Sports",
               hobby2 = "Reading",
               hobby3 = "Music",
               picture = "1.png",
               currentAddres ="Montgomery 215",
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
        $("#currentAddress").val(currentAddres);
        //set state and city
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();
       $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));





    }
}
