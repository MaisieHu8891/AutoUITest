import commons.LoggerConf;
import commons.PopUpsCheck;
import org.testng.annotations.AfterTest;

public class LastClear extends BaseTest{
    @AfterTest
    public void quitDriverAndExitThreads() throws InterruptedException {
        PopUpsCheck.isCancel = true;
        popUpsCheckThread.interrupt();
        androidLogThread.interrupt();
        LoggerConf.logobject.info("Stop PopUpsCheckThread "+popUpsCheckThread.getName());
        LoggerConf.logobject.info("Stop AndroidLogThread "+androidLogThread.getName());
        Thread.sleep(5000);
        driver.quit();
    }
}
