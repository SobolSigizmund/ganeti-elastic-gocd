package org.gocd.elastic.injector;

import com.google.inject.AbstractModule;
import org.gocd.elastic.api.GoCDApi;
import org.gocd.elastic.api.GoCDApiImpl;
import org.gocd.elastic.helper.ConsoleLogger;
import org.gocd.elastic.helper.Logger;
import org.gocd.elastic.helper.Settings;
import org.gocd.elastic.helper.SettingsImpl;
import org.gocd.elastic.service.GoCDService;
import org.gocd.elastic.service.GoCDServiceImpl;

public class AppInjector extends AbstractModule {
    @Override
    protected void configure() {
        bind(GoCDService.class).to(GoCDServiceImpl.class);
        bind(GoCDApi.class).to(GoCDApiImpl.class);
        bind(Settings.class).to(SettingsImpl.class);
        bind(Logger.class).to(ConsoleLogger.class);
    }
}
