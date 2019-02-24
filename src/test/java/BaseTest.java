
import commons.PopUpsCheck;
import drivers.AndroidELog;
import io.appium.java_client.AppiumDriver;

public class BaseTest {
    private Thread androidLogThread;
    private Thread popUpsCheckThread;


    public Thread getAndroidLogThread() {
        return androidLogThread;
    }

    public void setAndroidLogThread() {
        AndroidELog androidELog = new AndroidELog();
        this.androidLogThread = new Thread(androidELog);
    }

    public Thread getPopUpsCheckThread() {
        return popUpsCheckThread;
    }

    public void setPopUpsCheckThread(AppiumDriver driver) {
        PopUpsCheck popUpsCheck = new PopUpsCheck(driver);
        this.popUpsCheckThread = new Thread(popUpsCheck);
    }


}
