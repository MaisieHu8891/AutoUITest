import data.DriverData;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

public class LastClear extends BaseTest {

    @Test(dataProvider = "driver", dataProviderClass = DriverData.class)
    public void stopCheckBlackWindows(AppiumDriver<?> driver){
        getPopUpsCheckThread().interrupt();

    }
    @Test
    public void androidLogcatStop(){
        getAndroidLogThread().interrupt();
    }

}
