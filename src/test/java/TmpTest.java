import commons.AppOperate;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TmpTest extends BaseTest{

    @Test
    public void someTest() throws InterruptedException {
        AppOperate appOperate = new AppOperate(driver);
        WebElement shouye = appOperate.locateElement("//*[@text='首页']");
        appOperate.exactOp(shouye, AppOperate.Op.CLICK);
        Thread.sleep(60000);

    }
}
