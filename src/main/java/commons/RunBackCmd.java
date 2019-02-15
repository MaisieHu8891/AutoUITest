package commons;
public class RunBackCmd extends Command implements Runnable{

    public RunBackCmd(String cmd) {
        super(cmd);
    }

    @Override
    public void run() {
        super.exeCmd();

    }
}
