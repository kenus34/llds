package org.llds.logging;

public class DebugLogger extends Logger {
    public DebugLogger(LoggingHelper loggingHelper, Logger next) {
        super(loggingHelper, next);
    }

    @Override
    public void write(String s, String cname, LogType logType) {
        if(logType == LogType.DEBUG){
            loggingHelper.getAppender(cname).write("debug: "+s);
        }
        if(next!=null){
            next.write(s, cname, logType);
        }
    }
}
