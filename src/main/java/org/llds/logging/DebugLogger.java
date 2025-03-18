package org.llds.logging;

public class DebugLogger extends Logger {
    public DebugLogger(LoggingHelper loggingHelper, Logger next) {
        super(loggingHelper, next);
    }

    @Override
    public void write(String s, String cname, LogType logType) {
        if(next==null){
            return;
        }
        if(logType == LogType.INFO){
            loggingHelper.getAppender(cname).write("debug: "+s);
        }
        next.write(s, cname, logType);
    }
}
