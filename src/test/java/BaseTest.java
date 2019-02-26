import commons.AndroidELog;
//import commons.ResidentThreads;
import drivers.InitDriver;
import io.appium.java_client.AppiumDriver;

public class BaseTest {
    static AppiumDriver<?> driver;
    static AndroidELog androidELog;

    public BaseTest(){
        InitDriver initDriver = InitDriver.getInstance();
        driver = initDriver.thisDriver;
        androidELog = new AndroidELog();
    }


}
