package com.pxy.concurrent.client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientConnection {
    private Socket socket;
    private ServerSocket serverSocket;

    public ClientConnection(int port, int millisecondsTimeout) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(millisecondsTimeout);
        System.out.printf("Server Starting\n");
    }
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

}
