package Commons;

import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.util.Map;

public class YamlOps {
    private String confFilePath;

    public YamlOps(String confFilePath) {
        this.confFilePath = confFilePath;
    }

    public Map<String, Object> getContent() throws IOException {
        /**
         * 获取yaml文件的整体的内容，返回Map<String, Object>
         */
        InputStream input = null;
        try {
            input = new FileInputStream(new File(confFilePath));
        } catch (FileNotFoundException e) {
            LoggerConf.logobject.severe("读取配置文件失败：" + confFilePath);
        }
        Yaml yaml = new Yaml();
        Map<String, Object> content = yaml.load(input);
        input.close();
        return content;
    }

}
