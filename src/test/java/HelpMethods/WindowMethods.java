package HelpMethods;

import org.openqa.selenium.WebDriver;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class WindowMethods {
   private WebDriver driver;

    public WindowMethods(WebDriver driver) {
        this.driver = driver;

            }
    public void moveSpecificTab(Integer index){
        List<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(index));
    }

    public void closeCurrentTabWindow(){
        driver.close();
    }
}
