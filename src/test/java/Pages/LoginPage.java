package Pages;

import HelpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;

public class LoginPage extends BasePage {

    @FindBy(css="input[placeholder='E mail']")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement parola;

    @FindBy(id = "enterbtn")
    private WebElement Enter;

    @FindBy(id = "errormsg")
    private WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void LoginInvalid(String emailValue, String parolaValue, String expectedError){

        elementMethods.FillElement(email, emailValue);

        elementMethods.FillElement(parola, parolaValue);

        elementMethods.ClickElement(Enter);

        elementMethods.ValidateElementText(error, expectedError);
    }


}
