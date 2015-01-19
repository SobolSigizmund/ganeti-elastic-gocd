package org.gocd.elastic.api;

import org.gocd.elastic.model.Agent;
import org.json.simple.JSONObject;

import java.util.List;

public interface GoCDApi {
    public List<Agent> listAgents();
    public void enableAgent(String uuid);
    public void disableAgent(String uuid);
    public Agent getAgent(String uuid);
    List<Agent> idleAgents();
}
