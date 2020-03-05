package com.pxy.concurrent.client;

import com.pxy.concurrent.client.ClientRequestProcessor;

public interface ClientScheduler {
    public void schedule(ClientRequestProcessor requestProcessor);
}
