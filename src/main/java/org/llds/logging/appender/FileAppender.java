package org.llds.logging.appender;

public class FileAppender implements Appender{
    @Override
    public void write(String s) {
        System.out.println("File appender "+s);
    }
}
