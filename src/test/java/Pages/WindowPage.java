package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WindowPage extends BasePage {
    public WindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".nav-stacked>li>a")
    private List<WebElement> WindowOptions;

    @FindBy(css = "#Tabbed>a>button")
    private WebElement TabButton;

    @FindBy(css = "#Seperate>button")
    private WebElement WindowButton;

    @FindBy(css = "#Multiple>button")
    private WebElement MultipleButton;

    public void tabProcess() {
        elementMethods.ClickElement(WindowOptions.get(0));
        elementMethods.ClickElement(TabButton);
        windowMethods.moveSpecificTab(1);
        windowMethods.closeCurrentTabWindow();
        windowMethods.moveSpecificTab(0);
    }

    public void windowProcess() {
        WindowOptions.get(1).click();
        elementMethods.ClickElement(WindowButton);
        windowMethods.moveSpecificTab(1);
        driver.close();
        windowMethods.moveSpecificTab(0);

    }
    public void tabsProcess(){
        WindowOptions.get(2).click();
        elementMethods.ClickElement(MultipleButton);
        windowMethods.moveSpecificTab(2);
        windowMethods.closeCurrentTabWindow();
        windowMethods.moveSpecificTab(1);
        windowMethods.closeCurrentTabWindow();
        windowMethods.moveSpecificTab(0);

    }
}
