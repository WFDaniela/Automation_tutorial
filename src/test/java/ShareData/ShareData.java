package ShareData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    //Folosim adnotarea de @Before din Testng
    @BeforeMethod
    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Index.html");

        //Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    //folosim after
    @AfterMethod
    public  void Clear(){
        //inchidem un browser
        driver.quit();
        //quit = inchide browserul cu oricate taburi deschise
        //close = inchide doar tabul curent
    }
}
