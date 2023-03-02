package Tests;

import Pages.IndexPage;
import Pages.RegisterPage;
import Pages.WindowPage;

import ShareData.Hooks;
import org.testng.annotations.Test;

public class WindowTest extends Hooks {

    @Test
    public void MetodaTest() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickSkipSignIn();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.goTowindow();
        testReport.attachReport("pass", "Click on Sign-in button");

        WindowPage windowPage = new WindowPage(getDriver());
        windowPage.tabProcess();
        windowPage.windowProcess();
        windowPage.tabsProcess();
        testReport.attachReport("pass", "Window page");

    }
}
