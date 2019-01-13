package commons;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class AppOperate {
    private AppiumDriver<?> driver;
    private int waitTime;
    private int backGroundTime;
    private String imagePath;

    //相对元素：点击，向上、下滑屏；向上、下、左右滚动；
    public enum Op {
        CLICK, UPorDOWN, SCROLLUP, SCROLLDOWN, SCROLLRIGHT, SCROLLLEFT
    }

    public AppOperate(AppiumDriver<?> driver) {
        this.driver = driver;
        YamlOps utilConf = new YamlOps("..\\AutoUITest\\src\\main\\resources\\Util_Conf.yml");
        try {
            Map<String, Object> utilContent = utilConf.getContent();
            waitTime = (int) utilContent.get("WAITUTIL");
            backGroundTime = (int) utilContent.get("BACKGROUNDTIME");
            imagePath = (String) utilContent.get("IMGPATH");
        } catch (IOException e) {
            LoggerConf.logobject.severe("获取Util_Conf配置文件内容失败");
        }
    }

    /**
     * 封装定位方法
     */
    public WebElement locateElement(String element) {

        if (element.matches("\\/\\/.*")) {
            return driver.findElementByXPath(element);
        } else if (element.matches("com.*")) {
            return driver.findElementById(element);
        } else {
            return null;
        }

    }

    /**
     * 等待元素加载，位置稳定后，准确操作
     */
    public void exactOp(WebElement webElement, Op op, Object... args) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        int i = 0;
        while (true) {
            int local = wait.until(ExpectedConditions.elementToBeClickable(webElement)).getLocation().hashCode();
            if (i != local) {
                LoggerConf.logobject.info(String.valueOf(local));
                i = local;
                continue;
            } else {
                break;
            }
        }
        TouchActions action = new TouchActions(driver);
        switch (op) {
            case CLICK:
                webElement.click();
            case UPorDOWN:
                action.flick(webElement, 0, (int)args[0], 0);
                action.perform();
        }

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