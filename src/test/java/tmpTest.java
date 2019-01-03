import Commons.InitDriver;
import io.appium.java_client.android.AndroidDriver;

public class tmpTest {

    public static void main(String[] args) {
        InitDriver.getInstance();
        AndroidDriver driver = InitDriver.androidDriver;
    }
}
