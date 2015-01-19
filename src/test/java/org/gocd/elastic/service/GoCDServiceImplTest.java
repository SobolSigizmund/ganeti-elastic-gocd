package org.gocd.elastic.service;

import com.google.inject.Inject;
import org.gocd.elastic.api.GoCDApi;
import org.gocd.elastic.helper.Settings;
import org.gocd.elastic.model.Agent;
import org.jukito.JukitoRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JukitoRunner.class)
public class GoCDServiceImplTest {

    @Inject
    private GoCDServiceImpl goCDService;

    @Test
    public void shouldReturnTrueIfServerIsGood(GoCDApi goCDApi, Settings settings) throws Exception {
        when(goCDApi.idleAgents()).thenReturn(Arrays.asList(new Agent(),new Agent(), new Agent()));
        when(settings.get("Threshold")).thenReturn("2");

        boolean status = goCDService.isServerGood();
        
        verify(goCDApi).idleAgents();
        verify(settings).get("Threshold");

        assertTrue(status);
    }

    @Test
    public void shouldReturnFalseIfServerHasLessAgents(GoCDApi goCDApi, Settings settings) throws Exception {
        when(goCDApi.idleAgents()).thenReturn(Arrays.asList(new Agent()));
        when(settings.get("Threshold")).thenReturn("2");

        boolean status = goCDService.isServerGood();

        verify(goCDApi).idleAgents();
        verify(settings).get("Threshold");

        assertFalse(status);
    }
}