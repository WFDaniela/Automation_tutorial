package Tests;

import Objects.AlertObject;
import Pages.AlertPage;
import Pages.IndexPage;
import Pages.RegisterPage;

import ShareData.Hooks;
import org.testng.annotations.Test;

public class AlertTest extends Hooks {

    @Test
    public void metodaTest() {

        AlertObject alertObject = new AlertObject(TestData);


        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickSkipSignIn();
        testReport.attachReport("pass", "Click on Sign-in button");

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.goToAlert();
        testReport.attachReport("pass", "Go to alert");

        AlertPage alertPage =new AlertPage(getDriver());
        alertPage.interactAlertAccept();
        alertPage.interactAlertDismiss();
        alertPage.interactAlertValue(alertObject);
        testReport.attachReport("pass", "Manage multiple alerts type");

    }
}
