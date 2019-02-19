package drivers;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;


public class GlobalConfig {
    //变量"Appium","PandaAndroid" 必须和配置文件对应上
    public AppiumConfig Appium;
    public PandaAndroidConfig PandaAndroid;


    static public GlobalConfig load(String path) {
        Yaml yaml = new Yaml();
        InputStream inputStream = GlobalConfig.class.getResourceAsStream(path); //path以/开头则是从ClassPath根下获取,不以/开头时默认是从此类所在的包下取资源
        return yaml.loadAs(inputStream, GlobalConfig.class);
    }

}
