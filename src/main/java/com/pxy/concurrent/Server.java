package com.pxy.concurrent;

import com.pxy.concurrent.client.MessageUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
public class Server implements Runnable {
    ServerSocket serverSocket;
    volatile boolean keepProcessing = true;
    public Server(int port, int millisecondsTimeout) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(millisecondsTimeout);
    }

    public void run() {
        System.out.printf("Server Starting\n");
        while (keepProcessing) {
            try {
                System.out.printf("accepting client\n");
                Socket socket = serverSocket.accept();
                System.out.printf("got client\n");
                process(socket);
            } catch (Exception e) {
                handle(e);
            }
        }
    }

    private void handle(Exception e) {
        if (!(e instanceof SocketException)) {
            e.printStackTrace();
        }
    }

    public void stopProcessing() {
        keepProcessing = false;
        closeIgnoringException(serverSocket);
    }

    //非线程版本，吞吐量低
    public void process(Socket socket) {
        if (socket == null)
            return;
        try {
            System.out.printf("Server: getting message\n");
            String message = MessageUtils.getMessage(socket);
            System.out.printf("Server: got message: %s\n", message);
            Thread.sleep(1000);
            System.out.printf("Server: sending reply: %s\n", message);
            MessageUtils.sendMessage(socket, "Processed: " + message);
            System.out.printf("Server: sent\n");
            closeIgnoringException(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //线程版本，违反了单一权责原则，包括管理客户端、消息处理、线程策略、服务器关闭策略
    //且多线程代码与非多线程代码耦合，不易定位问题
    public void processByThread(Socket socket) {
        if (socket == null)
            return;
        //在一个socketServer中使用多个线程处理客户端发过来的消息，出现了java.io.StreamCorruptedException: invalid stream header: 77050003，java.io.StreamCorruptedException: invalid type code: 36
        //但使用一个线程处理客户端发过来的消息，比不使用线程形式，效率提高了很多倍。难道SocketServer自动创建很多线程来处理？一旦达到JVM上线，服务就会崩溃。
        Runnable clientHandler = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.printf("Server: getting message\n");
                    String message = MessageUtils.getMessage(socket);
                    System.out.printf("Server: got message: %s\n", message);
                    Thread.sleep(1000);
                    System.out.printf("Server: sending reply: %s\n", message);
                    MessageUtils.sendMessage(socket, "Processed: " + message);
                    System.out.printf("Server: sent\n");
                    closeIgnoringException(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread clientHandlerThread1 = new Thread(clientHandler);
        clientHandlerThread1.start();
//        Thread clientHandlerThread2 = new Thread(clientHandler);
//        clientHandlerThread2.start();
    }

    private void closeIgnoringException(Socket socket) {
        if (socket != null)
            try {
                socket.close();
            } catch (IOException ignore) {
            }
    }

    private void closeIgnoringException(ServerSocket serverSocket) {
        if (serverSocket != null)
            try {
                serverSocket.close();
            } catch (IOException ignore) {
            }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(8002,100000);
            Thread serverThread1 = new Thread(server);
//            Thread serverThread2 = new Thread(server);
            serverThread1.start();
//            serverThread2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
