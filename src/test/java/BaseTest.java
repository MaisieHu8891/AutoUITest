import commons.ResidentThreads;
import drivers.InitDriver;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    static AppiumDriver<?> driver;
    static Thread androidLogThread;
    static Thread popUpsCheckThread;
    @BeforeTest
    public void setupDrvAndStartResThreads() {
        InitDriver.getInstance();
        driver = InitDriver.thisDriver;
        ResidentThreads.getInstance(driver);
        androidLogThread  = ResidentThreads.androidLogThread;
        popUpsCheckThread  = ResidentThreads.popUpsCheckThread;
    }


}
