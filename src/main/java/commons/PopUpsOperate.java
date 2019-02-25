package commons;

import io.appium.java_client.AppiumDriver;

import java.util.Observable;
import java.util.Observer;

public class PopUpsOperate implements Observer {

    @Override
    public void update(Observable observable, Object arg) {
        if(observable instanceof PopUpsCheck){
            PopUpsCheck popUpsCheck = (PopUpsCheck)observable;
            AppiumDriver<?> driver = popUpsCheck.getDriver();
            driver.findElementByXPath((String)arg).click();
            LoggerConf.logobject.info("BlackWindow Click: "+arg);
        }

    }
}
