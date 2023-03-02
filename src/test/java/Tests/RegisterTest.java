package Tests;

import Objects.RegisterObject;
import Pages.IndexPage;
import Pages.RegisterPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class RegisterTest extends Hooks {

    @Test
    public void MetodaTest () {
        RegisterObject registerObject= new RegisterObject(TestData);

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickSkipSignIn();
        testReport.attachReport("pass", "Click on Sign-in button");

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.registerProcess(registerObject);
        testReport.attachReport("pass", "Go to register page");

    }


}
