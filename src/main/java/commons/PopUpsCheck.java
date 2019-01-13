package commons;

import io.appium.java_client.AppiumDriver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;

/**
 * 后台线程一直跑，检查到有弹窗，就notify, 同时带上要点击的元素
 */
public class PopUpsCheck extends Observable implements Runnable {

    private AppiumDriver<?> driver;
    private ArrayList<String> windowBlack;

    public PopUpsCheck(AppiumDriver<?> driver){
        this.driver = driver;
        YamlOps utilConf = new YamlOps("..\\AutoUITest\\src\\main\\resources\\Util_Conf.yml");
        try {
            Map<String, Object> utilContent = utilConf.getContent();
            windowBlack = (ArrayList<String>) utilContent.get("WINDOW_BLACK");
        } catch (IOException e) {
            LoggerConf.logobject.severe("获取Util_Conf配置文件内容失败");
        }
    }

    public AppiumDriver<?> getDriver() {
        return driver;
    }

    @Override
    public void run() {
        for (String s : windowBlack){
            if (driver.findElementsByXPath(s) != null){
                setChanged();
                notifyObservers(s);
            }
        }
        clearChanged();

    }
}