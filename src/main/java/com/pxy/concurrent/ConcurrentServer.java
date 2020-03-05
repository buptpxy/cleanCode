package com.pxy.concurrent;

import com.pxy.concurrent.client.*;

import java.io.IOException;
import java.net.SocketTimeoutException;

//为每个权责（包括线程管理权责）创建单独的类后的改进版本
public class ConcurrentServer implements Runnable {
    volatile boolean keepProcessing = true;
    ConnectionManager connectionManager;
    ClientScheduler clientScheduler;
    public ConcurrentServer(int port, int millisecondsTimeout) throws IOException {
        connectionManager = new ConnectionManager(port,millisecondsTimeout);
        clientScheduler = new ThreadPerRequestScheduler();
    }
    @Override
    public void run() {
        while (keepProcessing) {
            try {
                ClientConnection clientConnection = connectionManager.awaitClient();
                ClientRequestProcessor requestProcessor = new ClientRequestProcessor(clientConnection);
                clientScheduler.schedule(requestProcessor);
            } catch (Exception e) {
                handle(e);
            }
        }
        connectionManager.shutdownSocket();
    }

    private void handle(Exception e) {
        if (!(e instanceof SocketTimeoutException)) {
            e.printStackTrace();
        }else {
            stopProcessing();
        }
    }

    public void stopProcessing() {
        keepProcessing = false;
        connectionManager.shutdownServerSocket();
    }

    public static void main(String[] args) {
        try {
            ConcurrentServer concurrentServer = new ConcurrentServer(8002,100000);
            Thread concurrentServerThread = new Thread(concurrentServer);
            concurrentServerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
