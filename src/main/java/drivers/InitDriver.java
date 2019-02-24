package drivers;

import commons.LoggerConf;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 连接appium手机客户端,并返回driver
 **/
public class InitDriver {
    private static class InitDriverHolder {
        private static final InitDriver INSTANCE = new InitDriver();
    }

    public static AppiumDriver<? extends WebElement> thisDriver;

    private InitDriver() {
        GlobalConfig globalConfig = GlobalConfig.load("/Global_Conf.yml");
        try {

            HashMap<String, Object> android_emu01 = globalConfig.Appium.ANDROID_emu01;
            String driverHost = globalConfig.Appium.HOST;
            int implicitlyWaitTime = globalConfig.Appium.IMPLICITLYWAIT;

            Set<Map.Entry<String, Object>> infos = android_emu01.entrySet();
            DesiredCapabilities caps = new DesiredCapabilities();
            for (Map.Entry i : infos) {
                caps.setCapability((String) i.getKey(), i.getValue());
            }
            thisDriver = new AppiumDriver<>(new URL(driverHost), caps);
            thisDriver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);

        } catch (IOException e) {
            LoggerConf.logobject.severe("初始化driver失败");
        }
    }

    public static final InitDriver getInstance() {
        return InitDriverHolder.INSTANCE;
    }

}


