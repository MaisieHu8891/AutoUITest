package commons;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;

/**
 * 后台线程一直跑，检查到有弹窗，就notify, 同时带上要点击的元素
 */
public class PopUpsStatus extends Observable implements Runnable {
    private AppiumDriver<?> driver;
    private WebElement element;
    private ArrayList windowBlack;

    public PopUpsStatus(AppiumDriver<?> driver){
        this.driver = driver;
        YamlOps utilConf = new YamlOps("..\\AutoUITest\\src\\main\\resources\\Util_Conf.yml");
        try {
            Map<String, Object> utilContent = utilConf.getContent();
            windowBlack = (ArrayList) utilContent.get("WINDOW_BLACK");
        } catch (IOException e) {
            LoggerConf.logobject.severe("获取Util_Conf配置文件内容失败");
        }
    }


    @Override
    public void run() {

    }
//    private boolean changed = false;
//跑后台线程，出现弹框后调setchanged
//    @Override
//    protected synchronized void setChanged() {
//        changed = true;
//    }
//
//    @Override
//    public void notifyObservers(Object arg) {
//        if(changed){
//            update(arg);
//        }
//        changed=false;
//    }
}
