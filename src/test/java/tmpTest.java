import Commons.InitDriver;
import io.appium.java_client.AppiumDriver;

public class tmpTest {

    public static void main(String[] args) {
        InitDriver.getInstance();
        AppiumDriver driver = InitDriver.thisDriver;
    }
}
