import commons.ResidentThreads;
import drivers.InitDriver;
import io.appium.java_client.AppiumDriver;

public class BaseTest {
    static AppiumDriver<?> driver;
    static Thread androidLogThread;
    static Thread popUpsCheckThread;

    public BaseTest(){
        InitDriver initDriver = InitDriver.getInstance();
        driver = initDriver.thisDriver;
        ResidentThreads residentThreads = ResidentThreads.getInstance(driver);
        androidLogThread  = residentThreads.androidLogThread;
        popUpsCheckThread  = residentThreads.popUpsCheckThread;
    }


}
