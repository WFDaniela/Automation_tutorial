package Tests;

import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import ShareData.ShareData;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends ShareData {

    @Test
    public void MetodaTest() {
        ElementMethods elementMethods = new ElementMethods(getDriver());
        PageMethods pageMethods = new PageMethods(getDriver());


        WebElement SkipRegister = getDriver().findElement(By.id("btn2"));
        elementMethods.ClickElement(SkipRegister);

        WebElement SwitchTo = getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));
        
        //Mergem cu mouse-ul pe un anumit element
        Actions actions = new Actions(getDriver());
        actions.moveToElement(SwitchTo).perform();

        WebElement WindowElement = getDriver().findElement(By.xpath("//a[text()='Windows']"));
        elementMethods.ClickElement(WindowElement);

        getDriver().navigate().to("https://demo.automationtesting.in/Windows.html");

        List<WebElement> WindowOptions = getDriver().findElements(By.cssSelector(".nav-stacked>li>a"));
        WindowOptions.get(0).click();
        WebElement TabButton = getDriver().findElement(By.cssSelector("#Tabbed>a>button"));
        elementMethods.ClickElement(TabButton);

        //Identificam multimea de tab-uri/windows

        List<String>Tabs = new ArrayList<>(getDriver().getWindowHandles());

        //Ne mutam cu focusul pe un tab specific

        getDriver().switchTo().window(Tabs.get(1));

        //Inchidem tab-ul curent
        getDriver().close();
        getDriver().switchTo().window(Tabs.get(0));

        WindowOptions.get(1).click();
        WebElement WindowButton = getDriver().findElement(By.cssSelector("#Seperate>button"));
        elementMethods.ClickElement(WindowButton);

        List<String>Windows = new ArrayList<>(getDriver().getWindowHandles());

        //Ne mutam cu focusul pe un window specific

        getDriver().switchTo().window(Windows.get(1));
        getDriver().close();
        getDriver().switchTo().window(Windows.get(0));
        //driv der.close();

        WindowOptions.get(2).click();
        WebElement MultipleButton = getDriver().findElement(By.cssSelector("#Multiple>button"));
        MultipleButton.click();
        List<String>Multiple = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(Multiple.get(2));
        getDriver().close();
        getDriver().switchTo().window(Multiple.get(1));
        getDriver().close();
        getDriver().switchTo().window(Multiple.get(0));




    }
}
