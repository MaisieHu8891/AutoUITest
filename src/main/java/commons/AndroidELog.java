package commons;



public class AndroidELog implements Runnable  {
    private String logfilepath;
    private String cmd;
    private Command command;

    public AndroidELog() {
        logfilepath = "./out/ErrLogcat_";
//        cmd= "adb logcat AndroidRuntime:E CrashReport:E *:S>>"+logfilepath+System.currentTimeMillis()+".log";//只输出dump信息
        cmd = "cmd /c adb logcat>>" + logfilepath + System.currentTimeMillis() + ".log";//调试用此命令

        command = new Command(cmd);
    }

    @Override
    public void run() {
        command.exeCmd();
    }
}
