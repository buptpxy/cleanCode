package com.pxy.concurrent.client;

import java.net.Socket;

public class ClientRequestProcessor {
    ClientConnection clientConnection;
    public ClientRequestProcessor(ClientConnection clientConnection) {
            this.clientConnection = clientConnection;
    }

    public void process() {
        Socket socket = clientConnection.getSocket();
        try {
            System.out.printf("Server: getting message\n");
            String message = MessageUtils.getMessage(socket);
            System.out.printf("Server: got message: %s\n", message);
            Thread.sleep(1000);
            System.out.printf("Server: sending reply: %s\n", message);
            MessageUtils.sendMessage(socket, "Processed: " + message);
            System.out.printf("Server: sent\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
