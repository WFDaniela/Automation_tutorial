package HelpMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsMethods {
    private WebDriver driver;

    public AlertsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void AcceptAlert(){
        WaitAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void DismissAlert(){
        WaitAlert();
        Alert dismiss = driver.switchTo().alert();
        dismiss.accept();
    }
    public void FillAlert(String Value, Boolean MakeDecision){
       WaitAlert();
       Alert alert = driver.switchTo().alert();
       alert.sendKeys(Value);
       if(MakeDecision){
           alert.accept();
       }
       else {
           alert.dismiss();
       }
    }

    private void WaitAlert(){
        WebDriverWait WaitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        WaitExplicit.until(ExpectedConditions.alertIsPresent());
    }
}
