import data.DriverData;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

public class LastClear {

    @Test(dataProvider = "driver", dataProviderClass = DriverData.class)
    public void driverQuit(AppiumDriver<?> driver) {
        driver.quit();
    }

    @Test
    public void androidLogRun(){

    }
}
