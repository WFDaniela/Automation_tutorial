package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css= ".nav-tabs>li>a")
    private List<WebElement> FrameOptions;

    @FindBy(css = "input[type='text']")
    private WebElement FirstFrame;

    @FindBy(css = "input[type='text']")
    private WebElement SecondFrame;

    public void singleFrame(String value){

        elementMethods.ClickElement(FrameOptions.get(0));

        frameMethods.SwitchFrame("singleframe");


        elementMethods.FillElement(FirstFrame, value);

        frameMethods.SwitchDefault();//te scoate din orice frame este si te aduce pe body-ul principal
    }
    public void multipleFrame(String value){
        elementMethods.ClickElement(FrameOptions.get(1));

        frameMethods.SwitchFrame(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        frameMethods.SwitchFrame(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));

        elementMethods.FillElement(SecondFrame, value);
        frameMethods.SwitchDefault();
    }

}