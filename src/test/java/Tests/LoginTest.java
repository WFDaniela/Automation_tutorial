package Tests;


import Objects.LoginObject;
import Pages.IndexPage;
import Pages.LoginPage;
import ShareData.Hooks;
import org.testng.annotations.Test;



public class LoginTest extends Hooks {
    @Test
    public void MetodaTest(){
        LoginObject loginObject = new LoginObject(TestData);

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickSignIn();
        testReport.attachReport("pass", "I click on Sign-in button");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginInvalid(loginObject );
        testReport.attachReport("pass", "I manage to validate invalid login");

    }

}
