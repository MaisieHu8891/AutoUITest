package Commons;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.Observable;

/**
 * 后台线程一直跑，检查到有弹窗，就notify, 同时带上要点击的元素
 */
public class PopUpsStatus extends Observable {
    private AppiumDriver<?> driver;
    private WebElement element;
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
