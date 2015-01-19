package org.gocd.elastic.service;

import com.google.inject.Inject;
import org.jukito.JukitoRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JukitoRunner.class)
public class GoCDServiceImplTest {

    @Inject
    private GoCDService goCDService;

    @Test
    public void shouldReturnTrueIfServerIsGood() throws Exception {

    }
}