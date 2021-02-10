package tests.demoqa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static utils.RandomUtils.*;


public class NewRegistrationFormWithFakerTests {

    @Test
    void dataAppearsInOutRegForm(){
        Faker faker = new Faker();

        String firstName = faker.name().firstName(),
                lastName =  faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = "Other",
                mobile = faker.phoneNumber().subscriberNumber(10),
                dayOfBirth = "14",
                monthOfBirth = "February",
                yearOfBirth = "2021",
                subject1 = "Economics",
                subject2 = "English",
                hobby1 = "Sports",
                hobby2 = "Reading",
                hobby3 = "Music",
                picture = "1.png",
                currentAddress=faker.address().fullAddress(),
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

        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
      //  $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject1 + ", " + subject2));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1 + ", " + hobby2 + ", " + hobby3));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }




}

