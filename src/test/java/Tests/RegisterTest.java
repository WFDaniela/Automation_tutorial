package Tests;

import HelpMethods.ElementMethods;
import ShareData.ShareData;
import org.testng.annotations.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest extends ShareData {

    @Test
    public void MetodaTest () {

        ElementMethods elementMethods = new ElementMethods(getDriver());

        WebElement SkipSignIn = getDriver().findElement(By.id("btn2"));
        elementMethods.ClickElement(SkipSignIn);

        WebElement FirstName = getDriver().findElement(By.cssSelector("input[placeholder='First Name']"));
        String firstNameValue = "Daniela";
        elementMethods.FillElement(FirstName,firstNameValue);

        WebElement LastName = getDriver().findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Solomon";
        elementMethods.FillElement(LastName, lastNameValue);

        WebElement Address = getDriver().findElement(By.cssSelector("textarea[ng-model='Adress']"));
        String addressValue = "Str. Viena, nr. 2";
        elementMethods.FillElement(Address, addressValue);

        WebElement Email = getDriver().findElement(By.cssSelector("input[ng-model='EmailAdress']"));
        String emailValue = "daniela.maria.solomon@gmail.com";
        elementMethods.FillElement(Email,emailValue);

        WebElement Phone = getDriver().findElement(By.xpath("//input[@ng-model='Phone']"));
        String phoneNumberValue = "0740583105";
        elementMethods.FillElement(Phone, phoneNumberValue);

        WebElement Gen = getDriver().findElement(By.xpath("//input[@value='FeMale']"));
        elementMethods.ClickElement(Gen);

        WebElement Hobby = getDriver().findElement(By.id("checkbox2"));
        elementMethods.ClickElement(Hobby);



        //Interactionam cu un dropdown clasic

        WebElement Skills = getDriver().findElement(By.id("Skills"));
        elementMethods.SelectElementText(Skills,"Java");

        WebElement Year = getDriver().findElement(By.id("yearbox"));
        elementMethods.SelectElementValue(Year, "1997");

        elementMethods.ScrollByPixel(0,300);


        WebElement Language = getDriver().findElement(By.id("msdd"));
        elementMethods.ClickElement(Language);

        //Interactionam cu o multime de elemente;

        List<WebElement> LanguageOptions = getDriver().findElements(By.cssSelector(".ui-autocomplete>li>a"));
        String ExpectedLanguage = "English";
        for (Integer index = 0; index < LanguageOptions.size(); index ++){
            if (LanguageOptions.get(index).getText().equals(ExpectedLanguage)){
                elementMethods.ClickElement(LanguageOptions.get(index));

            }

        }

        elementMethods.ClickElement(Gen);



        WebElement SelectCountry = getDriver().findElement(By.cssSelector(".select2-selection"));
        elementMethods.ClickElement(SelectCountry);
        WebElement SelectCountryInput = getDriver().findElement(By.className("select2-search__field"));
        elementMethods.FillElement(SelectCountryInput, "Australia");

        WebElement Month = getDriver().findElement(By.cssSelector("select[placeholder='Month']"));
        elementMethods.SelectElementText(Month, "August");

        WebElement Day = getDriver().findElement(By.id("daybox"));
        elementMethods.SelectElementValue(Day, "15");

        WebElement FirstPassword = getDriver().findElement(By.id("firstpassword"));
        String firstPasswordValue = "Daniela";
        elementMethods.FillElement(FirstPassword, firstPasswordValue);

        WebElement ConfirmPassword = getDriver().findElement(By.id("secondpassword"));
        String confirmPasswordValue = "Daniela";
        elementMethods.FillElement(ConfirmPassword,confirmPasswordValue);

        WebElement Submit = getDriver().findElement(By.id("submitbtn"));
        elementMethods.ClickElement(Submit);

    }

}
