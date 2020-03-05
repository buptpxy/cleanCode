package com.pxy.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientTests {
    @Test(timeout = 2000)
    public void shouldRunInOneSecends() {
        int threadCount = 6;
        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
        startAllThreadmessages(threadPool,threadCount);
        waitForAllThreadsToFinish(threadPool);
    }

    private void startAllThreadmessages(ExecutorService threadPool,int threadCount) {
        Client client = new Client();
        for (int i = 0; i < threadCount; i++) {
            threadPool.submit(client);
        }
        threadPool.shutdown();
    }

    private void waitForAllThreadsToFinish(ExecutorService threadPool) {
        while (true) {
            if (threadPool.isTerminated()) {
                System.out.println("线程都已关闭！");
                break;
            }
        }
    }


}
