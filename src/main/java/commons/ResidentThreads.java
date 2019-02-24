package commons;

import io.appium.java_client.AppiumDriver;

public class ResidentThreads {

    private static AppiumDriver<?> driver;
    public static Thread popUpsCheckThread;
    public static Thread androidLogThread;

    private static class BaseTestHolder {
        private static final ResidentThreads INSTANCE = new ResidentThreads();
    }

    private ResidentThreads() {
        PopUpsCheck popUpsCheck = new PopUpsCheck(this.driver);
        this.popUpsCheckThread = new Thread(popUpsCheck);
        AndroidELog androidELog = new AndroidELog();
        this.androidLogThread = new Thread(androidELog);
    }

    public static final ResidentThreads getInstance(AppiumDriver<?> driver ) {
        ResidentThreads.driver = driver;
        return BaseTestHolder.INSTANCE;
    }
}