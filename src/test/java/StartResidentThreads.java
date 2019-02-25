import commons.LoggerConf;
import commons.PopUpsCheck;
import commons.ResidentThreads;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StartResidentThreads extends BaseTest{

    @BeforeTest
    public void residentThreads() throws InterruptedException {
        popUpsCheckThread.start();
        androidLogThread.start();
        LoggerConf.logobject.info("Start PopUpsCheckThread "+popUpsCheckThread.getName());
        LoggerConf.logobject.info("Start AndroidLogThread "+androidLogThread.getName());
        Thread.sleep(20000);
    }
}
