package util;

import drivers.GlobalConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AppOperate {
    private AppiumDriver<?> driver;
    private int waitTime;
    private int findTimes;
    private int backGroundTime;
    private String imagePath;

    //相对元素：点击，向上、下滑屏；向上、下、左右滚动；
    public enum Op {
        CLICK, SCROLLUP, SCROLLDOWN, SCROLLRIGHT, SCROLLLEFT
    }

    public AppOperate(AppiumDriver<?> driver) {
        this.driver = driver;
        GlobalConfig globalConfig = GlobalConfig.load("/Global_Conf.yml");
        waitTime = globalConfig.PandaAndroid.WAITUTIL;
        findTimes = globalConfig.PandaAndroid.FINDTIMES;
        backGroundTime = globalConfig.PandaAndroid.BACKGROUNDTIME;
        imagePath = globalConfig.PandaAndroid.IMGPATH;
    }

    /**
     * 手机端封装定位方法
     */
    public MobileElement locateElement(String element) {
        MobileElement mobileElement = null;
        for (int i = 1; i <= findTimes; i++) {
            try {
                if (element.matches("\\/\\/.*")) {
                    mobileElement = (MobileElement) driver.findElementByXPath(element);
                } else if (element.matches("com.*")) {
                    mobileElement = (MobileElement) driver.findElementById(element);
                }
            } catch (Exception e) {
                LoggerConf.logobject.info("找不到" + element + "检查是否有黑名单窗口..." + i + "次");
                PopWindowsCheck popUpsCheck = new PopWindowsCheck(driver);
                popUpsCheck.check();
            }

            if (mobileElement != null) {
                break;
            }
        }
        return mobileElement;
    }


    /**
     * 等待元素加载，位置稳定后，准确操作
     */
    public void exactOp(MobileElement mobileElement, Op op, Object... args) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        int i = 0;
        while (mobileElement != null) {
            int local = wait.until(ExpectedConditions.elementToBeClickable(mobileElement)).getLocation().hashCode();
            if (i != local) {
                LoggerConf.logobject.info(String.valueOf(local));
                i = local;
                continue;
            } else {
                break;
            }
        }
        if (mobileElement != null) {
            switch (op) {
                case CLICK:
                    mobileElement.click();
            }
        }
    }

    /**
     * 根据相对坐标点击， 处理模态弹框需要
     * 传参x= 实际元素x/屏幕总x   y=实际元素y/屏幕总y
     * parentElement可以为null
     */
    public void clickWithXY(Integer x, Integer y, String parentElement){
        x = x*driver.manage().window().getSize().width;
        y = y*driver.manage().window().getSize().height;
        if(parentElement!=null){
            MobileElement mobileElement = locateElement(parentElement);
            exactOp(mobileElement,Op.CLICK);
        }
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(x,y));
    }


    /**
     * 重启app，不清除缓存及数据
     */
    public void restartApp() {
        driver.closeApp();
        try {
            driver.runAppInBackground(Duration.ofSeconds(1));
        } catch (Exception e) {
            LoggerConf.logobject.severe("无法启动app");
        }
    }

    /**
     * 回到app首页-非星颜星秀
     */
    public void backToAppIndex() {
        //while (driver.findElementsByXPath())

    }

    /**
     * 在后台运行app一段时间
     */
    public void backGroundRun() {
        driver.runAppInBackground(Duration.ofSeconds(backGroundTime));
    }

    /**
     * 截屏
     */
    public void getScreenImage() {
        File file = new File(imagePath + System.currentTimeMillis() + ".jpeg");
        File newFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(newFile, file);
        } catch (IOException e) {
            LoggerConf.logobject.severe("截图失败");
        }
    }


}
