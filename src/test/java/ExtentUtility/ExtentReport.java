package ExtentUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ExtentReport {

    private ExtentSparkReporter htmlReporter;
    private ExtentReports extent;
    private ExtentTest testReport;
    private final String pathToProject = System.getProperty("user.dir") + "/target/report/";




    public ExtentReport(String reportName){
        //trebuie sa facem un folder
         CreateDirectory();
        //trebuie sa curat vechile fisiere
         DeleteFiles();
        //trebuie sa fac raportul
        CreateReport(reportName);

    }

//Suport ptr executia in paralel
    public ExtentReport(){
        //trebuie sa facem un folder
        CreateDirectory();
        //trebuie sa curat vechile fisiere
        DeleteFiles();
        //trebuie sa fac raportul
        CreateReport();

    }

    public void CreateDirectory(){
        File Directory = new File(pathToProject);
        if (!Directory.exists()){
            Directory.mkdirs();
        }
    }

    public void DeleteFiles(){
        File Directory = new File(pathToProject);

        //trebuie sa iau toate fisierele din folder
        File[] ListFiles = Directory.listFiles();
        for (Integer index = 0;index< ListFiles.length; index++){
            ListFiles[index].delete();

        }
    }

    public void CreateReport(String reportName){
        htmlReporter = new ExtentSparkReporter("target/report/"+reportName+".html");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        testReport = extent.createTest(""+reportName+"- report");
        attachReport("info", "---Start" + reportName + "test---");


    }
    public void CreateReport(){
        htmlReporter = new ExtentSparkReporter("target/report/Report.html");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }

    //Implementam o logica care sa defineasca comportamentul raportului

    public void attachReport(String entryType, String message){
        if (entryType.equals("info")){
            testReport.log(Status.INFO, message);
        }
        if (entryType.equals("pass")){
            testReport.log(Status.PASS, message);
        }

    }
    //implementam o logica care sa faca un screenshot

    public String getScreenshot(WebDriver driver, String reportName){
        String path = pathToProject +reportName+ ".png";
        byte[]imageBytes;

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(path));
            imageBytes = IOUtils.toByteArray(Files.newInputStream(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(imageBytes);
    }
    public void attachReport(String entryType, String message,WebDriver driver, String reportName){

        if (entryType.equals("fail")){
            testReport.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver, reportName)).build());

        }


    }



    public ExtentReports getExtent() {
        return extent;
    }

    public ExtentTest getTestReport() {
        return testReport;
    }
}
