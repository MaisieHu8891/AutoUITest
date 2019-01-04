package Commons;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 连接appium手机客户端,并返回driver
 **/
public class InitDriver {
    private static class InitDriverHolder {
        private static final InitDriver INSTANCE = new InitDriver();
    }
    public static AppiumDriver thisDriver;

    private InitDriver() {
        YamlOps yamlOps = new YamlOps("..\\AutoUITest\\src\\main\\resources\\Driver_Conf.yml");
        try {
            Map<String, Object> content = yamlOps.getContent();
            LinkedHashMap driverInfo = (LinkedHashMap) content.get("Android_01");//System.out.print(driverinfo.getClass().getName());driverinfo 实际是java.util.LinkedHashMap类型
            String driverHost = (String) content.get("host");
            Set<Map.Entry<String, Object>> infos = driverInfo.entrySet();
            DesiredCapabilities caps = new DesiredCapabilities();
            for (Map.Entry i : infos) {
                caps.setCapability((String) i.getKey(), i.getValue());
            }
            thisDriver = new AppiumDriver(new URL(driverHost), caps);

        } catch (IOException e) {
            LoggerConf.logobject.severe("获取配置文件内容异常");
        }

    }

    public static final InitDriver getInstance() {
        return InitDriverHolder.INSTANCE;
    }

}


