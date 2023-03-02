package Tests;

import Objects.FrameObject;
import Pages.FramePage;
import Pages.IndexPage;
import Pages.RegisterPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class FramesTest extends Hooks {
    @Test
    public void MetodaTest() {

        FrameObject frameObject = new FrameObject(TestData);

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickSkipSignIn();
        testReport.attachReport("pass", "I click on Sign-in button");

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.goToFrame();
        testReport.attachReport("pass", "Go to frame");


        FramePage framePage = new FramePage(getDriver());
        framePage.singleFrame(frameObject);
        framePage.multipleFrame(frameObject);
        testReport.attachReport("pass", "Manage multiple frames");


    }

    


}
