package util;

import drivers.GlobalConfig;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * 检查到有WINDOW_BLACK的弹框，有就点击的元素
 */
public class PopWindowsCheck {

    private AppiumDriver<?> driver;
    private ArrayList<String> windowBlack;

    public PopWindowsCheck(AppiumDriver<?> driver) {
        this.driver = driver;
        GlobalConfig globalConfig = GlobalConfig.load("/Global_Conf.yml");
        windowBlack = globalConfig.PandaAndroid.WINDOW_BLACK;

    }

    public void check() {
        for (String s : windowBlack) {
            try {
                WebElement webElement = driver.findElementByXPath(s);
                if (webElement != null) {
                    driver.findElementByXPath(s).click();
                }
            } catch (Exception e) {
                LoggerConf.logobject.info("检查黑名单弹框: "+e.getMessage());
            }
        }
    }
}