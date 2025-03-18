package org.llds.logging.appender;

public class NetworkAppender implements Appender{
    @Override
    public void write(String s) {
        System.out.println("Network appender "+s);
    }
}
