import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class automationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";
        Configuration.pageLoadStrategy="eager";
    }

    @Test
    void registrationForm() {
        open("/automation-practice-form");

        $("[id=firstName]").setValue("Mikhail");
        $("[id=lastName]").setValue("Gundenkov");
        $("[id=userEmail]").setValue("pochta@mail.ru");

        $(byText("Male")).click();

        $("[id=userNumber]").setValue("9631117711");

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__day--023").click();
        $("#subjectsInput").setValue("Some subjects");

        $(byText("Sports")).click();

        $("#uploadPicture").sendKeys("D:\\img\\me.jpg");

        $("#currentAddress").setValue("Street Pushkina, house Kolotushkina");

        $("#state").click();
        $(byName("Haryana")).click();

        $("#city").click();






    }

}
