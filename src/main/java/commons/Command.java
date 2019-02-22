package commons;

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
            Runtime.getRuntime().exec(cmd);
            System.out.print(11);
        } catch (Exception e) {
            LoggerConf.logobject.severe("exeCmd异常");
            e.printStackTrace();
        }
    }

}
