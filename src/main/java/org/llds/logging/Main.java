package org.llds.logging;

import org.llds.logging.appender.FileAppender;
import org.llds.logging.appender.NetworkAppender;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        LoggingHelper loggingHelper = new LoggingHelper(new HashMap<>(), new FileAppender());
        loggingHelper.map.put("abc", new FileAppender());
        loggingHelper.map.put("abc.ncx", new NetworkAppender());
        InfoLogger infoLogger = new InfoLogger(loggingHelper, new DebugLogger(loggingHelper, null));
        infoLogger.write("infolog", "abc", LogType.DEBUG);
    }
}
