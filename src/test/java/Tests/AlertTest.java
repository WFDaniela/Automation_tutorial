package Tests;

import HelpMethods.AlertsMethods;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import Pages.AlertPage;
import Pages.IndexPage;
import Pages.RegisterPage;
import ShareData.ShareData;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AlertTest extends ShareData {

    @Test
    public void metodaTest() {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickSkipSignIn();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.goToAlert();

        AlertPage alertPage =new AlertPage(getDriver());
        alertPage.interactAlertAccept();
        alertPage.interactAlertDismiss();
        alertPage.interactAlertValue("test");




    }
}
