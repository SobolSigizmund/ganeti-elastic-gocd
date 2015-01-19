package org.gocd.elastic.service;

import com.google.inject.Inject;
import org.gocd.elastic.api.GoCDApi;
import org.gocd.elastic.helper.Logger;
import org.gocd.elastic.helper.Settings;
import org.gocd.elastic.model.Agent;

import java.util.List;

public class GoCDServiceImpl implements GoCDService {
    private GoCDApi goCDApi;
    private Settings settings;
    private Logger logger;

    @Inject
    public GoCDServiceImpl(GoCDApi goCDApi, Settings settings, Logger logger) {
        this.goCDApi = goCDApi;
        this.settings = settings;
        this.logger = logger;
    }

    @Override
    public boolean isServerGood() {
        logger.log("Checking server status");

        List<Agent> agents = goCDApi.idleAgents();
        int threshold = Integer.parseInt(settings.get("threshold"));
        if(agents.size() > threshold ) {
            logger.log("Agents are ample.");
        } else if(agents.size() == threshold) {
            logger.log("Agents are enough.");
        } else {
            logger.log("Agents are deficit of threshold");
            return false;
        }

        return true;
    }
}
