package org.llds.logging;

import org.llds.logging.appender.Appender;

import java.util.Map;

public class LoggingHelper {
    Map<String, Appender> map;
    private Appender defaultConfig;

    public Appender getAppender(String s){
        Appender appenderConfig = map.get(s);
        if(s.length()==0){
            return defaultConfig;
        }
        if(null!=appenderConfig){
            return appenderConfig;
        }
        int lindex=s.lastIndexOf('.');
        return getAppender(s.substring(0, lindex==-1?0:lindex));
    }
}
