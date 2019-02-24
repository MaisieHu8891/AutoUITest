package commons;

import drivers.GlobalConfig;
import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * 后台线程一直跑，检查到有弹窗，就notify, 同时带上要点击的元素
 */
public class PopUpsCheck extends Observable implements Runnable {

    private AppiumDriver<?> driver;
    private ArrayList<String> windowBlack;
    private Observer observer;
    public static volatile boolean isCancel;

    public PopUpsCheck(AppiumDriver<?> driver) {
        this.driver = driver;
        isCancel = false;
        GlobalConfig globalConfig = GlobalConfig.load("Global_Conf.yml");
        windowBlack = globalConfig.PandaAndroid.WINDOW_BLACK;
        observer = new PopUpsOperate();

    }

    public AppiumDriver<?> getDriver() {
        return driver;
    }

    @Override
    public void run() {
        while (!isCancel) {
            for (String s : windowBlack) {
                if (driver.findElementsByXPath(s) != null) {
                    setChanged();
                    addObserver(observer);
                    notifyObservers(s);
                }
            }
        }
        clearChanged();
        deleteObserver(observer);
    }
}