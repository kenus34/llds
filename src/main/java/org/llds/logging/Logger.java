package org.llds.logging;

import lombok.AllArgsConstructor;
import org.llds.logging.appender.Appender;

@AllArgsConstructor
public abstract class Logger {

    protected LoggingHelper loggingHelper;
    protected Logger next;
    private void write(Appender appender, String s){
        appender.write(s);
    }
    public abstract void write(String s, String cname, LogType logType);
}
