package data;

import commons.InitDriver;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.DataProvider;

public class DriverData {
    @DataProvider(name="driver")
    public Object[][] driverData() {
        InitDriver.getInstance();
        AppiumDriver driver = InitDriver.thisDriver;
        return new Object[][]{
                {driver}
        };
    }

}
