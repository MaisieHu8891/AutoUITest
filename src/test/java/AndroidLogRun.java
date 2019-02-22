import drivers.AndroidELog;
import org.testng.annotations.Test;

public class AndroidLogRun {
    @Test
    public void androidLogRun(){
            AndroidELog androidELog = new AndroidELog();
            new Thread(androidELog).start();
    }

}
