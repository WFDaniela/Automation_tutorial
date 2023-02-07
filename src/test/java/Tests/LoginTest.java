package Tests;


import HelpMethods.ElementMethods;
import Objects.LoginObject;
import Pages.IndexPage;
import Pages.LoginPage;

import ShareData.Hooks;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginTest extends Hooks {
    @Test
    public void MetodaTest(){
        LoginObject loginObject = new LoginObject(TestData);



         IndexPage indexPage = new IndexPage(getDriver());
         indexPage.clickSignIn();

         LoginPage loginPage = new LoginPage(getDriver());
         loginPage.LoginInvalid(loginObject );

    }

}
