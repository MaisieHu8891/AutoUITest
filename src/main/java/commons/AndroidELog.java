package commons;


public class AndroidELog {
    private String[] cmd;
    private Command command;

    public AndroidELog() {
        String logfilepath = "./out/ErrLogcat_";
//        cmd= new String[]{"cmd","/c","adb", "logcat","AndroidRuntime:E","CrashReport:E","*:S",">>",logfilepath+System.currentTimeMillis()+".log"};
        cmd = new String[]{"cmd", "/c", "adb", "logcat", ">>", logfilepath + System.currentTimeMillis() + ".log"};//调试用此命令
        command = new Command(cmd);
    }

    public void startLogcat() {
        command.exeCmd();
    }

    public void stopLogcat() {
        command.quitCmd();
    }
}
