package Pages;

import HelpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage{

    //elemente specifice pentru IndexPage

    @FindBy(id = "btn1")
    private WebElement SignIn;

    @FindBy(id = "btn2")
    private WebElement SkipSignIn;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    //actiuni specifice pentru IndexPage

    public void clickSignIn(){
        elementMethods.ClickElement(SignIn);
    }

   public void clickSkipSignIn(){
       elementMethods.ClickElement(SkipSignIn);
   }
}
