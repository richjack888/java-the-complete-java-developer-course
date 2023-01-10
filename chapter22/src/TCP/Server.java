package TCP;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        System.out.println("TCP.Server start!");
        try (ServerSocket serverSocket = new ServerSocket(5688)) {
            while (true) {
                new Echoer(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("TCP.Server exception: " + e.getMessage());
        }

        System.out.println("TCP.Server shutdown!");
    }
}
