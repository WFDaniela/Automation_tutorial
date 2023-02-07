package ShareData;

import InputFile.PropertiesUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Properties;

public class Hooks extends ShareData{

    public HashMap<String, String> TestData;
    private String TestName;

    @BeforeMethod
    public void prepareEnvironment(){
        Setup();
        TestName = this.getClass().getSimpleName();
        PropertiesUtility propertiesUtility = new PropertiesUtility(TestName);
        TestData = propertiesUtility.GetAllData();


    }
    @AfterMethod
    public void clearEnvironment(){
        Clear();

    }
}
