package Tests;

import HelpMethods.ElementMethods;
import Pages.IndexPage;
import Pages.RegisterPage;
import ShareData.ShareData;
import org.testng.annotations.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest extends ShareData {

    @Test
    public void MetodaTest () {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickSkipSignIn();


        String firstNameValue = "Daniela";
        String lastNameValue = "Solomon";
        String addressValue = "Str. Viena, nr. 2";
        String emailValue = "daniela.maria.solomon@gmail.com";
        String phoneNumberValue = "0740583105";
        String skillsValue = "Java";
        String yearValue = "1997";
        String ExpectedLanguage = "English";
        String countryValue = "Australia";
        String monthValue = "August";
        String dayValue = "15";
        String firstPasswordValue = "Daniela";
        String confirmPasswordValue = "Daniela";

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.registerProcess(firstNameValue, lastNameValue, addressValue, emailValue, phoneNumberValue,skillsValue,
                yearValue,ExpectedLanguage, countryValue,monthValue,dayValue,firstPasswordValue,confirmPasswordValue);

    }


}
