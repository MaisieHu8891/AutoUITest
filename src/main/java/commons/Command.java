package commons;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * 执行命令行，可用于adb logcat抓取崩溃log等
 */
public class Command {
    private String[] cmd;
    private ProcessHandle processHandle;

    public Command(String[] str) {
        cmd=str;
    }

    /**
     * 只执行命令，结果不做处理
     */
    public void exeCmd() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(cmd).inheritIO();
            processHandle= processBuilder.start().toHandle();
            LoggerConf.logobject.info("exeCmd启动的进程pid是："+processHandle.pid());
        } catch (IOException e) {
            LoggerConf.logobject.severe("exeCmd失败: "+e.getMessage());
        }
    }

    public void quitCmd(){
        LoggerConf.logobject.info("exeCmd要退出的进程pid是： "+processHandle.pid());
        Stream<ProcessHandle> childProcess = processHandle.children();
        childProcess.peek(cp -> LoggerConf.logobject.info("exeCmd要退出的子进程pid是："+cp.pid())).forEach(cp -> cp.destroy());
        processHandle.destroy();

    }

}
