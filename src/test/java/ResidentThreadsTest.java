import commons.PopUpsCheck;
import commons.ResidentThreads;
import data.DriverData;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

public class ResidentThreadsTest {
    private static Thread androidLogThread;
    private static Thread popUpsCheckThread;


    @Test(dataProvider = "driver", dataProviderClass = DriverData.class)
    public void residentThreads(AppiumDriver<?> driver) {
        ResidentThreads.getInstance(driver);
        androidLogThread  = ResidentThreads.androidLogThread;
        popUpsCheckThread  = ResidentThreads.popUpsCheckThread;
    }

    @Test
    public void startCheckBlackWindows(){
        popUpsCheckThread.start();

    }
    @Test
    public void androidLogcatStart(){
        androidLogThread.start();
    }


    @Test
    public void stopCheckBlackWindows(){
        PopUpsCheck.isCancel = true;
        popUpsCheckThread.interrupt();


    }
    @Test
    public void androidLogcatStop(){
        androidLogThread.interrupt();
    }

}
