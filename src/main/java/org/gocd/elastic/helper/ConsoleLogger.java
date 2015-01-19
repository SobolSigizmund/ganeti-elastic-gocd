package org.gocd.elastic.helper;

import com.google.inject.Singleton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Singleton
public class ConsoleLogger implements Logger {


    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");;

    @Override
    public void log(String message) {
        String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
        String output = "[" + "INFO" + "]" + "[" + timeStamp + "] " + message;
        System.out.println(output);
    }

    @Override
    public void error(String message) {
        String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
        String output = "[" + "ERROR" + "]" + "[" + timeStamp + "]" + message;
        System.err.println(output);
    }
}
