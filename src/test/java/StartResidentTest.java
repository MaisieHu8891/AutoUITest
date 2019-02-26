import org.testng.annotations.BeforeTest;


public class StartResidentTest extends BaseTest{

    @BeforeTest
    public void residentTest(){
        androidELog.startLogcat();
    }
}
