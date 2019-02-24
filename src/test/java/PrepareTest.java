import data.DriverData;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

public class PrepareTest extends BaseTest {
    @Test(dataProvider = "driver", dataProviderClass = DriverData.class)
    public void checkBlackWindows(AppiumDriver<?> driver){
        setPopUpsCheckThread(driver);
        getPopUpsCheckThread().start();

    }
    @Test
    public void androidLogcatStart(){
        setAndroidLogThread();
        getAndroidLogThread().start();
    }

}
