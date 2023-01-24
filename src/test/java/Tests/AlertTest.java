package Tests;

import HelpMethods.AlertsMethods;
import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
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

        ElementMethods elementMethods = new ElementMethods(getDriver());
        PageMethods pageMethods = new PageMethods(getDriver());
        AlertsMethods alertMethods = new AlertsMethods(getDriver());

        WebElement SkipSignIn = getDriver().findElement(By.id("btn2"));
        elementMethods.ClickElement(SkipSignIn);

        WebElement SwitchTo =getDriver().findElement(By.xpath("//a[text()='SwitchTo']"));
        //Mergem cu mouse-ul pe un anumit element
        elementMethods.MoveToElement(SwitchTo);

        WebElement AlertElement = getDriver().findElement(By.xpath("//a[text()='Alerts']"));
        elementMethods.ClickElement(AlertElement);

        //Navigam catre un url

        pageMethods.NavigateToPage("https://demo.automationtesting.in/Alerts.html");

        List<WebElement> AlertOptions = getDriver().findElements(By.cssSelector(".nav-stacked>li>a"));
        elementMethods.ClickElement(AlertOptions.get(0));

        WebElement AlertOK = getDriver().findElement(By.cssSelector("#OKTab>button"));
        elementMethods.ClickElement(AlertOK);

        //Interactionam cu o alerta

        alertMethods.AcceptAlert();

        elementMethods.ClickElement(AlertOptions.get(1));

        WebElement AlertOkCancel = getDriver().findElement(By.cssSelector("#CancelTab>button"));
        elementMethods.ClickElement(AlertOkCancel);

        alertMethods.DismissAlert();


        elementMethods.ClickElement(AlertOptions.get(2));

        WebElement AlertText =getDriver().findElement(By.cssSelector("#Textbox>button"));
        elementMethods.ClickElement(AlertText);

        alertMethods.FillAlert("test", true);


    }
}
