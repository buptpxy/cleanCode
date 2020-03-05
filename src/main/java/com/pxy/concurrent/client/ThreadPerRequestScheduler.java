package com.pxy.concurrent.client;

import com.pxy.concurrent.client.ClientRequestProcessor;
import com.pxy.concurrent.client.ClientScheduler;

public class ThreadPerRequestScheduler implements ClientScheduler {
    /**
     * 来一个请求就新建一个线程会出错
     * @param requestProcessor
     */
    public void schedule(final ClientRequestProcessor requestProcessor) {
        Runnable runnable = new Runnable() {
            public void run() {
                requestProcessor.process();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
