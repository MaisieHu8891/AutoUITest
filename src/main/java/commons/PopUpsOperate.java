package commons;

import io.appium.java_client.AppiumDriver;

import java.util.Observable;
import java.util.Observer;

public class PopUpsOperate implements Observer {
    private AppiumDriver<?> driver;

    @Override
    public void update(Observable observable, Object arg) {
        if(observable instanceof PopUpsCheck){
            PopUpsCheck popUpsCheck = (PopUpsCheck)observable;
            driver = popUpsCheck.getDriver();
            driver.findElementByXPath((String)arg).click();
        }

    }
}
