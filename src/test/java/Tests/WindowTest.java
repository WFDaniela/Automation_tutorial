package Tests;

import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import HelpMethods.WindowMethods;
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
        WindowMethods windowMethods = new WindowMethods(getDriver());


        WebElement SkipRegister = getDriver().findElement(By.id("btn2"));
        elementMethods.ClickElement(SkipRegister);

        WebElement SwitchTo = getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));

        
        //Mergem cu mouse-ul pe un anumit element
        //Actions actions = new Actions(getDriver());
        //actions.moveToElement(SwitchTo).perform();
        elementMethods.MoveToElement(SwitchTo);

        WebElement WindowElement = getDriver().findElement(By.xpath("//a[text()='Windows']"));
        elementMethods.ClickElement(WindowElement);

       // getDriver().navigate().to("https://demo.automationtesting.in/Windows.html");
        pageMethods.NavigateToPage("https://demo.automationtesting.in/Windows.html");

        List<WebElement> WindowOptions = getDriver().findElements(By.cssSelector(".nav-stacked>li>a"));
        elementMethods.ClickElement(WindowOptions.get(0));
        WebElement TabButton = getDriver().findElement(By.cssSelector("#Tabbed>a>button"));
        elementMethods.ClickElement(TabButton);

        //Identificam multimea de tab-uri/windows

        List<String>Tabs = new ArrayList<>(getDriver().getWindowHandles());

        //Ne mutam cu focusul pe un tab specific
        windowMethods.moveSpecificTab(1);


        //Inchidem tab-ul curent
        windowMethods.closeCurrentTabWindow();
        windowMethods.moveSpecificTab(0);

        WindowOptions.get(1).click();
        WebElement WindowButton = getDriver().findElement(By.cssSelector("#Seperate>button"));
        elementMethods.ClickElement(WindowButton);



        //Ne mutam cu focusul pe un window specific

        windowMethods.moveSpecificTab(1);
        getDriver().close();
        windowMethods.moveSpecificTab(0);
        //driv der.close();

        WindowOptions.get(2).click();
        WebElement MultipleButton = getDriver().findElement(By.cssSelector("#Multiple>button"));
        elementMethods.ClickElement(MultipleButton);



        windowMethods.moveSpecificTab(2);
        windowMethods.closeCurrentTabWindow();
        windowMethods.moveSpecificTab(1);
        windowMethods.closeCurrentTabWindow();
        windowMethods.moveSpecificTab(0);




    }
}
