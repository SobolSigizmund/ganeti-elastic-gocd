package org.gocd.elastic.api;

import com.google.inject.Singleton;
import org.gocd.elastic.model.Agent;

import java.util.List;

@Singleton
public class GoCDApiImpl implements GoCDApi {
    @Override
    public List<Agent> listAgents() {
        return null;
    }

    @Override
    public void enableAgent(String uuid) {
        System.out.println(uuid);
    }

    @Override
    public void disableAgent(String uuid) {

    }

    @Override
    public Agent getAgent(String uuid) {
        return null;
    }

    @Override
    public List<Agent> idleAgents() {
        return null;
    }
}
