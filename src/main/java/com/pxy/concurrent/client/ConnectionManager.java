package com.pxy.concurrent.client;

import com.pxy.concurrent.client.ClientConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionManager {
    ClientConnection clientConnection;
    public ConnectionManager(int port, int millisecondsTimeout) throws IOException {
        clientConnection = new ClientConnection(port,millisecondsTimeout);
    }

    public ClientConnection awaitClient() throws IOException {
        System.out.printf("accepting client\n");
        ServerSocket serverSocket = clientConnection.getServerSocket();
        Socket socket = serverSocket.accept();
        clientConnection.setSocket(socket);
        System.out.printf("got client\n");
        return clientConnection;
    }

    public void shutdownSocket() {
        if (clientConnection.getSocket() != null)
            try {
                clientConnection.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println("socket is closed!");
    }

    public void shutdownServerSocket() {
        if (clientConnection.getServerSocket() != null)
            try {
                clientConnection.getServerSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("serverSocket is closed!");
    }

}
