package com.pxy.concurrent;

import com.pxy.concurrent.client.MessageUtils;

import java.net.Socket;

public class Client implements Runnable {

    private static final int PORT = 8002;

    @Override
    public void run() {
        System.out.printf("Client Starting\n");
        connectSendReceive(666);
    }

    private void connectSendReceive(int i) {
        try {
            Socket socket = new Socket("localhost", PORT);
            MessageUtils.sendMessage(socket, Integer.toString(i));
            MessageUtils.getMessage(socket);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
