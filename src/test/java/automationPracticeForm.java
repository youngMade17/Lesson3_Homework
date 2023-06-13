import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class automationPracticeForm {

    String UserName = "Mikhail";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";
        Configuration.pageLoadStrategy="eager";
        Configuration.holdBrowserOpen=true;
    }

    @Test
    void registrationForm() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove();"); //удаляем мешающий футер через jquery(панель разраба)

        $("[id=firstName]").setValue(UserName);
        $("[id=lastName]").setValue("Gundenkov");
        $("[id=userEmail]").setValue("pochta@mail.ru");

        //$(byText("Male")).click();
        $("#gender-radio-1").parent().click(); //другой вариант через родителя

        $("[id=userNumber]").setValue("9631117711");

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        //$(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__day--023").click();
        //$(".react-datepicker__day.react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click(); - выбирается одно из 10 чисел на календарной форме

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("B").pressEnter();
        $("#subjectsInput").setValue("C").pressEnter();

        $("#hobbiesWrapper") .$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("img/me.jpg");
        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/me.jpg"));
        //$("#uploadPicture").sendKeys("D:\\img\\me.jpg");

        $("#currentAddress").setValue("Street Pushkina, house Kolotushkina");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();

        $(".modal-content").shouldHave(appear);

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text(UserName), text("Gundenkov"), text("pochta@mail.ru"), text("Male"), text("9631117711"),
                text("23 January,1999"), text("Maths, Biology, Physics"), text("Sports"), text("\tme.jpg"), text("\tStreet Pushkina, house Kolotushkina"),
                text("NCR Noida"));

        $("#closeLargeModal").click();








    }

}
