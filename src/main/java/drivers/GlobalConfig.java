package drivers;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;


public class GlobalConfig {

    public AppiumConfig appiumConfig;
    public PandaAndroidConfig pandaAndroidConfig;

    static public GlobalConfig load(String path) {
        Yaml yaml = new Yaml();
        InputStream inputStream = GlobalConfig.class.getResourceAsStream(path);
        return yaml.loadAs(inputStream,GlobalConfig.class);
    }

}
