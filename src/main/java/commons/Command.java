package commons;

import java.io.IOException;
import java.util.List;

/**
 * 执行命令行，可用于adb logcat抓取崩溃log等
 */
public class Command {
    private List<String> cmd;
    private Process process;

    public Command(String ...str) {
        for(String s :str){
            cmd.add(s);
        }
    }

    /**
     * 只执行命令，结果不做处理
     */
    public void exeCmd(){
        try {
            process = new ProcessBuilder(cmd).start();
        } catch (IOException e) {
            LoggerConf.logobject.severe(e.getMessage());
        }
    }

    public void quitCmd(){
        process.destroy();
    }

}
