import commons.PopUpsCheck;
import org.testng.annotations.AfterTest;

public class LastClear extends BaseTest{
    @AfterTest
    public void quitDriverAndExitThreads() {
        driver.quit();
        PopUpsCheck.isCancel = true;
        popUpsCheckThread.interrupt();
        androidLogThread.interrupt();
    }
}
