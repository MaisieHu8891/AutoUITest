import Commons.AppOperate;
import Data.DriverData;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

public class TmpTest {
    @Test(dataProvider = "driver", dataProviderClass = DriverData.class)
    public void t(AppiumDriver<?> driver) {
        AppOperate appOperate = new AppOperate(driver);
        appOperate.exactOp("//*[@text='首页']", AppOperate.Op.CLICK);

    }
}
