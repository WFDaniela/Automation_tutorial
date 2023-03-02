package ShareData;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ShareData {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    //Folosim adnotarea de @Before din Testng

    public void Setup(){
        String cicd = System.getProperty("ci_cd");
        ChromeOptions chromeOptions = new ChromeOptions();
        if (Boolean.parseBoolean(cicd)){
            chromeOptions.addArguments("--headless");

        }
         else{
            System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        }
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(chromeOptions);

        driver.get("https://demo.automationtesting.in/Index.html");

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    //folosim after

    public  void Clear(){
        //inchidem un browser
        driver.quit();
        //quit = inchide browserul cu oricate taburi deschise
        //close = inchide doar tabul curent
    }
}
