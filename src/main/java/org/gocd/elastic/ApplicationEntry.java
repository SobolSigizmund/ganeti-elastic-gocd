package org.gocd.elastic;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.gocd.elastic.helper.Logger;
import org.gocd.elastic.injector.AppInjector;
import org.gocd.elastic.service.GoCDService;

import java.util.Timer;
import java.util.TimerTask;

public class ApplicationEntry {

    private static GoCDService goCDService;


    public static void main(String[] args){

        Injector injector = Guice.createInjector(new AppInjector());
        goCDService = injector.getInstance(GoCDService.class);
        Logger logger = injector.getInstance(Logger.class);

        logger.log("Starting service");

        Timer timer = new Timer();
        int minutes = 2;
        TimerTask scheduledTimerTask = new TimerTask() {
            @Override
            public void run() {
                goCDService.isServerGood();
            }
        };

        timer.schedule(scheduledTimerTask,0l,minutes*60*1000);
    }
}
