package ShareData;

import ExtentUtility.ExtentReport;
import InputFile.PropertiesUtility;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hooks extends ShareData{

    public HashMap<String, String> TestData;
    private String TestName;

    //Implementam o logica de generare a unui singur raport pentru n teste

    public static ExtentReport extendReportUtility = new ExtentReport();
    public static List<Log> LogContext = new ArrayList<>();
    public ExtentReport testReport;


    @BeforeMethod
    public void prepareEnvironment(){
        Setup();
        TestName = this.getClass().getSimpleName();
        PropertiesUtility propertiesUtility = new PropertiesUtility(TestName);
        TestData = propertiesUtility.GetAllData();
        testReport = new ExtentReport(TestName);

    }
    @AfterMethod
    public void clearEnvironment(ITestResult Result){

        //trebuie sa tratam cazul cand cade un test

        if (Result.getStatus()==ITestResult.FAILURE){
            testReport.attachReport("fail", Result.getThrowable().getMessage(), getDriver(), TestName);

        }


        //facem o logica care sa genereze raportul inainte sa inchida driver ul
        testReport.attachReport("info", "---finish " + TestName + "test---");
        synchronized (extendReportUtility){
            ExtentTest currentTest = extendReportUtility.getExtent().createTest("" + TestName + " report");
            LogContext.addAll(testReport.getTestReport().getModel().getLogs());
            for (Log log:LogContext){
                currentTest.getModel().getLogs().add(log);
                if (log.getStatus().equals(Status.FAIL)){
                    currentTest.getModel().setStatus(Status.FAIL);
                }
            }
            extendReportUtility.getExtent().flush();
            LogContext.clear();

        }
        Clear();


    }
}
