import commons.AppOperate;
import data.DriverData;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TmpTest {

    @Test(dataProvider = "driver", dataProviderClass = DriverData.class)
    public void a(AppiumDriver<?> driver) {
        AppOperate appOperate = new AppOperate(driver);
        WebElement shouye = appOperate.locateElement("//*[@text='首页']");
        appOperate.exactOp(shouye, AppOperate.Op.CLICK);

    }

    @Test(dataProvider = "driver", dataProviderClass = DriverData.class)
    public void driverQuit(AppiumDriver<?> driver){
        driver.quit();

    }
}
