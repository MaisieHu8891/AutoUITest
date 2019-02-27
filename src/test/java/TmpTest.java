import commons.AppOperate;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TmpTest extends BaseTest{

    @Test
    public void someTest(){
        AppOperate appOperate = new AppOperate(driver);

        WebElement shouye = appOperate.locateElement("//*[@text='首页']");

        appOperate.exactOp(shouye, AppOperate.Op.CLICK);
    }
}
