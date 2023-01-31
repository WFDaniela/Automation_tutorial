package Tests;


import HelpMethods.ElementMethods;
import Pages.IndexPage;
import Pages.LoginPage;
import ShareData.ShareData;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginTest extends ShareData {
    @Test
   public void MetodaTest(){

         IndexPage indexPage = new IndexPage(getDriver());
         indexPage.clickSignIn();

         LoginPage loginPage = new LoginPage(getDriver());
         loginPage.LoginInvalid("daniela@gmail.com", "Parola","Invalid User Name or PassWord" );

    }

}
