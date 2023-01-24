package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameMethods {
    private WebDriver driver;

    public FrameMethods(WebDriver driver) {

        this.driver = driver;
    }

    public void SwitchFrame(String Value){

        driver.switchTo().frame(Value);
    }

    public void SwitchFrame(WebElement Element){

        driver.switchTo().frame(Element);
    }
    public void SwitchDefault(){
        driver.switchTo().defaultContent();
    }
}
