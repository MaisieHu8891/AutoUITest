import org.testng.annotations.AfterTest;

public class LastClear extends BaseTest{
    @AfterTest(alwaysRun = true)
    public void quitDriverAndExitThreads(){
        androidELog.stopLogcat();
        driver.quit();
    }
}
