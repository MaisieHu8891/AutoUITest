package commons;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class LoggerConf {
    public static java.util.logging.Logger logobject = java.util.logging.Logger.getLogger("logobject ");

    static class LogFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return "<" + record.getLevel() + ">___" + record.getMessage() + "\n";
        }
    }

    static {
        Level defaultlevel = Level.ALL;
        logobject.setLevel(defaultlevel);
        FileHandler fh = null;
        try {
            fh = new FileHandler("..\\AutoUITest\\out\\ProjectLogFile.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        fh.setFormatter(new LogFormatter());
        logobject.addHandler(fh);
    }
}
