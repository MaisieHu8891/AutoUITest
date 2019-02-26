import org.testng.annotations.AfterTest;

public class LastClear extends BaseTest{
    @AfterTest
    public void quitDriverAndExitThreads(){
        androidELog.stopLogcat();
        driver.quit();
    }
}
