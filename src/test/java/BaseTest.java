import drivers.InitDriver;
import io.appium.java_client.AppiumDriver;

public class BaseTest {
    AppiumDriver driver;
    Thread androidLogThread;

    public AppiumDriver getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver driver) {
        this.driver = driver;
    }

    public Thread getAndroidLogThread() {
        return androidLogThread;
    }

    public void setAndroidLogThread(Thread androidLogThread) {
        this.androidLogThread = androidLogThread;
    }
    //   InitDriver.getInstance();
//   AppiumDriver driver = InitDriver.thisDriver;

}
