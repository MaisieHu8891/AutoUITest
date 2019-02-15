package commons;

import java.io.IOException;

/**
 * 执行命令行，可用于adb logcat抓取崩溃log等
 */
public class Command {
    private String cmd;

    public Command(String cmd) {
        this.cmd = cmd;
    }

    /**
     * 只执行命令，结果不做处理
     */
    public void exeCmd(){
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            System.out.print(11);
        } catch (Exception e) {
            LoggerConf.logobject.severe("exeCmd异常");
            e.printStackTrace();
        }

    }


}
