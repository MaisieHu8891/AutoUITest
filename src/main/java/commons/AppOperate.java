package commons;

import drivers.GlobalConfig;
import drivers.InitDriver;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
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
     * 封装定位方法
     */
    public WebElement locateElement(String element) {
        WebElement webElement = null;
        for (int i = 1; i <= findTimes; i++) {
            try {
                if (element.matches("\\/\\/.*")) {
                    webElement = driver.findElementByXPath(element);
                } else if (element.matches("com.*")) {
                    webElement = driver.findElementById(element);
                }
            } catch (Exception e) {
                LoggerConf.logobject.info("找不到" + element + "检查是否有黑名单窗口..." + i + "次");
                PopWindowsCheck popUpsCheck = new PopWindowsCheck(driver);
                popUpsCheck.check();
            }

            if (webElement != null) {
                break;
            }
        }
        return webElement;
    }


    /**
     * 等待元素加载，位置稳定后，准确操作
     */
    public void exactOp(WebElement webElement, Op op, Object... args) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        int i = 0;
        while (webElement != null) {
            int local = wait.until(ExpectedConditions.elementToBeClickable(webElement)).getLocation().hashCode();
            if (i != local) {
                LoggerConf.logobject.info(String.valueOf(local));
                i = local;
                continue;
            } else {
                break;
            }
        }
        if (webElement != null) {
            switch (op) {
                case CLICK:
                    webElement.click();
            }
        }
    }

    /**
     * 根据相对坐标点击， 处理模态弹框需要
     */
    public void clickWithXY(WebElement parentElement,Integer x, Integer y){

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
