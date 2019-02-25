import commons.PopUpsCheck;
import commons.ResidentThreads;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StartResidentThreads extends BaseTest{

    @BeforeTest
    public void residentThreads() {
        popUpsCheckThread.start();
        androidLogThread.start();
    }
}
